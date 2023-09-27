package onlineParkingSystem.com.ops.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException() {
        super();
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }
}
