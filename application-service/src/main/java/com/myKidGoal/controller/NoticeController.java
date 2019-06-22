package com.myKidGoal.controller;

import com.myKidGoal.model.Notice;
import com.myKidGoal.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms/notices")
public class NoticeController {

    @Autowired
    NoticeRepository noticeRepository;

    @GetMapping("/all")
    public List<Notice> allHouses() {
        return noticeRepository.findAll();
    }

    @PostMapping("/save")
    public void saveNotice(@RequestBody Notice notice) {
        noticeRepository.save(notice);
    }

}
