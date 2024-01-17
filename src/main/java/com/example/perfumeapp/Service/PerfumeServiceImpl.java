package com.example.perfumeapp.Service;


import com.example.perfumeapp.Domain.Perfume;
import com.example.perfumeapp.Repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PerfumeServiceImpl implements PerfumeService {
    @Autowired
    PerfumeRepository perfumeRepository;
    @Override
    public Perfume savePerfume(Perfume perfume) {

        return perfumeRepository.save(perfume);
    }
    @Override
    public Perfume getPerfumeById(long Id) {
        Optional<Perfume> perfume = perfumeRepository.findById(Id);
        Perfume emptyPerfume = null;
        if (perfume.isPresent()) {
            emptyPerfume = perfume.get();
            return emptyPerfume;
        }
        else {
            throw new RuntimeException("Perfume not found");
        }
    }
    @Override
    public List<Perfume> getAllPerfume() {

        return perfumeRepository.findAll();
    }



    @Override
    public Perfume updatePerfume(Perfume perfume) {
        Optional<Perfume> optionalPerfume = perfumeRepository.findById(perfume.getId());
        if(optionalPerfume.isPresent()){
            Perfume updatePerfume = new Perfume();
            updatePerfume.setId(perfume.getId());
            updatePerfume.setName(perfume.getName());
            updatePerfume.setCompany(perfume.getCompany());
            updatePerfume.setBrand(perfume.getBrand());
            updatePerfume.setPrice(perfume.getPrice());
            perfumeRepository.save(updatePerfume);
            return updatePerfume;
        }
        else{
            throw new RuntimeException("Perfume not found");
        }
    }
    @Override
    public void deletePerfume(long Id) {
        perfumeRepository.deleteById(Id);

    }


}
