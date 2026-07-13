package com.Duoc.TheBestSeries.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Duoc.TheBestSeries.model.Resena;


@Repository
public interface ResenaRepository extends JpaRepository<Resena, Integer>{
    
}
