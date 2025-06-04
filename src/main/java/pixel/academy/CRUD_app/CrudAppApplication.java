package pixel.academy.CRUD_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.CRUD_app.dao.StudentDAO;
import pixel.academy.CRUD_app.entity.Student;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// Cream un obiect Studnet
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("John","Doe","john@pixelacademy.md");

		// Salvam obiectul Student in baza de date folosind DAO
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		// Afisam ID-ul studentului salvat
		System.out.println("SAved student. Generated id: " + newStudent.getId());
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		//cream mai multi constructori
		System.out.println("Creating 3 student objects...");
		Student newStudent1 = new Student("Andrei","Munteanu","adnrei@pixelacademy.md");
		Student newStudent2 = new Student("Iulian","Vataman","iulian@pixelacademy.md");
		Student newStudent3 = new Student("Maria","Mirabela","maria@pixelacademy.md");

		//salvam obiectele student in baza de date
		System.out.println("Saving the students...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

	}

}