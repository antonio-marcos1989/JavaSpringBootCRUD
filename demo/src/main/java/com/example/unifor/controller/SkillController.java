package com.example.unifor.controller;

import com.example.unifor.entity.Skill;
import com.example.unifor.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;
    @GetMapping
    public List<Skill> getAllSkills(){
        return skillService.findAllSkills();
    }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill){
        return skillService.saveSkill(skill);
    }



}
