package com.example.perfumeapp.controller;

import com.example.perfumeapp.Domain.Perfume;
import com.example.perfumeapp.Service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class PerfumeController {
    @Autowired
    PerfumeService perfumeService;

    @GetMapping("/PerfumeHomepage")
    public String homePage(Model model){
        model.addAttribute("perfume",perfumeService.getAllPerfume());
        return "home";

    }
    @GetMapping("/ShowPerfumeForm")
    public String showPerfumeForm(Model model){
        Perfume perfume= new Perfume();
        model.addAttribute("perfume",perfume);
        model.addAttribute("nextPage","New Perfume");
        return "New_Perfume";

    }

    @PostMapping("/savePerfume")
    public String savePerfume(@ModelAttribute("perfume") Perfume perfume, RedirectAttributes redirectAttributes){
        perfumeService.savePerfume(perfume);
        redirectAttributes.addFlashAttribute("message", "Perfume update");
        redirectAttributes.addFlashAttribute("color", "success");

        return "redirect:/PerfumeHomepage";
    }
    @GetMapping("/updatePerfume/{id}")
    public String showEditForm(@PathVariable("id") Integer Id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Perfume perfume = perfumeService.getPerfumeById(Id);
            model.addAttribute("perfume", perfume);
            model.addAttribute("pageTitle", "Edit Perfume Id:" + Id);
            return "updatePerfume";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");

            return "redirect:/PerfumeHomepage";
        }
    }
    @PostMapping("/updatePerfume")
    public String updatePerfume(@ModelAttribute("perfume") Perfume perfume, RedirectAttributes redirectAttributes){
        try {
            perfumeService.savePerfume(perfume);
            redirectAttributes.addFlashAttribute("message", "Perfume Record updated successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating perfume: " + e.getMessage());
            redirectAttributes.addFlashAttribute("color", "success");
        }
        return "redirect:/PerfumeHomepage";
    }
    @GetMapping("deletePerfume/{id}")
    public String deletePerfume(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            perfumeService.deletePerfume(id);
            redirectAttributes.addFlashAttribute("message", "Perfume Deleted successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");
        }

        return "redirect:/PerfumeHomepage";
    }
}
