package pro.sky.skyprospring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class IncorrectNameOfEmployee extends RuntimeException {
}
