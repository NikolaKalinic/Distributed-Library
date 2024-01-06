package com.cc.CityLibrary.service;

import com.cc.CityLibrary.dto.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    public boolean register(User u) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:9000/api/central/register";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<User> requestEntity = new HttpEntity<>(u, headers);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

            String responseBody = responseEntity.getBody();
            System.out.println("Response Body: " + responseBody);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
