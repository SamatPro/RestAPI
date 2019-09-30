package ru.itits.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itits.restapi.dto.LoginDto;
import ru.itits.restapi.dto.TokenDto;
import ru.itits.restapi.models.Token;
import ru.itits.restapi.models.User;
import ru.itits.restapi.repositories.TokensRepository;
import ru.itits.restapi.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private TokensRepository tokensRepository;

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private UsersRepository usersRepository;

  @Value("${token.expired}")
  private Integer expiredSecondsForToken;

  @Override
  public TokenDto login(LoginDto loginData) {
    Optional<User> userCandidate = usersRepository.findFirstByLoginIgnoreCase(loginData.getLogin());

    if (userCandidate.isPresent()) {
      User user = userCandidate.get();
      if (encoder.matches(loginData.getPassword(), user.getPasswordHash())) {
        String value = UUID.randomUUID().toString();
        Token token = Token.builder()
                .createdAt(LocalDateTime.now())
                .expiredDateTime(LocalDateTime.now().plusSeconds(expiredSecondsForToken))
                .value(value)
                .user(user)
                .build();
        tokensRepository.save(token);
        return TokenDto.from(value);
      }
    } throw new BadCredentialsException("Incorrect login or password");
  }
}
