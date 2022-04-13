package legacyappconsumer;

import java.time.LocalDate;

import legacyapp.user.service.UserService;

public class Main {
    public static void main(String[] args) {
        /* do not change this code! */

        var userService = new UserService();
        var addResult = userService.addUser("John", "Doe", "johndoe@gmail.com", LocalDate.of(1982, 3, 21), 1);

        if (addResult) {
            System.out.println("Adding John Doe was successful");
        } else {
            System.out.println("Adding John Doe was unsuccessful");
        }
    }
}