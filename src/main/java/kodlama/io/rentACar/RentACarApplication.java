package kodlama.io.rentACar;

import kodlama.io.rentACar.business.exceptions.BusinessException;
import kodlama.io.rentACar.business.exceptions.ProblemDetails;
import kodlama.io.rentACar.business.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice //Bütün controllerlar alttakı exceptionhandler'a tabi
@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}




	//Burayı yapmamızın sebebi son kullanıcıya hata mesajı verirken veri açığı vermemek yani mesjaı kısıtlamak
	@ExceptionHandler //Hata oluşursa buradan geçecek
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) //Hata yakalanırsa http statulerinden bad request dondurs
	public ProblemDetails handleBusinessException(BusinessException businessException){ //Business exc alırsa
															                            //bu method çalışacak

		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;

	}

	@ExceptionHandler //Hata oluşursa buradan geçecek
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) //Hata yakalanırsa http statulerinden bad request dondur
	public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){

		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());

		for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		return validationProblemDetails;

	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
