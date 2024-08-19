package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CreateBrandRequest {

	@NotNull
	@NotBlank
	@Size(min = 3,max = 24)
	private String name;

	public CreateBrandRequest(String name) {
		this.name = name;
	}

	public CreateBrandRequest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

