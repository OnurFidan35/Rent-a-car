package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.business.exceptions.BusinessException;
import kodlama.io.rentACar.dataAcces.abstarcts.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name){

        if(brandRepository.existsByName(name)){

        //Detaylı exceptionlar oluşturulabilir(BrandNameExistsException) gibi
        // fakat şimdilik genel bir businessexception yeterli olacaktır
        throw new BusinessException("Brand already exists"); //Java exception types


        }

    }

    public void checkIfBrandIdExists(int id){

        if (!brandRepository.existsById(id)){

            throw new BusinessException("Brand already doesn't exist");

        }

    }

}
