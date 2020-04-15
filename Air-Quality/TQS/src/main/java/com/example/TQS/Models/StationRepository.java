package com.example.TQS.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    Station findByIdApi(Long id_api);
    List<Station> findAll();
    Station findByName(String name);
}