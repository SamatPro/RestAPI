package ru.itits.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itits.restapi.dto.LoginDto;
import ru.itits.restapi.dto.TokenDto;
import ru.itits.restapi.services.LoginService;

@RestController
public class LoginController {

  @Autowired
  private LoginService service;

  @PostMapping("/login")
  @PreAuthorize("permitAll()")
  public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginData) {
    return ResponseEntity.ok(service.login(loginData));
  }
}