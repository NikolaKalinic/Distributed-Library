package com.cc.CityLibrary.service;

import com.cc.CityLibrary.dto.User;
import com.cc.CityLibrary.model.Book;
import com.cc.CityLibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void returnBook(Long jmbg) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9000/api/central/return/" + jmbg;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

         restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                String.class
        );
    }

    public boolean rentBook(Book book) {
        System.out.println();
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:9000/api/central/rent/"+book.getUserId();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> requestEntity = new HttpEntity<>(headers);

             restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    requestEntity,
                    String.class
            );
             book.setDate(LocalDate.now());
            bookRepository.save(book);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
