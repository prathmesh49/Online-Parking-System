package onlineParkingSystem.com.ops.controller;
import onlineParkingSystem.com.ops.model.ParkingSpot;
import onlineParkingSystem.com.ops.repo.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingspot")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotRepository repository;
    @GetMapping("/")
    public ResponseEntity<?> listParkingSpots() {
        return ResponseEntity.ok(repository.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<?> saveParkingSpots(@RequestBody ParkingSpot parkingSpot) {
        ParkingSpot spot = this.repository.save(parkingSpot);
        return ResponseEntity.ok(spot);
    }

}
