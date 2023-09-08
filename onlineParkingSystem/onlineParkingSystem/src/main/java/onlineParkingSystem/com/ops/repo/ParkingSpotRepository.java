package onlineParkingSystem.com.ops.repo;

import onlineParkingSystem.com.ops.model.ParkingSpot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends MongoRepository<ParkingSpot, Integer> {
}
