package com.example.perfumeapp.Repository;

import com.example.perfumeapp.Domain.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeRepository extends JpaRepository< Perfume, Long > {

}
