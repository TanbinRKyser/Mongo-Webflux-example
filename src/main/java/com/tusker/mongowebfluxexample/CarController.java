package com.tusker.mongowebfluxexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping( path = "/cars")
public class CarController {

    private CarRepository carRepository;

    public CarController( CarRepository carRepository ){
        this.carRepository = carRepository;
    }

    @PostMapping()
    public @ResponseBody
    Mono<Car> addKayak( @RequestBody Car car ) {
        return carRepository.save( car );
    }

    @GetMapping()
    public @ResponseBody
    Flux<Car> getAllKayaks() {
        return carRepository.findAll();
    }
}
