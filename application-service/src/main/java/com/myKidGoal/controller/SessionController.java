package com.myKidGoal.controller;

import com.myKidGoal.repository.examination.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/academicsession")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    // @GetMapping("title/search/all")
    // public Map<String, Object> allExamTitles() {
    // Map<String, Object> response = new HashMap<>();
    // Map<String, Object> res = new HashMap<>();
    // res.put("examtitles", examTitleRepository.findByDeletedIsFalse());
    // response.put("_embedded", res);
    // return response;
    // }
    //
    // @PostMapping("/title/save")
    // public void saveArea(@RequestBody ExamTitle examTitle) {
    // examTitleRepository.save(examTitle);
    // }
    //
    // @GetMapping("/title/search/details/{id}")
    // public ExamTitle oneExamTitle(@PathVariable(value = "id") int id) {
    // Optional<ExamTitle> optionalExamTitle = examTitleRepository.findById(id);
    //
    // if (optionalExamTitle.isPresent()) {
    // return optionalExamTitle.get();
    // } else {
    // throw new RuntimeException("ExamTitle not found with ID [" + id + "]");
    // }
    // }
    //
    // @GetMapping("/title/search/all/active")
    // public Map<String, Object> allExamTitlesActive() {
    // Map<String, Object> response = new HashMap<>();
    // Map<String, Object> res = new HashMap<>();
    // res.put("examtitles", examTitleRepository.findByDeletedIsFalseAndActiveIsTrue());
    // response.put("_embedded", res);
    // return response;
    // }

    @GetMapping(value = "/isUnique/{name}/{id}")
    public Map<String, String> isUniqueSessionName(@PathVariable(value = "name") String name,
            @PathVariable(value = "id") int id) {

        Boolean isSessionExists;
        if (id == 0) {
            isSessionExists = !sessionRepository.existsByNameIgnoreCaseAndDeletedIsFalse(name);
        } else {
            isSessionExists = !sessionRepository.existsByNameIgnoreCaseAndDeletedIsFalseAndIdNot(name, id);
        }

        Map<String, String> response = new HashMap<>();
        response.put("isUnique", String.valueOf(isSessionExists));
        return response;
    }

    // @PutMapping("/title/update")
    // public void updateAudience(@RequestBody ExamTitle examTitle) {
    // if (examTitle.getId() == 0) {
    // throw new EntityNotFoundException(
    // "Audience can't be updated before saving. First save the examTitle and then try updating!");
    // }
    //
    // examTitleRepository.save(examTitle);
    // }

}
