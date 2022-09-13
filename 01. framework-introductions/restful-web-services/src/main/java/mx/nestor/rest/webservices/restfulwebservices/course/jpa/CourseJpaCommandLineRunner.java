package mx.nestor.rest.webservices.restfulwebservices.course.jpa;

import mx.nestor.rest.webservices.restfulwebservices.course.Course;
import mx.nestor.rest.webservices.restfulwebservices.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    //@Autowired
    //private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //repository.save(new Course(1L, "04", "nestor4"));
        //repository.save(new Course(2L, "05", "nestor6"));
        //repository.save(new Course(3L, "06", "nestor6"));
        //repository.deleteById(2L);

        //System.out.println(repository.findById(1L))
        // System.out.println(repository.findById(3L));
        System.out.println(repository.count());
        //System.out.println(repository.findAll());
        //System.out.println(repository.findByAuthor("nestor6"));
        //System.out.println(repository.findByName("05"));

    }
}
