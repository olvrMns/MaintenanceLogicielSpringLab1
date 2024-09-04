package edu.mv.repository;


import edu.mv.db.models.BidulePersistence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface BiduleRepository extends CrudRepository<BidulePersistence, String> {
}
