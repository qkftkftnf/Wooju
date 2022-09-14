package com.wooju.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wooju.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{	
	Optional<User> findByEmailAndUserType(String email,String usertype);

}
