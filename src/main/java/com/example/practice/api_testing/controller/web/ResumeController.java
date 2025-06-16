package com.example.practice.api_testing.controller.web;

import com.example.practice.api_testing.config.ResumeConfig;
import com.example.practice.api_testing.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    ResumeConfig resumeConfig;

    @Value("${site.title}")
    String siteTitle;

    @Value("${site.description}")
    String siteDescription;

    @Autowired
    StudentService studentService;

    @GetMapping
    public String indexPage(Model model) {
        log.debug("Setting the model data");
        model.addAttribute("siteTitle", siteTitle);
        model.addAttribute("siteDescription", siteDescription);
        model.addAttribute("personalInfo", resumeConfig.getPersonalInfo());
        model.addAttribute("education", resumeConfig.getEducation());
        model.addAttribute("experience", resumeConfig.getExperience());
        model.addAttribute("skills", resumeConfig.getSkills());
        model.addAttribute("students", studentService.getStudents(Pageable.unpaged()));
        log.debug("Model data setup done");
        return "resume/index";
    }
}
