package com.ptpl.veternary_website.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ptpl.veternary_website.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
