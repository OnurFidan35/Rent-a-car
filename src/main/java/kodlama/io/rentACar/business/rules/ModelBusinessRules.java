package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.business.exceptions.BusinessException;
import kodlama.io.rentACar.dataAcces.abstarcts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {

    private ModelRepository modelRepository;

    public void checkIfModelNameExists(String name){

        if (modelRepository.existsByName(name)){

            throw new BusinessException("Model already exists");

        }

    }

    public void checkIfModelIdExists(int id){

        if (!modelRepository.existsById(id)){

            throw new BusinessException("Model already doesn't exist");

        }

    }


}
