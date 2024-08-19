package kodlama.io.rentACar.business.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationProblemDetails extends ProblemDetails{

    private Map<String,String> validationErrors;

}
