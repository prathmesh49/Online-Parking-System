package onlineParkingSystem.com.ops.controller;

import onlineParkingSystem.com.ops.model.ParkingSpot;
import onlineParkingSystem.com.ops.repo.ParkingSpotRepository;
import onlineParkingSystem.com.ops.service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingspot")
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;

    @GetMapping("/")
    public ResponseEntity<?> listParkingSpots() {
        return ResponseEntity.ok(parkingSpotService.getAllParkingSpots());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> byIdParkingSpots(@PathVariable Integer id) {
        return ResponseEntity.ok(parkingSpotService.getParkingSpotById(id));
    }

                                                                                                                                                                                                           @PostMapping("/")
    public ResponseEntity<?> saveParkingSpots(@RequestBody ParkingSpot parkingSpot) {
        parkingSpotService.updateParkingSpot(parkingSpot);
        return ResponseEntity.ok("updated");
    }

    @PutMapping("/")
    public ResponseEntity<?> updateParkingSpots(@RequestBody ParkingSpot parkingSpot) {
        ParkingSpot spot = parkingSpotService.createParkingSpot(parkingSpot);
        return ResponseEntity.ok(spot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParkingSpots(@PathVariable Integer id) {
        parkingSpotService.deleteParkingSpot(id);
        return ResponseEntity.ok("Deleted");
    }


}
