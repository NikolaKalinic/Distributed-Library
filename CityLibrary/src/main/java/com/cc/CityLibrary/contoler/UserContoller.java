package com.cc.CityLibrary.contoler;

import com.cc.CityLibrary.model.User;
import com.cc.CityLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class UserContoller {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User u) {
        return userService.register(u) ? ResponseEntity.status(HttpStatus.OK).body("User registered successfully.") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");
    }
}
