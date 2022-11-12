package com.gosha.universityproject.service.impl;

import com.gosha.universityproject.entity.Children;
import com.gosha.universityproject.entity.DwarfChildren;
import com.gosha.universityproject.model.ChildrenRequest;
import com.gosha.universityproject.repository.ChildrenRepository;
import com.gosha.universityproject.repository.DwarfChildrenRepository;
import com.gosha.universityproject.repository.DwarfRepository;
import com.gosha.universityproject.repository.GiftRepository;
import com.gosha.universityproject.service.ChildrenService;
import com.gosha.universityproject.service.DwarfChildrenService;
import com.gosha.universityproject.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChildrenServiceImpl implements ChildrenService {

    private final ChildrenRepository childrenRepository;

    private final GiftRepository giftRepository;

    private final DwarfRepository dwarfRepository;

    private final DwarfChildrenRepository dwarfChildrenRepository;

    private final DwarfChildrenService dwarfChildrenService;

    @Override
    public void addChildren(ChildrenRequest childrenRequest) {
        DwarfChildren dwarfChildren = DwarfChildren.builder().build();
        Children saveChildren = ModelMapperUtil.modelMapper().map(childrenRequest, Children.class);
        childrenRepository.save(saveChildren);
        if (childrenRequest.getNaughty().equals("Y")) {
            dwarfChildren.setChildren(saveChildren);
            dwarfChildren.setGift(giftRepository.getByGift("Coallump"));
            dwarfChildren.setDwarf(dwarfRepository.findById(dwarfChildrenService.getFreeDwarfId()).orElseThrow());
            dwarfChildren.setDateFinished(LocalDateTime.now());
            saveChildren.setDateFinished(LocalDateTime.now());
        }
        if (childrenRequest.getNaughty().equals("N") && childrenRequest.getGender().equals("F")) {
            dwarfChildren.setChildren(saveChildren);
            dwarfChildren.setDateCreated(saveChildren.getDateCreated());
            dwarfChildren.setGift(giftRepository.getByGift("Barbiedoll"));
            dwarfChildren.setDwarf(dwarfRepository.findById(dwarfChildrenService.getFreeDwarfId()).orElseThrow());
            dwarfChildren.setDateFinished(LocalDateTime.now());
            saveChildren.setDateFinished(LocalDateTime.now());
        }
        if (childrenRequest.getNaughty().equals("N") && childrenRequest.getGender().equals("M")) {
            dwarfChildren.setChildren(saveChildren);
            dwarfChildren.setDateCreated(saveChildren.getDateCreated());
            dwarfChildren.setGift(giftRepository.getByGift("Actionman"));
            dwarfChildren.setDwarf(dwarfRepository.findById(dwarfChildrenService.getFreeDwarfId()).orElseThrow());
            dwarfChildren.setDateFinished(LocalDateTime.now());
            saveChildren.setDateFinished(LocalDateTime.now());
        }
        dwarfChildrenRepository.save(dwarfChildren);
    }

    @Override
    public void updateChildren(ChildrenRequest childrenRequest) {
        Children saveChildren = ModelMapperUtil.modelMapper().map(childrenRequest, Children.class);
        childrenRepository.save(saveChildren);
    }
}
