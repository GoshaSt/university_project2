package com.gosha.universityproject.controller;

import com.gosha.universityproject.model.GiftRequest;
import com.gosha.universityproject.service.GiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gift")
public class GiftController {
    private final GiftService giftService;

    @PostMapping("/create")
    public void createGift(@RequestBody GiftRequest giftRequest) {
        giftService.addGift(giftRequest);
    }
}
