package com.Duoc.TheBestSeries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Duoc.TheBestSeries.model.Usuario_Serie;

@Repository
public interface Usuario_serie_Repository extends JpaRepository<Usuario_Serie, Integer> {
}

