package onlineParkingSystem.com.ops.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Document(collection = "users")
@Data
@NoArgsConstructor
public class Users {
    @Id
    private UUID id; // Use UUID for the ID
    private String username;
    private String password;
    private String email;
    private boolean enabled; // Flag indicating whether the user is enabled (e.g., for account activation)
    private String firstName;
    private String lastName;
}
