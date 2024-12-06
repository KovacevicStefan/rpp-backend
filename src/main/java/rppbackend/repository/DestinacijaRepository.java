package rppbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import rppbackend.model.Destinacija;

public interface DestinacijaRepository extends JpaRepository<Destinacija, Integer>{

	List<Destinacija> findByMestoContainingIgnoreCase(String naziv);
	
}
