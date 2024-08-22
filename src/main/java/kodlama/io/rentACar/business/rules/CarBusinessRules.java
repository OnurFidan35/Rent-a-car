package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.business.exceptions.BusinessException;
import kodlama.io.rentACar.dataAcces.abstarcts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {

    CarRepository carRepository;


    public void checkIfCarPlateExists(String name){

        if (carRepository.existsByPlate(name)){

            throw new BusinessException("Car already exists");

        }

    }

    public void checkIfCarIdExists(int id){

        if (!carRepository.existsById(id)){

            throw new BusinessException("Car already doesn't exist");

        }

    }


}
