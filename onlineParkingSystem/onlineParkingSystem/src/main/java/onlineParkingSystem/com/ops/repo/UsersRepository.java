package onlineParkingSystem.com.ops.repo;

import onlineParkingSystem.com.ops.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends MongoRepository<Users, UUID> {
    Optional<Users> findById(UUID id);
    Optional<Users> findByUsername(String username);
}
