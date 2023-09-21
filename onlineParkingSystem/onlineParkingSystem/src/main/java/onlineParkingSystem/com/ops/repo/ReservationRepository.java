package onlineParkingSystem.com.ops.repo;

import onlineParkingSystem.com.ops.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
}
