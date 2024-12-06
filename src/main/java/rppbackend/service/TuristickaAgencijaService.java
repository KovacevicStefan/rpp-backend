package rppbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rppbackend.model.TuristickaAgencija;
import rppbackend.repository.TuristickaAgencijaRepository;

@Service
public class TuristickaAgencijaService {

	@Autowired
	private TuristickaAgencijaRepository turAgRepository;

	public List<TuristickaAgencija> getAll() {
		return this.turAgRepository.findAll();
	}
	
	public List<TuristickaAgencija> findByNazivContainingIgnoreCase(String naziv) {
		return this.turAgRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	public Optional<TuristickaAgencija> findById(Integer id) {
		return this.turAgRepository.findById(id);
	}
	
	public TuristickaAgencija save(TuristickaAgencija turAg) {
		return this.turAgRepository.save(turAg);
	}
	
	public boolean existsById(Integer id) {
		return this.turAgRepository.existsById(id);
	}

	public void deleteById(Integer id) {
		this.turAgRepository.deleteById(id);
	}
}
