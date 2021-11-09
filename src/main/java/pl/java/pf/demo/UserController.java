package pl.java.pf.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/add")
    public String add(@RequestParam(name = "imie") String firstName,
                      @RequestParam(name = "nazwisko", defaultValue = "anonim") String lastName,
                      @RequestParam(name = "wiek", defaultValue = "0") Integer age) {
        User user = new User(firstName, lastName, age);
        userRepository.add(user);
        return firstName.length() > 0 ? "redirect:/success.html" : "redirect:/err.html";
    }

    @ResponseBody
    @GetMapping("/users")
    public String list() {
        List<User> userList = userRepository.getAll();
        String result = "";

        for (User user1 : userList) {
            result += user1.getFirstName() + " " + user1.getLastName()
                    + " " + user1.getAge() + "<br/>";
        }
    }
}
