package com.cc.CityLibrary.contoler;

import com.cc.CityLibrary.model.Book;
import com.cc.CityLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class BookContoller {
    private final BookService bookService;

    @PutMapping("/rent")
    public ResponseEntity rentBook(@RequestBody Book book) {
        return bookService.rentBook(book) ? ResponseEntity.status(HttpStatus.OK).body("User rented successfully.") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already has 3 rents.");
    }

    @PutMapping("/return/{jmbg}")
    public ResponseEntity returnBook(@PathVariable("jmbg") Long jmbg) {
        bookService.returnBook(jmbg);
        return ResponseEntity.status(HttpStatus.OK).body("User returned book.");
    }
    //TODO AKO JMBG NE POSTOJI UHVATITI TAJ SLUCAJ
}
