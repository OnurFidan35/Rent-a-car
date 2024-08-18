package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CreateBrandRequest {

	
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

