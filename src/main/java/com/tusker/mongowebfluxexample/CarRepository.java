package com.tusker.mongowebfluxexample;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car, Long> {
}
