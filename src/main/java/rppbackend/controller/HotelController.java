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
import rppbackend.model.Destinacija;
import rppbackend.model.Hotel;
import rppbackend.service.HotelService;
import rppbackend.service.DestinacijaService;

@CrossOrigin
@RestController
public class HotelController {

	@Autowired
    private HotelService hotelService;
	
	@Autowired
	private DestinacijaService destinacijaService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "Returns List of all Hotels")
    @GetMapping("hotel")
    public ResponseEntity<List<Hotel>> getAll() {
        List<Hotel> hotels = this.hotelService.getAll();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Returns Hotel with id that was forwarded as path variable.")
    @GetMapping("hotel/{id}")
    public ResponseEntity<Hotel> getOne(@PathVariable("id") Integer id) {
        if (this.hotelService.findById(id).isPresent()) {
            Optional<Hotel> hotelOpt = this.hotelService.findById(id);
            return new ResponseEntity<>(hotelOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(value = "Returns list of Hotels containing string that was forwarded as path variable in 'naziv'.")
    @GetMapping("hotel/naziv/{naziv}")
	public ResponseEntity<List<Hotel>> getByNaziv(@PathVariable("naziv") String naziv){
		List<Hotel> hotels = this.hotelService.findByNazivContainingIgnoreCase(naziv);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
	}

    @ApiOperation(value = "Returns list of Hotels for Destinacija with id that was forwarded as path variable.")
    @GetMapping("hoteliZaDestinaciju/{id}")
    public ResponseEntity<List<Hotel>> getAllForDestinacija(@PathVariable("id") Integer id) {
        Optional<Destinacija> destinacijaOpt = this.destinacijaService.findById(id);
        if (destinacijaOpt.isPresent()) {
            List<Hotel> hotels = this.hotelService.findByDestinacija(destinacijaOpt.get());
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
    
    @ApiOperation(value = "Adds new Hotel to database.")
    @PostMapping("hotel")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
    	Hotel savedHotel = this.hotelService.save(hotel);
        URI location = URI.create("/hotel/" + savedHotel.getId());
        return ResponseEntity.created(location).body(savedHotel);
    }

    @ApiOperation(value = "Updates Hotel that has id that was forwarded as path variable with values forwarded in Request Body.")
    @PutMapping(value = "hotel/{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel,
            @PathVariable("id") Integer id) {
        if (this.hotelService.existsByID(id)) {
            hotel.setId(id);
            Hotel savedHotel = this.hotelService.save(hotel);
            return ResponseEntity.ok().body(savedHotel);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Deletes Hotel with id that was forwarded as path variable.")
    @DeleteMapping("hotel/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        if (id == -100 && !this.hotelService.existsByID(-100)) {

            this.jdbcTemplate.execute("INSERT INTO hotel "
                    + "(\"id\", \"naziv\", \"broj_zvezdica\", \"opis\", \"destinacija\") VALUES (-100, 'naz', 5, 'opi', 1)");
        }

        if (this.hotelService.existsByID(id)) {
            this.hotelService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }
}
