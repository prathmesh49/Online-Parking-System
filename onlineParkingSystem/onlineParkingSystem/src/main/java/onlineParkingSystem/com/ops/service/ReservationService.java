package onlineParkingSystem.com.ops.service;

import onlineParkingSystem.com.ops.exception.ReservationNotFoundException;
import onlineParkingSystem.com.ops.model.Reservation;
import onlineParkingSystem.com.ops.model.ReservationRequest;
import onlineParkingSystem.com.ops.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository; // Your MongoDB repository for reservations

    public Reservation createReservation(ReservationRequest reservationRequest) {
        // Create a new reservation object
        Reservation reservation = new Reservation();
        reservation.setUserId(reservationRequest.getUserId());
        reservation.setParkingSpaceId(reservationRequest.getParkingSpaceId());
        reservation.setStartTime(reservationRequest.getStartTime());
        reservation.setEndTime(reservationRequest.getEndTime());

        // Save the reservation to the database
        return reservationRepository.save(reservation);
    }

    public Reservation getReservation(UUID reservationId) {
        // Retrieve a reservation by its ID
        Optional<Reservation> reservation = reservationRepository.findById(String.valueOf(reservationId));
        if (reservation.isPresent()) {
            return reservation.get();
        } else {
            throw new ReservationNotFoundException("Reservation not found with ID: " + reservationId);
        }
    }

    public List<Reservation> getUserReservations(UUID userId) {
        // Retrieve all reservations for a user by user ID
        return reservationRepository.findByUserId(userId);
    }

    public void cancelReservation(UUID reservationId) {
        // Delete a reservation by its ID
        reservationRepository.deleteById(String.valueOf(reservationId));
    }

}
