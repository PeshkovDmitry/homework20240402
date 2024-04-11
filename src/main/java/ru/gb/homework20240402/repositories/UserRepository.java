package ru.gb.homework20240402.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.homework20240402.model.User;
import ru.gb.homework20240402.service.SqlTemplateService;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;

    private SqlTemplateService sqlTemplateService;

    public List<User> findAll() {
        String sql = sqlTemplateService.getFindAllStatement();
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = sqlTemplateService.saveStatement();
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id) {
        String sql = sqlTemplateService.deleteByIdStatement();
        jdbc.update(sql, id);
    }

    public User getOne(int id) {
        String sql = sqlTemplateService.getOneStatement();
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.queryForObject(sql, userRowMapper, id);
    }

    public User update(User user) {
        String sql = sqlTemplateService.updateStatement();
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return  user;
    }

}
