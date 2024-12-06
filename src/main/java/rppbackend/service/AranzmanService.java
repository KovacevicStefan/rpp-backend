package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Aranzman;
import rppbackend.model.Hotel;
import rppbackend.repository.AranzmanRepository;

@Service
public class AranzmanService {

	@Autowired
	private AranzmanRepository aranzmanRepository;
	
	public List<Aranzman> getAll() {
		return this.aranzmanRepository.findAll();
	}
	
	public List<Aranzman> findByHotel(Hotel hotel) {
		return this.aranzmanRepository.findByHotel(hotel);
	}
	
	public Optional<Aranzman> findById(Integer id) {
		return this.aranzmanRepository.findById(id);
	}
	
	public List<Aranzman> findByPlacenoTrue() {
		return this.aranzmanRepository.findByPlacenoTrue();
	}
	
	public Aranzman save(Aranzman aranzman) {
		return this.aranzmanRepository.save(aranzman);
	}
	
	public boolean existsById(Integer id) {
		return this.aranzmanRepository.existsById(id);
	}
	
	public void deleteById(Integer id) {
		this.aranzmanRepository.deleteById(id);
	}
}
