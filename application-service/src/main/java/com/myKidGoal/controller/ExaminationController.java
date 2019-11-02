package com.myKidGoal.controller;

import com.myKidGoal.model.examination.ExamTitle;
import com.myKidGoal.model.examination.ExamType;
import com.myKidGoal.repository.examination.ExamTitleRepository;
import com.myKidGoal.repository.examination.ExamTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sms/exam")
public class ExaminationController {

    @Autowired
    private ExamTitleRepository examTitleRepository;

    @Autowired
    private ExamTypeRepository examTypeRepository;

    @GetMapping("title/search/all")
    public Map<String, Object> allExamTitles() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("examtitles", examTitleRepository.findByDeletedIsFalse());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/title/save")
    public void saveArea(@RequestBody ExamTitle examTitle) {
        examTitleRepository.save(examTitle);
    }

    @GetMapping("/title/search/details/{id}")
    public ExamTitle oneExamTitle(@PathVariable(value = "id") int id) {
        Optional<ExamTitle> optionalExamTitle = examTitleRepository.findById(id);

        if (optionalExamTitle.isPresent()) {
            return optionalExamTitle.get();
        } else {
            throw new RuntimeException("ExamTitle not found with ID [" + id + "]");
        }
    }

    @GetMapping("/title/search/all/active")
    public Map<String, Object> allExamTitlesActive() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("examtitles", examTitleRepository.findByDeletedIsFalseAndActiveIsTrue());
        response.put("_embedded", res);
        return response;
    }

    @GetMapping(value = "/title/isUnique/{name}/{id}")
    public Map<String, String> isUniqueExamTitleName(@PathVariable(value = "name") String name,
            @PathVariable(value = "id") int id) {

        Boolean isExamTitleExists;
        if (id == 0) {
            isExamTitleExists = !examTitleRepository.existsByNameIgnoreCaseAndDeletedIsFalse(name);
        } else {
            isExamTitleExists = !examTitleRepository.existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(name, id);
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isExamTitleExists));
        return response;
    }

    @PutMapping("/title/update")
    public void updateAudience(@RequestBody ExamTitle examTitle) {
        if (examTitle.getId() == 0) {
            throw new EntityNotFoundException(
                    "Audience can't be updated before saving. First save the examTitle and then try updating!");
        }

        examTitleRepository.save(examTitle);
    }

    @GetMapping("/type/search/all")
    public Map<String, Object> allExamTypes() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("examtypes", examTypeRepository.findByDeletedIsFalse());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/type/save")
    public void saveArea(@RequestBody ExamType examType) {
        examTypeRepository.save(examType);
    }

    @GetMapping("/type/search/details/{id}")
    public ExamType oneExamType(@PathVariable(value = "id") int id) {
        Optional<ExamType> optionalExamType = examTypeRepository.findById(id);

        if (optionalExamType.isPresent()) {
            return optionalExamType.get();
        } else {
            throw new RuntimeException("ExamType not found with ID [" + id + "]");
        }
    }

    @GetMapping("/type/search/all/active")
    public Map<String, Object> allExamTypeActive() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("examtypes", examTypeRepository.findByDeletedIsFalseAndActiveIsTrue());
        response.put("_embedded", res);
        return response;
    }

    @GetMapping(value = "/type/isUnique/{name}/{id}")
    public Map<String, String> isUniqueExamTypeName(@PathVariable(value = "name") String name,
            @PathVariable(value = "id") int id) {

        Boolean isExamTypeExists;
        if (id == 0) {
            isExamTypeExists = !examTypeRepository.existsByNameIgnoreCaseAndDeletedIsFalse(name);
        } else {
            isExamTypeExists = !examTypeRepository.existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(name, id);
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isExamTypeExists));
        return response;
    }

    @PutMapping("/type/update")
    public void updateExamType(@RequestBody ExamType examType) {
        if (examType.getId() == 0) {
            throw new EntityNotFoundException(
                    "Audience can't be updated before saving. First save the examType and then try updating!");
        }

        examTypeRepository.save(examType);
    }
}
