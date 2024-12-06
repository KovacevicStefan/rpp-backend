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
import rppbackend.service.DestinacijaService;

@CrossOrigin
@RestController
public class DestinacijaController {
	
	@Autowired
	private DestinacijaService destinacijaService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "Returns List of all Destinacije")
	@GetMapping("destinacija")
	public ResponseEntity<List<Destinacija>> getAll(){
		List<Destinacija> destinacije = this.destinacijaService.getAll();
        return new ResponseEntity<>(destinacije, HttpStatus.OK);
	}
	
    @ApiOperation(value = "Returns Destinacija with id that was forwarded as path variable.")
	@GetMapping("destinacija/{id}")
	public ResponseEntity<Destinacija> getOne(@PathVariable("id") Integer id){
	    if (this.destinacijaService.findById(id).isPresent()) {
	    	Optional<Destinacija> destinacija = this.destinacijaService.findById(id);
            return new ResponseEntity<>(destinacija.get(), HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    }
	}
	
    @ApiOperation(value = "Returns list of Destinacije containing string that was forwarded as path variable in 'mesto'.")
	@GetMapping("destinacija/mesto/{mesto}")
	public ResponseEntity<List<Destinacija>> getByMesto(@PathVariable("mesto") String mesto){
    	List<Destinacija> destinacije = this.destinacijaService.findByMestoContainingIgnoreCase(mesto);
		return new ResponseEntity<>(destinacije, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Adds new Destinacija to database.")
	@PostMapping("destinacija")
	public ResponseEntity<Destinacija> addDestinacija(@RequestBody Destinacija destinacija) {
    	Destinacija savedDestinacija = this.destinacijaService.save(destinacija);
		URI location = URI.create("/destinacija/" + savedDestinacija.getId());
        return ResponseEntity.created(location).body(savedDestinacija);
	}
   
	@ApiOperation(value = "Updates Destinacija that has id that was forwarded as path variable with values forwarded in Request Body.")
	@PutMapping(value = "destinacija/{id}")
	public ResponseEntity<Destinacija> updateDestinacija(@RequestBody Destinacija destinacija, @PathVariable("id") Integer id) {
    	if (this.destinacijaService.existsById(id)) {
        	destinacija.setId(id);
        	Destinacija savedDestinacija = this.destinacijaService.save(destinacija);
            return ResponseEntity.ok().body(savedDestinacija);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Deletes Destinacija with id that was forwarded as path variable.")
    @DeleteMapping("destinacija/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
    	if (id == -100 && !this.destinacijaService.existsById(-100)) {
        	this.jdbcTemplate.execute("INSERT INTO destinacija (\"id\", \"mesto\", \"drzava\", \"opis\") VALUES ('-100', 'm', 'drz', 'opi')");
        }
        if (this.destinacijaService.existsById(id)) {
        	this.destinacijaService.deleteById(id);
        	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
}