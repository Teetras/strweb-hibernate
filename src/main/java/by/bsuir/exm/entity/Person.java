package by.bsuir.exm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column
    private String surname;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String phone;

    @Column
    private String mail;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private User user;

    public Person(String surname, String name, int age, String phone, String mail) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.mail = mail;
        user = new User();
    }
}
