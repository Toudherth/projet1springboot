package com.example.projet1springboot.repositories;

import com.example.projet1springboot.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
