package ru.itits.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itits.restapi.models.Token;


import java.time.LocalDateTime;
import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token, Long> {
  Optional<Token> findFirstByValue(String value);
  void deleteTokensByExpiredDateTimeBefore(LocalDateTime now);
}
