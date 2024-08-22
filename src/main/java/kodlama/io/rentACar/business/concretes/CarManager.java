package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import kodlama.io.rentACar.business.rules.CarBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAcces.abstarcts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarManager implements CarService {

    CarRepository carRepository;
    ModelMapperService modelMapperService;
    CarBusinessRules carBusinessRules;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> result=carRepository.findAll();
        List<GetAllCarsResponse> responses= result.stream().map(car -> modelMapperService.forResponse().map(car,GetAllCarsResponse.class)).collect(Collectors.toList());

        return responses;

    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        carBusinessRules.checkIfCarPlateExists(createCarRequest.getPlate());
        Car car=modelMapperService.forRequest().map(createCarRequest,Car.class);
        carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        //unique constraint kullanarak bu methodla var olan bir isimden 2 tane oluşmasını engelleyebilirim.
        Car car=modelMapperService.forRequest().map(updateCarRequest,Car.class);
        carRepository.save(car);

    }

    @Override
    public void delete(int id) {

        carBusinessRules.checkIfCarIdExists(id);
        carRepository.deleteById(id);
    }

    @Override
    public GetByIdCarResponse getById(int id) {
        Car car =carRepository.findById(id).orElseThrow();
        GetByIdCarResponse response = modelMapperService.forResponse().map(car,GetByIdCarResponse.class);
        return response;
    }
}
