package com.example.firstproject.repository;

import com.example.firstproject.entity.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface NoticeRepository extends CrudRepository<Notice, Long> {

    @Override
    ArrayList<Notice> findAll();
}
