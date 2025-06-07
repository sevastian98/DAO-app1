package pixel.academy.CRUD_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.CRUD_app.dao.StudentDAO;
import pixel.academy.CRUD_app.entity.Student;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Obtine lista de studenti
		List<Student> theStudents = studentDAO.findAll();

		//  Afiseaza lista de studenti
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}
	}

	private void createStudent(StudentDAO studentDAO) {

		// Cream un obiect Studnet
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("Mircea","Popescu","mircea@pixel.md");

		// Salvam obiectul Student in baza de date folosind DAO
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		// Afisam ID-ul studentului salvat
		System.out.println("Saved student. Generated id: " + newStudent.getId());
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
	private void readStudent(StudentDAO studentDAO) {

		// Creeaza un obiect de tip Student
		System.out.println("Creating new student object ...");
		Student newStudent = new Student("Mircea", "Popescu","mircea@pixel.md");

		// Salveaza studentul in baza de date
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// Afiseaza Id-ul studentului salvat
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// Recupereaza studentul pe baza ID-ului (PK)
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Afiseaza detaliile studentului
		System.out.println("Found the student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//returneaza lista de studenti
		List<Student> theStudent = studentDAO.findByLastName("Popescu");

		//afiseaza lista de studenti
		for (Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}

	private void updateStudent(StudentDAO studentDao) {

		// Gaseste studentul in baza de date folosind ID-ul (cheia primara)
			int studentID = 1;
		System.out.println("Getting student with id: " + studentID);
		Student newStudent = studentDao.findById(studentID);

		// Modifica prenumele studentului in "Ion"
		System.out.println("Updating student....");
		newStudent.setFirstName("Ion");

		// Salveaza modificarile in baza de date
		studentDao.update(newStudent);

		// Afiseaza detaliile studentului actualizat
		System.out.println("Updated student: " + newStudent);


	}


}