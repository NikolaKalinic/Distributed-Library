package com.cc.CentralLibrary.controler;

import com.cc.CentralLibrary.model.User;
import com.cc.CentralLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/central")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("/rent/{jmbg}")
    public ResponseEntity rentBook(@PathVariable("jmbg") Long jmbg) {
        return userService.rendBook(jmbg) ? ResponseEntity.status(HttpStatus.OK).body("User rented successfully.") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already has 3 rents.");
    }

    @PutMapping("/return/{jmbg}")
    public ResponseEntity returnBook(@PathVariable("jmbg") Long jmbg) {
        userService.returnBook(jmbg);
        return ResponseEntity.status(HttpStatus.OK).body("User returned book.");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User u) {
        return userService.register(u) ? ResponseEntity.status(HttpStatus.OK).body("User registered successfully.") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists.");
    }

}
