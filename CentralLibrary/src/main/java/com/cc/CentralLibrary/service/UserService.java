package com.cc.CentralLibrary.service;

import com.cc.CentralLibrary.model.User;
import com.cc.CentralLibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean rendBook(Long jmbg) {
        User u = userRepository.findByJmbg(jmbg);
        return (u != null && u.getNumberOfBooks() < 3) ? incNumberOfBook(jmbg) : false;
    }

    private boolean incNumberOfBook(Long jmbg) {
        User u = userRepository.findByJmbg(jmbg);
        u.setNumberOfBooks(u.getNumberOfBooks() + 1);
        userRepository.save(u);
        return true;
    }

    public void returnBook(Long jmbg) {
        User u = userRepository.findByJmbg(jmbg);
        u.setNumberOfBooks(u.getNumberOfBooks() - 1);
        userRepository.save(u);
    }

    public boolean register(User u) {
        User user = userRepository.findByJmbg(u.getJmbg());
        if (user != null)
            return false;
        userRepository.save(u);
        return true;
    }
}
