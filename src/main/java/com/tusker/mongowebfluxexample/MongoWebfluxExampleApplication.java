package com.tusker.mongowebfluxexample;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class MongoWebfluxExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run( MongoWebfluxExampleApplication.class, args );
	}

	// Insert some data
	@Bean
	ApplicationRunner init( CarRepository repository) {

		Object[][] data = {
				{ "Prius", "Toyota", "John Doe" },
				{ "Mustang V8", "Ford", "John Doe" },
				{ "Q5", "Audi", "John Doe" }
		};

		return args -> repository
				.deleteAll()
				.thenMany(
						Flux
								.just( data )
								.map( array -> new Car(
										(String) array[0],
										(String) array[1],
										(String) array[2]
								) )
								.flatMap(repository::save)
				)
				.thenMany( repository.findAll() )
				.subscribe( car -> System.out.println("saving " + car.toString()));
	}

}









