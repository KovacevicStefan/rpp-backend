package rppbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rppbackend.model.Destinacija;
import rppbackend.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	List<Hotel> findByNazivContainingIgnoreCase(String naziv);
	List<Hotel> findByDestinacija(Destinacija destinacija);
	
}
