package mx.nestor.rest.webservices.restfulwebservices.course.jdbc;

import mx.nestor.rest.webservices.restfulwebservices.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "01", "nestor1"));
        repository.insert(new Course(2, "02", "nestor2"));
        repository.insert(new Course(3, "03", "nestor3"));
        repository.delete(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }

}
