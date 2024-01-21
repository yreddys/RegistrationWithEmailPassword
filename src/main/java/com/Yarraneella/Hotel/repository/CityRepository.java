package com.Yarraneella.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yarraneella.Hotel.entity.City;
@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
