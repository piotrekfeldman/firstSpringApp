package pl.java.pf.demo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    List<User> userList;

    public UserRepository(List<User> userList) {
        this.userList = userList;
        userList.add(new User("Adam", "Kowalczyk", 25));
        userList.add(new User("Zbyszek", "Polak", 18));
        userList.add(new User("Anna", "Stelmach", 33));
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }

}
