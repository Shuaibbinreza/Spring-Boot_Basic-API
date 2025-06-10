package com.example.practice.api_testing.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.practice.api_testing.config.ResumeConfig;

@Controller
public class RootController {
    @Autowired
    ResumeConfig resumeConfig;

    @Value("${site.title}")
    String siteTitle;

    @Value("${site.description}")
    String siteDescription;


    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("siteTitle", siteTitle);
        model.addAttribute("siteDescription", siteDescription);
        model.addAttribute("personalInfo", resumeConfig.getPersonalInfo());
        model.addAttribute("education", resumeConfig.getEducation());
        model.addAttribute("experience", resumeConfig.getExperience());
        model.addAttribute("skills", resumeConfig.getSkills());
        return "index";
    }
}
