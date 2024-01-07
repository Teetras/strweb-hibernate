package by.bsuir.exm.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String role;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

}

