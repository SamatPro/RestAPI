package ru.itits.restapi.services;

import ru.itits.restapi.dto.LoginDto;
import ru.itits.restapi.dto.TokenDto;

public interface LoginService {
  TokenDto login(LoginDto loginData);

}
