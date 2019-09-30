package com.myKidGoal.controller;

import com.myKidGoal.model.Notice;
import com.myKidGoal.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sms/notices")
public class NoticeController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/search/all")
    public Map<String, Object> allNotices() {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> res = new HashMap<>();
        res.put("notice", noticeRepository.findAll());
        response.put("_embedded", res);
        return response;
    }

    @PostMapping("/save")
    public void saveNotice(@RequestBody Notice notice) {
        noticeRepository.save(notice);
    }

}
