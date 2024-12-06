package rppbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import rppbackend.model.Destinacija;
import rppbackend.model.Hotel;
import rppbackend.repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> getAll(){
		return this.hotelRepository.findAll();
	}
	
	public List<Hotel> findByDestinacija(Destinacija destinacija) {
		return this.hotelRepository.findByDestinacija(destinacija);
	}
	
	public Optional<Hotel> findById(Integer id) {
		return this.hotelRepository.findById(id);
	}
	
	public List<Hotel> findByNazivContainingIgnoreCase(String naziv) {
		return this.hotelRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	public Hotel save(Hotel hotel) {
		return this.hotelRepository.save(hotel);
	}
	
	public boolean existsByID(Integer id) {
		return this.hotelRepository.existsById(id);
	}
	
	public void deleteById(Integer id) {
		this.hotelRepository.deleteById(id);
	}
}
