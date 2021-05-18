package com.DAI.ProChild.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository  extends JpaRepository<User, String> {
}
