package com.example.firstproject.controller;

import com.example.firstproject.dto.NoticeDTO;
import com.example.firstproject.entity.Notice;
import com.example.firstproject.repository.NoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class NoticeController {
    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notice/create")
    public String createNotice() {

        return "notice/create";
    }

    @PostMapping("/notice/create/post")
    public String postCreateNotice(NoticeDTO noticeDTO) {

        Notice notice = noticeDTO.toEntity();

        Notice save = noticeRepository.save(notice);

        log.info(save.toString());

        return "redirect:/notice/list/" + save.getId();
    }

    @GetMapping("notice/list")
    public String listNotice(Model model) {

        List<Notice> noticeEntity = noticeRepository.findAll();

        model.addAttribute("noticeList", noticeEntity);

        return "notice/list";
    }

    @GetMapping("notice/list/{id}")
    public String showNotice(@PathVariable Long id, Model model) {

        Notice noticeEntity = noticeRepository.findById(id).orElse(null);

        model.addAttribute("noticeView", noticeEntity);

        return "notice/show";
    }

}
