package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetByIdCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    CarService carService;

    @GetMapping()
    public List<GetAllCarsResponse> getAll(){

    return carService.getAll();


    }

    @GetMapping("/{id}")
    public GetByIdCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }


    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateCarRequest createCarRequest){

        carService.add(createCarRequest);

    }

    @PutMapping()
    public void update(@RequestBody() UpdateCarRequest updateCarRequest){

        carService.update(updateCarRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(int id){

        carService.delete(id);

    }










}
