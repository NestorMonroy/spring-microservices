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
        repository.save(new Course(4L, "04", "nestor4"));
        repository.save(new Course(5L, "05", "nestor5"));
        repository.save(new Course(6L, "06", "nestor6"));
        repository.deleteById(4L);

        System.out.println(repository.findById(5L));
        System.out.println(repository.findById(6L));
        System.out.println(repository.count());
        System.out.println(repository.findAll());
        System.out.println(repository.findByAuthor("nestor6"));
        System.out.println(repository.findByName("05"));

    }
}
