package com.gosha.universityproject.controller;

import com.gosha.universityproject.model.ChildrenRequest;
import com.gosha.universityproject.service.ChildrenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/children")
public class ChildrenController {

    private final ChildrenService childrenService;

    @PostMapping("/create")
    public void createChildren(@RequestBody ChildrenRequest childrenRequest) {
        childrenService.addChildren(childrenRequest);
    }

    @PostMapping("/update")
    public void updateChildren(@RequestBody ChildrenRequest childrenRequest) {
        childrenService.addChildren(childrenRequest);
    }
}
