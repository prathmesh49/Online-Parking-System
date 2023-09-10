package onlineParkingSystem.com.ops.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorDetails {
    private String message;
    private String desc;
    private LocalDateTime dateTime;
}
