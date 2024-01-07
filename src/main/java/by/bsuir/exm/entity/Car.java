package by.bsuir.exm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "distance")
    private int distance;

    @Column(name = "fuel")
    private String fuel;

    @Column(name = "fuel_consumption")
    private String fuelConsumption;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public Car(String name, int year, int distance, String fuel, String fuelConsumption, int price) {
        this.name = name;
        this.year = year;
        this.distance = distance;
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
    }
}
