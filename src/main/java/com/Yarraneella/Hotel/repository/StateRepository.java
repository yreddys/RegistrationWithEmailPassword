package com.Yarraneella.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yarraneella.Hotel.entity.State;
@Repository
public interface StateRepository extends JpaRepository<State, Long>{

}
