package com.homework.spring_ukrmail.controller;

import com.homework.spring_ukrmail.models.Remittance;
import com.homework.spring_ukrmail.service.RemittanceService;
import lombok.AllArgsConstructor;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@Controller
public class RemiController {

    private RemittanceService service;

    @GetMapping("/remi/add") // отримуэмо шаблон для заповнення
    public String noteAdd(Model model) {
        return "remi-add";
    }

    @PostMapping("/remi/add")
    public String addRemi(@RequestParam int money, @RequestParam String number,
                          @RequestParam String description) {
        //  Remittance rem = new Remittance(money, number, description);
        Remittance rem = new Remittance(money, number, description);
        rem.setDate(LocalDate.now());
        service.addRem(rem);

        return "redirect:/list";

    }

    @GetMapping("/list")
    public String home(Model model) {
        Iterable<Remittance> rem = service.findAll();
        model.addAttribute("remiList", rem);
        return "remi-all";
    }

    @PostMapping("/remi/delete")
    public String deleteRemi(@RequestParam Long id) {
        service.deleteRemi(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}") // гет шаблон для редагування
    public String RemiEdit(@PathVariable(value = "id") Long id, Model model) throws ChangeSetPersister.NotFoundException {
        if (service.getById(id) == null) {
            return "redirect:/list";
        }
        model.addAttribute("remiList", service.getById(id));

        return "remi-edit";
    }


    @PostMapping("/edit") // post релізація
    public String noteUpdate(Long id,
                             @RequestParam String description) throws ChangeSetPersister.NotFoundException {


        Remittance remittance = service.getById(id);
        remittance.setDescription(description);
        service.updateRemi(remittance);
        return "redirect:/list";
    }

}
