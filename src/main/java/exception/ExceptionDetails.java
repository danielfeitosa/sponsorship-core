package exception;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {
   protected String title;
   protected  int status;
   protected String details;
   protected String message;
   protected LocalDateTime timeStamp;

}
