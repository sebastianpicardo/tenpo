package com.tenpo.spicardo.controller;

import com.tenpo.spicardo.model.History;
import com.tenpo.spicardo.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryRepository repository;

    @GetMapping
    public Page<History> getHistory(Pageable pageable) {
        return repository.findAll(pageable);
    }
}