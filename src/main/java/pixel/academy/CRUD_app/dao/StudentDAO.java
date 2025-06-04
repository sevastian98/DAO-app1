package pixel.academy.CRUD_app.dao;

import pixel.academy.CRUD_app.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);

    Student findById(Integer id);

}
