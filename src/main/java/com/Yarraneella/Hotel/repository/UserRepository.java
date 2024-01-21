package com.Yarraneella.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yarraneella.Hotel.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
