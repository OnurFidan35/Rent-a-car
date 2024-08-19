package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandModelsResponse;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {

	
	
	List<GetAllBrandsResponse> getAll();
	
	void add(CreateBrandRequest brandRequest);
	void update(UpdateBrandRequest brandRequest);
	void delete(int id);
	GetByIdBrandResponse getById(int id);

	List<GetAllBrandModelsResponse> getAllModels(int id);


		
		
	
	
}
