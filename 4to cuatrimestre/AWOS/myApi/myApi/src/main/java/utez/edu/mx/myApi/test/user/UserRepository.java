package utez.edu.mx.myApi.test.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
        List<User> findAll();
        User findById(long id);
        User save(User user);
        void deleteById(long id);
    }
