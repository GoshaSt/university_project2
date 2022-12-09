package com.gosha.universityproject.controller;

import com.gosha.universityproject.model.ChildrenRequest;
import com.gosha.universityproject.service.ChildrenService;
import com.gosha.universityproject.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/children")
public class ChildrenController {

    private final ChildrenService childrenService;

    private final ThreadService threadService;

    @PostMapping("/create")
    public void createChildren(@RequestBody ChildrenRequest childrenRequest) throws InterruptedException {
        childrenService.addChildren(childrenRequest);
    }

    @PostMapping("/update")
    public void updateChildren(@RequestBody ChildrenRequest childrenRequest) throws InterruptedException {
        childrenService.addChildren(childrenRequest);
    }

    @GetMapping("/start")
    public void start() {
        threadService.startThreads();
    }
}
