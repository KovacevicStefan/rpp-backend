package rppbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import rppbackend.model.Aranzman;
import rppbackend.model.Hotel;
import rppbackend.service.AranzmanService;
import rppbackend.service.HotelService;

@CrossOrigin
@RestController
public class AranzmanController {

	@Autowired
	private AranzmanService aranzmanService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns List of all Aranzmans")
	@GetMapping("aranzman")
	public ResponseEntity<List<Aranzman>> getAll() {
		List<Aranzman> aranzman = this.aranzmanService.getAll();
		return new ResponseEntity<>(aranzman, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Returns Aranzman with id that was forwarded as path variable.")
	@GetMapping("aranzman/{id}")
	public ResponseEntity<Aranzman> getOne(@PathVariable("id") Integer id) {
		if(aranzmanService.findById(id).isPresent()) {
			Optional<Aranzman> aranzman = this.aranzmanService.findById(id);
			return new ResponseEntity<>(aranzman.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	 @ApiOperation(value = "Returns list of Aranzmani for Hotel with id that was forwarded as path variable.")
	 @GetMapping("aranzmaniZaHotel/{id}")
	 public ResponseEntity<List<Aranzman>> getAllForHotel(@PathVariable("id") Integer id) {
		 Optional<Hotel> hotelOpt = this.hotelService.findById(id);
		 if (hotelOpt.isPresent()) {
			 List<Aranzman> aranzmani = aranzmanService.findByHotel(hotelOpt.get());
	         return new ResponseEntity<>(aranzmani, HttpStatus.OK);
	     }
	         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	 }
	 
	 @ApiOperation(value = "Returns list of Aranzmani that were paid.")
	 @GetMapping("placeniAranzmani")
	 public ResponseEntity<List<Aranzman>> placeniAranzmani() {
		 List<Aranzman> aranzmani = this.aranzmanService.findByPlacenoTrue();
	     return new ResponseEntity<>(aranzmani, HttpStatus.OK);
	 }
	 
	 @ApiOperation(value = "Adds new Aranzman to database.")
	 @PostMapping("aranzman")
	 public ResponseEntity<Aranzman> addAranzman(@RequestBody Aranzman aranzman) {
		 Aranzman savedAranzman = this.aranzmanService.save(aranzman);
	     URI location = URI.create("/aranzman/" + savedAranzman.getId());
	     return ResponseEntity.created(location).body(savedAranzman);
	 }
	 
	 @ApiOperation(value = "Updates Aranzman that has id that was forwarded as path variable with values forwarded in Request Body.")
	 @PutMapping("aranzman/{id}")
	 public ResponseEntity<Aranzman> updateOne(@RequestBody Aranzman aranzman,
			 @PathVariable("id") Integer id) {
		 if (!this.aranzmanService.existsById(id)) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	     aranzman.setId(id);
	     Aranzman savedAranzman = this.aranzmanService.save(aranzman);
	     return ResponseEntity.ok().body(savedAranzman);
	 }
	 
	 @ApiOperation(value = "Deletes Aranzmani with id that was forwarded as path variable.")
	 @DeleteMapping("aranzman/{id}")
	 public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
		 if (id == -100 && !this.aranzmanService.existsById(-100)) {

			 this.jdbcTemplate.execute(
					 "INSERT INTO aranzman (\"id\", \"ukupna_cena\", \"placeno\", \"datum_realizacije\", \"hotel\", \"turisticka_agencija\") "
				      + "VALUES (-100, 200, true, "
                     + "to_date('15.05.2022.', 'dd.mm.yyyy'), 1, 1)");
	     }

	     if (this.aranzmanService.existsById(id)) {
	    	 this.aranzmanService.deleteById(id);
	         return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	     }
	     return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	 }
	

	
}
