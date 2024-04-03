package ru.gb.homework20240402.service;

import org.springframework.stereotype.Service;
import ru.gb.homework20240402.model.User;
import ru.gb.homework20240402.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.update(user);
    }

    public User getOneUser(int id) {
        return userRepository.getOne(id);
    }
}
