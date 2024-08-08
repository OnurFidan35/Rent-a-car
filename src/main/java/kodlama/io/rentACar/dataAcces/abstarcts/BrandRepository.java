package kodlama.io.rentACar.dataAcces.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer>{

	
	
}
