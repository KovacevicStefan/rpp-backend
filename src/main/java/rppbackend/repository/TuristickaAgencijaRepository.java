package rppbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import rppbackend.model.TuristickaAgencija;

public interface TuristickaAgencijaRepository extends JpaRepository<TuristickaAgencija, Integer>{

	List<TuristickaAgencija> findByNazivContainingIgnoreCase(String naziv);
	
}
