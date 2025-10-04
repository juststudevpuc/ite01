package ite.ite204.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ite.ite204.models.Java_Mid;
import ite.ite204.repository.Java_MidRepository;

@Controller
@RequestMapping("/java_mid")
public class Java_MidController {

    @Autowired
    private Java_MidRepository java_MidRepository;
    // show all
    @GetMapping({"/",""})
    public String ListStudent(Model model) {
        model.addAttribute("students", java_MidRepository.findAll());
        return "java_mid/index";
    }
    // add new
    @GetMapping("/add")
    public String addNewStudent(Model model) {
            model.addAttribute("students", new Java_Mid());
        return "java_mid/add";
    }
    // save form
    @PostMapping("/save")    
    public String saveStudent(Java_Mid student) {
        java_MidRepository.save(student);
        return "redirect:/java_mid/";
    }
    // edit
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("students", java_MidRepository.findById(id).get());
        return "java_mid/edit";
    }
    @PostMapping("/update")
    public String updateStudent(Java_Mid student) {
        java_MidRepository.save(student);
        return "redirect:/java_mid/";
    }
    // delete
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable() int id) {
        java_MidRepository.deleteById(id);
        return "redirect:/java_mid/";
    }

    
}
