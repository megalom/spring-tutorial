package ru.megalom.springcrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.megalom.springcrud.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

   /*
    private static final String URL = "jdbc:postgresql://localhost:5432/persons";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "javaee";
    private static Connection connection;

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public List<Person> index(){

        return jdbcTemplate.query("SELECT * FROM person",new PersonMapper());

        /*List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person ORDER BY id ASC;";
            ResultSet resultSet=statement.executeQuery(SQL);

            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;*/
    }

    public Person show(int id){
        return jdbcTemplate.query(
                "SELECT * FROM person WHERE id=?",
                new BeanPropertyRowMapper<>(Person.class),
                id)
                .stream().findAny().orElse(null);
        /*String SQL = "SELECT * FROM person WHERE id=?;";
        Person person=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();

            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;*/
        //return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }

    public void add(Person person){
        jdbcTemplate.update(
                "INSERT INTO person(name,age,email) VALUES(?, ?, ?)",
                person.getName(),
                person.getAge(),
                person.getEmail()
        );
        /*try {
            String SQL = "INSERT INTO person(name,age,email) VALUES(?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }

    public void update(int id, Person person) {
        jdbcTemplate.update(
                "UPDATE person SET name=?, age=?,email=? WHERE id=?",
                person.getName(),
                person.getAge(),
                person.getEmail(),
                id
        );
        /*try {
            String SQL = "UPDATE person SET name=?, age=?,email=? WHERE id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }

    public void delete(int id)
    {
        jdbcTemplate.update("DELETE FROM person WHERE id=?",id);
        /*try {
            String SQL = "DELETE FROM person WHERE id=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
//        people.removeIf(person->person.getId()==id);
    }
}
