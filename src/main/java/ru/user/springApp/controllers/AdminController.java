package ru.user.springApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.user.springApp.dao.PersonDAO;
import ru.user.springApp.models.Person;

@Controller()
@RequestMapping("/admin")
public class AdminController {
    private PersonDAO personDAO;

    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    @GetMapping()
    public String AdminPage(Model model, @ModelAttribute("person")Person person){
        model.addAttribute("people", personDAO.index());
        return "adminPage";
    }
    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId());
        return "redirect:/people";
    }
}
