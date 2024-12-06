package rppbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import rppbackend.model.Aranzman;
import rppbackend.model.Hotel;

public interface AranzmanRepository extends JpaRepository<Aranzman, Integer>{

	List<Aranzman> findByHotel(Hotel hotel);
	List<Aranzman> findByPlacenoTrue();
}
