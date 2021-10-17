/*package com.tr.bluemoon.springdatajdbc;

import com.tr.bluemoon.springdatajdbc.services.car.Car;
import com.tr.bluemoon.springdatajdbc.services.car.CarRepository;
import com.tr.bluemoon.springdatajdbc.services.engine.Engine;
import com.tr.bluemoon.springdatajdbc.services.engine.EngineRepository;
import com.tr.bluemoon.springdatajdbc.services.movie.MovieRepository;
import com.tr.bluemoon.springdatajdbc.services.truck.Truck;
import com.tr.bluemoon.springdatajdbc.services.truck.TruckRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SpringDataJdbcApplicationTests {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Test
    public void contextLoads() {

        Optional<Engine> engine = engineRepository.findById(2L);

        if (engine.isPresent()) {
            System.out.println(engine.get());
        } else {
            Engine newEngine = new Engine(null, "2.0");
        }

        Optional<Car> car = carRepository.findById(6L);

        if (car.isPresent()) {
            System.out.println(car.get().getEngine().getName());
        } else {
            Car newCar = new Car(null, "Azera", new Engine(3L, "3.3"));

            carRepository.save(newCar);
        }

        Optional<Truck> truck = truckRepository.findById(1L);

        if (truck.isPresent()) {
            System.out.println(truck);
        } else {
            Truck newTruck = new Truck(null, "Volvo", new Engine(2L, "4.0"));
            truckRepository.save(newTruck);
        }


    }

}
*/