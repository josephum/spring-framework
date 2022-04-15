package com.example.spring10ormtablecreation.bootstrap;

import com.example.spring10ormtablecreation.entity.Car;
import com.example.spring10ormtablecreation.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {


    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car c1 = new Car("BMW","M5");
        Car c2 = new Car("Honda","Civic");
        Car c3 = new Car("Toyota","Corolla");

        //save these objects to DB
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

    }
}
