package com.cc.CentralLibrary.repository;

import com.cc.CentralLibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByJmbg(Long jmbg);
}
