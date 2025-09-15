package Homeworks.Homework011;
import java.util.*;
import java.util.stream.Collectors;

// Класс Автомобиль
class Car {
    private String number;
    private String model;
    private String color;
    private long mileage;
    private long cost;

    // Конструктор
    public Car(String number, String model, String color, long mileage, long cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    // Геттеры и сеттеры
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return String.format("%-8s %-8s %-8s %-8d %d",
                number, model, color, mileage, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем список автомобилей
        List<Car> cars = Arrays.asList(
                new Car("a123me", "Mercedes", "White", 0L, 8300000L),
                new Car("b873of", "Volga", "Black", 0L, 673000L),
                new Car("w487mn", "Lexus", "Grey", 76000L, 900000L),
                new Car("p987hj", "Volga", "Red", 610L, 704340L),
                new Car("c987ss", "Toyota", "White", 254000L, 761000L),
                new Car("o983op", "Toyota", "Black", 698000L, 740000L),
                new Car("p146op", "BMW", "White", 271000L, 850000L),
                new Car("u893ii", "Toyota", "Purple", 210900L, 440000L),
                new Car("l097df", "Toyota", "Black", 108000L, 780000L),
                new Car("y876wd", "Toyota", "Black", 160000L, 1000000L)
        );

        // Выводим все автомобили
        System.out.println("Автомобили в базе:");
        System.out.printf("%-8s %-8s %-8s %-8s %s%n",
                "Number", "Model", "Color", "Mileage", "Cost");
        cars.forEach(System.out::println);
        System.out.println();

        // Входные данные для фильтрации
        final String colorToFind = "Black";
        final long mileageToFind = 0L;
        final long minPrice = 700000L;
        final long maxPrice = 800000L;
        final String modelToFind = "Toyota";
        final String modelNotFound = "Volvo";

        // 1) Номера автомобилей по цвету или пробегу
        System.out.print("Номера автомобилей по цвету или пробегу: ");
        String numbers = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.joining(" "));
        System.out.println(numbers);

        // 2) Количество уникальных моделей в ценовом диапазоне
        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= minPrice && car.getCost() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("Уникальные автомобили: " + uniqueModelsCount + " шт.");

        // 3) Цвет автомобиля с минимальной стоимостью
        String minCostColor = cars.stream()
                .min(Comparator.comparingLong(Car::getCost))
                .map(Car::getColor)
                .orElse("Не найдено");
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + minCostColor);

        // 4) Средняя стоимость искомой модели Toyota
        double averageCostToyota = cars.stream()
                .filter(car -> car.getModel().equals(modelToFind))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0.0);
        System.out.printf("Средняя стоимость модели %s: %.2f%n",
                modelToFind, averageCostToyota);

        // 5) Средняя стоимость несуществующей модели Volvo
        double averageCostVolvo = cars.stream()
                .filter(car -> car.getModel().equals(modelNotFound))
                .mapToLong(Car::getCost)
                .average()
                .orElse(0.0);
        System.out.printf("Средняя стоимость модели %s: %.2f%n",
                modelNotFound, averageCostVolvo);
    }
}