package com.myKidGoal.controller;

import com.myKidGoal.model.examination.SubjectTitle;
import com.myKidGoal.repository.examination.SubjectTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/subjecttitle")
public class SubjectTitleController {

    @Autowired
    private SubjectTitleRepository subjectTitleRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allSubjectTitles() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("subjecttitles", subjectTitleRepository.findAll());
        response.put("_embedded", res);
        return response;

    }

    @PostMapping("/save")
    public void saveSubjectTitle(@RequestBody SubjectTitle subjectTitle) {
        subjectTitleRepository.save(subjectTitle);
    }

    @PutMapping("/update")
    public void updateSubjectTitle(@RequestBody SubjectTitle subjectTitle) {
        if (subjectTitle.getId() == 0) {
            throw new EntityNotFoundException(
                    "SubjectTitle can't be updated before saving. First save the SubjectTitle and then try updating!");
        }

        subjectTitleRepository.save(subjectTitle);
    }

    @GetMapping("/search/details/{id}")
    public SubjectTitle oneSubjectTitle(@PathVariable(value = "id") int id) {
        Optional<SubjectTitle> optionalSubjectTitle = subjectTitleRepository.findById(id);

        if (optionalSubjectTitle.isPresent()) {
            return optionalSubjectTitle.get();
        } else {
            throw new RuntimeException("SubjectTitle not found with ID [" + id + "]");
        }
    }

}
