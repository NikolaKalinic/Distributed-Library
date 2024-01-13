package com.cc.CityLibrary.contoler;

import com.cc.CityLibrary.model.Book;
import com.cc.CityLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookContoller {
    private final BookService bookService;

    @PutMapping("/rent")
    public ResponseEntity rentBook(@RequestBody Book book) {
        return bookService.rentBook(book) ? ResponseEntity.status(HttpStatus.OK).body("User rented successfully.") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already has 3 rents.");
    }

    @PutMapping("/return/{jmbg}")
    public ResponseEntity returnBook(@PathVariable("jmbg") Long jmbg) {
        return bookService.returnBook(jmbg) ? ResponseEntity.status(HttpStatus.OK).body("User returned book.") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This user has 0 rented books.");
    }
}
