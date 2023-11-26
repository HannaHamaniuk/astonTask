package by.anne.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public ResponseEntity<WrongInfo>handleException(NoSuchCountryException e){
        WrongInfo info = new WrongInfo();
        info.setData(e.getMessage());
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<WrongInfo>handleException(Exception e){
        WrongInfo info = new WrongInfo();
        info.setData(e.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }


}
