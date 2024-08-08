package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAcces.abstarcts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
@Service //Bu bir business nesnesidir
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}


	@Override
	public List<GetAllBrandsResponse> getAll() {
		//iş kuralları	
		
		List <Brand> result =brandRepository.findAll();
		List  <GetAllBrandsResponse> resultForViewers= new ArrayList<GetAllBrandsResponse>();
		
		
		
		for (Brand brand : result) {
		GetAllBrandsResponse brandsResponse = new GetAllBrandsResponse();
		brandsResponse.setId(brand.getId());
		brandsResponse.setName(brand.getName());
		
		resultForViewers.add(brandsResponse);
			
		}
		
		return resultForViewers;
		
		
	}


	@Override
	public void add(CreateBrandRequest brandRequest) {
		
		Brand brand = new Brand();
		brand.setName(brandRequest.getName());
		
		brandRepository.save(brand);
		
		
	}

}

