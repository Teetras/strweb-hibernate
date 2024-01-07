package by.bsuir.exm.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "companies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_country")
    private String companyCountry;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Car> cars;

    public Company(String companyName, String companyCountry) {
        this.companyName = companyName;
        this.companyCountry = companyCountry;
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        car.setCompany(this);
        this.cars.add(car);
    }
}