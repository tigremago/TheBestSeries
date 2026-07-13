package com.Duoc.TheBestSeries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Duoc.TheBestSeries.model.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer>{

}
