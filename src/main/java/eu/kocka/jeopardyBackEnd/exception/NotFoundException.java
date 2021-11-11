package eu.kocka.jeopardyBackEnd.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException extends Exception{
    private String message;
}
