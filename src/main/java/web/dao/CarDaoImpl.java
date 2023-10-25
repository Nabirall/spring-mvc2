package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao{

private final List<Car> carList;

{
    carList = new ArrayList<>();

    carList.add(new Car("BMW", "X6", 2019));
    carList.add(new Car("Mercedes", "500", 2011));
    carList.add(new Car("Ferrari", "F8",2081));
    carList.add(new Car("Audi", "A7",2048));
    carList.add(new Car("Ford", "GT",2026));
}
@Override
public List<Car> getCars() {
    return carList;
}



@Override
public List<Car> getCar(int count) {
    List<Car> list = getCars();
    if (count < 0 || count > list.size()) {
        count = list.size();
    }
    return carList.stream().limit(count).collect(Collectors.toList());
}

}