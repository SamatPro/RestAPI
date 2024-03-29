package ru.itits.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itits.restapi.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
  Optional<User> findFirstByLoginIgnoreCase(String login);
  List<User> findAllByOrderByAge();
  List<User> findAllByOrderByAgeDesc();
  List<User> findAllByOrderById();
  List<User> findAllByOrderByIdDesc();
  List<User> findAllByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(String keyword1, String keyword2);
}
