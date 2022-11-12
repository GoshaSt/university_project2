package com.gosha.universityproject.controller;

import com.gosha.universityproject.model.DwarfRequest;
import com.gosha.universityproject.service.DwarfService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dwarf")
public class DwarfController {

    private final DwarfService dwarfService;

    @PostMapping("/create")
    public void createDwarf(@RequestBody DwarfRequest dwarfRequest) {
        dwarfService.addDwarf(dwarfRequest);
    }
}
