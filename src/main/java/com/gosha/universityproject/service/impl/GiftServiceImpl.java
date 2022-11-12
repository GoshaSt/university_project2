package com.gosha.universityproject.service.impl;


import com.gosha.universityproject.entity.Gift;
import com.gosha.universityproject.model.GiftRequest;
import com.gosha.universityproject.repository.GiftRepository;
import com.gosha.universityproject.service.GiftService;
import com.gosha.universityproject.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GiftServiceImpl implements GiftService {

    private final GiftRepository giftRepository;

    @Override
    public void addGift(GiftRequest giftRequest) {
        Gift saveGift = ModelMapperUtil.modelMapper().map(giftRequest, Gift.class);
        giftRepository.save(saveGift);
    }
}
