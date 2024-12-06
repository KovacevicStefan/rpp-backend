package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.Destinacija;
import rppbackend.repository.DestinacijaRepository;

@Service
public class DestinacijaService {

	@Autowired
	private DestinacijaRepository destinacijaRepository;
	
	public List<Destinacija> getAll() {
		return this.destinacijaRepository.findAll();
	}
	
	public Optional<Destinacija> findById(Integer id) {
		return this.destinacijaRepository.findById(id);
	}
	
	public List<Destinacija> findByMestoContainingIgnoreCase(String mesto) {
		return this.destinacijaRepository.findByMestoContainingIgnoreCase(mesto);
	}
	
	public Destinacija save(Destinacija destinacija) {
		return this.destinacijaRepository.save(destinacija);
	}
	
	public boolean existsById(Integer id) {
		return this.destinacijaRepository.existsById(id);
	}
	
	public void deleteById(Integer id) {
		this.destinacijaRepository.deleteById(id);
	}
}
