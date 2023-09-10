package onlineParkingSystem.com.ops.service;

import onlineParkingSystem.com.ops.model.ParkingSpot;
import onlineParkingSystem.com.ops.repo.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository repository;

    @Autowired
    public ParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return repository.save(parkingSpot);
    }

    public ParkingSpot getParkingSpotById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return repository.findAll();
    }

    public void updateParkingSpot(ParkingSpot parkingSpot) {
        repository.save(parkingSpot);
    }

    public void deleteParkingSpot(int id) {
        repository.deleteById(id);
    }
}
