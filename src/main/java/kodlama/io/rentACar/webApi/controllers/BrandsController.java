package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {
    	this.brandService = brandService;
	}
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		
	return brandService.getAll();
		
	}

	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){

		return brandService.getById(id);

	}
	
	@PostMapping()
	@ResponseStatus(code= HttpStatus.CREATED)
	public void Add(@RequestBody CreateBrandRequest brandRequest){
		
		brandService.add(brandRequest);
		
	}

	@PutMapping
	public void Update(UpdateBrandRequest updateBrandRequest){

		brandService.update(updateBrandRequest);

	}

	@DeleteMapping("/{id}")
	public void Delete(@PathVariable  int id){

		brandService.delete(id);

	}
	
	
	
	
}
