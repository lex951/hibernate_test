package org.example;

import org.example.model.User;
import org.example.dao.UserDAO;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO=new UserDAO();
        User user1=new User();
        user1.setName("Ame");
        user1.setEmail("ame@mail.ru");
        user1.setAge(19);
        userDAO.saveUser(user1);

        User user=new User();
        user.setName("Sara");
        user.setEmail("sara@mail.ru");
        user.setAge(31);
        userDAO.saveUser(user);




    }
}
