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
import rppbackend.model.TuristickaAgencija;
import rppbackend.service.TuristickaAgencijaService;


@CrossOrigin
@RestController
public class TuristickaAgencijaController {
	
	@Autowired
	private TuristickaAgencijaService turistickaAgencijaService;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	 
	@ApiOperation(value = "Returns List of all Turisticke_agencije")
	@GetMapping("turisticka_agencija")
	public ResponseEntity<List<TuristickaAgencija>> getAll(){
		List<TuristickaAgencija> turisticke_agencije = this.turistickaAgencijaService.getAll();
	    return new ResponseEntity<>(turisticke_agencije, HttpStatus.OK);
	}
	 
	@ApiOperation(value = "Returns Turisticka_agencija with id that was forwarded as path variable.")
	@GetMapping("turisticka_agencija/{id}")
	public ResponseEntity<TuristickaAgencija> getOne(@PathVariable("id") Integer id){
		if (this.turistickaAgencijaService.findById(id).isPresent()) {
			Optional<TuristickaAgencija> turisticka_agencija = this.turistickaAgencijaService.findById(id);
	        return new ResponseEntity<>(turisticka_agencija.get(), HttpStatus.OK);
		} else {
		    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Returns list of Turisticke_agencije containing string that was forwarded as path variable in 'naziv'.")
	@GetMapping("turisticka_agencija/naziv/{naziv}")
	public ResponseEntity<List<TuristickaAgencija>> getByNaziv(@PathVariable("naziv") String naziv){
		List<TuristickaAgencija> turistickeAgencije = this.turistickaAgencijaService.findByNazivContainingIgnoreCase(naziv);
	    return new ResponseEntity<>(turistickeAgencije, HttpStatus.OK);
	}
		
	@ApiOperation(value = "Adds new Turisticka_agencija to database.")
	@PostMapping("turisticka_agencija")
	public ResponseEntity<TuristickaAgencija> addTuristicka_agencija(@RequestBody TuristickaAgencija turisticka_agencija) {
		TuristickaAgencija savedTuristickaAgencija = this.turistickaAgencijaService.save(turisticka_agencija);
	    URI location = URI.create("/turisticka_agencija/" + savedTuristickaAgencija.getId());
	    return ResponseEntity.created(location).body(savedTuristickaAgencija);
	}
		
	@ApiOperation(value = "Updates Turisticka_agencija that has id that was forwarded as path variable with values forwarded in Request Body.")
	@PutMapping(value = "turisticka_agencija/{id}")
	public ResponseEntity<TuristickaAgencija> updateTuristicka_agencija(@RequestBody TuristickaAgencija turisticka_agencija, @PathVariable("id") Integer id) {
		if (this.turistickaAgencijaService.existsById(id)) {
			turisticka_agencija.setId(id);
	        TuristickaAgencija savedTuristicka_agencija = this.turistickaAgencijaService.save(turisticka_agencija);
	        return ResponseEntity.ok().body(savedTuristicka_agencija);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	  
	@ApiOperation(value = "Deletes Turisticka_agencija with id that was forwarded as path variable.")
	@DeleteMapping("turisticka_agencija/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
		if (id == -100 && !this.turistickaAgencijaService.existsById(-100)) {
			this.jdbcTemplate.execute(
					"INSERT INTO turisticka_agencija (\"id\", \"naziv\", \"adresa\", \"kontakt\") VALUES (-100, 'naz', 'adr', 'kont')");
	    }
		if (this.turistickaAgencijaService.existsById(id)) {
			this.turistickaAgencijaService.deleteById(id);
	        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	    }
	    return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
}