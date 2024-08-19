package kodlama.io.rentACar.business.exceptions;

public class BusinessException extends RuntimeException { //Bu bir runtime exception olduğu için ondan implement
    public BusinessException(String message) {

        super(message);

    }
}
