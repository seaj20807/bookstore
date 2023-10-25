package hh.sof03.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUsersShouldReturnUser() {
        List<User> users = (List<User>) userRepository.findAll();
        assertThat(users).hasSize(2);
        assertThat(users.get(0).getUsername()).isEqualTo("user");
    }

    @Test
    public void createNewUser() {
        User user = new User("tester", "$2a$10$85IiCmYjdV1Jz8c3F5E4buVn5M4EWKQ4olN4swICYR2YnQSBE8IYy", "TESTER");
        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void deleteUser() {
        User user = new User("tester", "$2a$10$85IiCmYjdV1Jz8c3F5E4buVn5M4EWKQ4olN4swICYR2YnQSBE8IYy", "TESTER");
        userRepository.save(user);
        assertThat(userRepository.count()).isEqualTo(3);
        userRepository.delete(user);
        assertThat(userRepository.count()).isEqualTo(2);
    }

}
