package com.example.perfumeapp.controller.api;

import com.example.perfumeapp.Domain.Perfume;
import com.example.perfumeapp.Repository.PerfumeRepository;
import com.example.perfumeapp.Service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PerfumeAPI {

    @Autowired
    PerfumeRepository perfumeRepository;
    @Autowired
    PerfumeService perfumeService;
    @RequestMapping("/perfume")
    @GetMapping("/perfume")
    public ResponseEntity<List<Perfume>> getAllPerfume(){
        return ResponseEntity.ok().body(perfumeService.getAllPerfume());
    }
    @GetMapping
    public ResponseEntity<Perfume> getPerfumeById(@PathVariable long id){
        return ResponseEntity.ok().body(perfumeService.getPerfumeById(id));
    }
    @PostMapping("/perfume")
    public ResponseEntity<Perfume> savePerfume(@RequestBody Perfume perfume){
        return ResponseEntity.ok().body(perfumeService.savePerfume(perfume));
    }
    @PutMapping("/perfume/{id}")
    public ResponseEntity<Perfume> updatePerfume(@PathVariable long id, @RequestBody Perfume perfume){
        return ResponseEntity.ok().body(perfumeService.updatePerfume(perfume));
    }
    @DeleteMapping("/perfume/{id}")
    public HttpStatus deletePerfume(@PathVariable long id ){
        perfumeService.deletePerfume(id);
        return HttpStatus.OK;
    }

}
