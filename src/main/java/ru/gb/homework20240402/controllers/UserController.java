package ru.gb.homework20240402.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.homework20240402.model.User;
import ru.gb.homework20240402.service.UserService;

import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model){
        log.info("Запрошен список всех пользователей");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        log.info("Запрошена форма создания пользователя");
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        log.info("Добавление пользователя " + user + " в репозиторий");
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        log.info("Запрошено удаление пользователя с id = " + id);
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        log.info("Запрошено обновление пользователя с id = " + id);
        User user = userService.getOneUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }


    @PostMapping("/user-update")
    public String updateUser(User user){
        log.info("Запрошено обновление пользователя " + user);
        userService.updateUser(user);
        return "redirect:/users";
    }
}
