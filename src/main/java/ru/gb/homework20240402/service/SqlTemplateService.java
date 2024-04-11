package ru.gb.homework20240402.service;

import org.springframework.stereotype.Service;

@Service
public class SqlTemplateService {

    public String getFindAllStatement() {
        return "SELECT * FROM userTable";
    }

    public String saveStatement() {
        return "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
    }

    public String deleteByIdStatement() {
        return "DELETE FROM userTable WHERE id=?";
    }

    public String getOneStatement() {
        return "SELECT * FROM userTable WHERE id = ?";
    }

    public String updateStatement() {
        return "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
    }


}
