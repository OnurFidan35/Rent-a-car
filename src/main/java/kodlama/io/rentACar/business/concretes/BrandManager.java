package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAcces.abstarcts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
@AllArgsConstructor
@Service //Bu bir business nesnesidir
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;


	@Override
	public List<GetAllBrandsResponse> getAll() {
		//iş kuralları

		List <Brand> result =brandRepository.findAll();
		List  <GetAllBrandsResponse> resultForViewers= new ArrayList<GetAllBrandsResponse>();



		resultForViewers =result.stream().map(brand -> modelMapperService.forResponse()
				.map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

		
		return resultForViewers;
		
		
	}


	@Override
	public void add(CreateBrandRequest brandRequest) {
		
		//Brand brand = new Brand();
		//brand.setName(brandRequest.getName());




		brandBusinessRules.checkIfBrandNameExists(brandRequest.getName());
		Brand brand=modelMapperService.forRequest().map(brandRequest,Brand.class);

		brandRepository.save(brand);
		
		
	}

	@Override
	public void update(UpdateBrandRequest brandRequest) {
	Brand brand = modelMapperService.forRequest().map(brandRequest,Brand.class);
	brandRepository.save(brand); //Id de aldığımız için bu işlem insert değil update yapar
	}

	@Override
	public void delete(int id) {
	brandRepository.deleteById(id);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = brandRepository.findById(id).orElseThrow(); //Bulamazsa vs hata fırlat
		GetByIdBrandResponse response=modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
		return response;
	}

}

