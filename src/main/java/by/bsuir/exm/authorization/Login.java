package by.bsuir.exm.authorization;

import by.bsuir.exm.entity.Person;
import by.bsuir.exm.entity.User;
import by.bsuir.exm.menu.Menu;
import by.bsuir.exm.service.PersonService;
import by.bsuir.exm.service.impl.PersonServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Login {
    Scanner in = new Scanner(System.in);
    public void authorization() {
        PersonService personService = new PersonServiceImpl();
        List<Person> people = personService.showPeople();
        System.out.print("Введите логин: ");
        String login = in.nextLine();
        System.out.print("Введите пароль: ");
        String password = in.nextLine();
        User currentUser = null;
        for(Person p : people) {
            if(p.getUser().getLogin().equals(login) && p.getUser().getPassword().equals(password)) {
                currentUser = p.getUser();
                p.setPersonId(people.size());
            }
            if (p.getUser().getLogin().equals(login) && !p.getUser().getPassword().equals(password)) {
                System.out.println("Проверьте корректность пароля!");
            }
        }
        if (currentUser != null) {
            System.out.println("Авторизация пройдена успешно! Добро пожаловать " +
                    currentUser.getPerson().getSurname() + " " + currentUser.getPerson().getName());
            Menu menu = new Menu();
            String role = currentUser.getRole();
            switch (role) {
                case "Admin":
                    menu.AdminMenu();
                    break;
                case "User":
                    menu.UserMenu(currentUser);
                    break;
            }
        }
        else {
            System.out.println("Такого пользователя не найдено");
        }
    }
}
