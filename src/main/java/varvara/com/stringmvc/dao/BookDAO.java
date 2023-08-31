package varvara.com.stringmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import varvara.com.stringmvc.models.Book;
import varvara.com.stringmvc.models.Person;

import java.util.List;
import java.util.Optional;


@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));

    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, director,person_id, yearOfProduction) VALUES(?, ?, ?, ?)", book.getName(), book.getDirector(), book.getYearOfProduction());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?,director=?, yearOfProduction=? WHERE id=?", updatedBook.getName(), updatedBook.getDirector(),
                updatedBook.getYearOfProduction(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    //надо создать метод джоин двух таблиц (Join'им такблицы Book и Person и получаем человека,которому принаджлежит книга с указаным id(getBookOwner)
    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id" + " WHERE Book.id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    //надо создать метод для освобождения книги
    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?", id);

    }

    //надо создать метод для назначения человека
    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }
}

//
