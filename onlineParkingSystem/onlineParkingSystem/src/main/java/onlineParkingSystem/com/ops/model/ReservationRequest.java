package onlineParkingSystem.com.ops.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "reservation_req")
@Data
@NoArgsConstructor
public class ReservationRequest {
    @Id
    private String userId; // The ID of the user making the reservation
    private String parkingSpaceId; // The ID of the parking space being reserved
    private Date startTime; // The start time of the reservation
    private Date endTime;
}
