package onlineParkingSystem.com.ops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "park")
public class ParkingSpot {
    @Id
    private String pid;
    private String name;
    private String location;

}
