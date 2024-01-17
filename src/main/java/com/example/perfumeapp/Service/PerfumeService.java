package com.example.perfumeapp.Service;

import com.example.perfumeapp.Domain.Perfume;

import java.util.List;

public interface PerfumeService {
    Perfume savePerfume(Perfume perfume);
    Perfume getPerfumeById(long Id);
    List<Perfume> getAllPerfume();
    Perfume updatePerfume(Perfume perfume);
    void deletePerfume(long Id);


}
