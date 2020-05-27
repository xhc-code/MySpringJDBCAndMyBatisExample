package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Mapper
public interface CityMapper extends CrudRepository<City,String>{

    Optional<City> findById(String id);

}