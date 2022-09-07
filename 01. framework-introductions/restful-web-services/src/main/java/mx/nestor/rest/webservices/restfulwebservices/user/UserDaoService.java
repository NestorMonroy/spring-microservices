package mx.nestor.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //JPA/Hibernate > Database
    //USERDaoService > Static List

    private static List<User> userList = new ArrayList<>();

    private static int userCount = 0;

    static {
        userList.add(new User(++userCount,"Usuario 1", LocalDate.now().minusYears(30)));
        userList.add(new User(++userCount,"Usuario 2", LocalDate.now().minusYears(20)));
        userList.add(new User(++userCount,"Usuario 3", LocalDate.now().minusYears(10)));
    }
    public List<User> findAll() {
        return userList;
    }
    
    public User save(User user){
        user.setId(++userCount);
        userList.add(user);
        return  user;
    };

    public User findOne(int id){
        Predicate<? super User> predicate = userList -> userList.getId().equals(id);
        return userList.stream().filter(predicate).findFirst().orElse(null);
    };

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        userList.removeIf(predicate);
    }
}
