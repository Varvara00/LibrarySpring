package varvara.com.stringmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import varvara.com.stringmvc.models.Person;

import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));

    }

    public Optional<Person> show(int person_id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE person_id=?", new Object[]{person_id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, year_of_birth) VALUES(?, ?)", person.getName(), person.getYear_of_birth());
    }

    public void update(int person_id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET name=?, year_of_birth=?, WHERE person_id=?", updatedPerson.getName(),
                updatedPerson.getYear_of_birth(), person_id);
    }

    public void delete(int person_id) {
        jdbcTemplate.update("DELETE FROM person WHERE person_id=?", person_id);
    }
}
