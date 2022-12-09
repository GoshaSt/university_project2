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
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ChildrenServiceImpl implements ChildrenService {

    private final ChildrenRepository childrenRepository;

    private final GiftRepository giftRepository;

    private final DwarfRepository dwarfRepository;

    private final DwarfChildrenRepository dwarfChildrenRepository;

    private final DwarfChildrenService dwarfChildrenService;

    Random random = new java.util.Random();

    @Override
    public void addChildren(ChildrenRequest childrenRequest) {
        DwarfChildren dwarfChildren = DwarfChildren.builder().build();
        Children saveChildren = ModelMapperUtil.modelMapper().map(childrenRequest, Children.class);
        childrenRepository.save(saveChildren);
        if (childrenRequest.getNaughty().equals("Y")) {
            dwarfChildren.setChildren(saveChildren);
            dwarfChildren.setGift(giftRepository.getByGift("Coallump"));
            dwarfChildren.setDwarf(dwarfRepository.findById(dwarfChildrenService.getFreeDwarfId()).orElseThrow());
            dwarfChildrenRepository.save(dwarfChildren);
            new FirstDwarf().start();
        }
        if (childrenRequest.getNaughty().equals("N") && childrenRequest.getGender().equals("F")) {
            dwarfChildren.setChildren(saveChildren);
            dwarfChildren.setDateCreated(saveChildren.getDateCreated());
            dwarfChildren.setGift(giftRepository.getByGift("Barbiedoll"));
            dwarfChildren.setDwarf(dwarfRepository.findById(dwarfChildrenService.getFreeDwarfId()).orElseThrow());
            dwarfChildrenRepository.save(dwarfChildren);
            new SecondDwarf().start();
        }
        if (childrenRequest.getNaughty().equals("N") && childrenRequest.getGender().equals("M")) {
            dwarfChildren.setChildren(saveChildren);
            dwarfChildren.setDateCreated(saveChildren.getDateCreated());
            dwarfChildren.setGift(giftRepository.getByGift("Actionman"));
            dwarfChildren.setDwarf(dwarfRepository.findById(dwarfChildrenService.getFreeDwarfId()).orElseThrow());
            dwarfChildrenRepository.save(dwarfChildren);
            new ThirdDwarf().start();
        }
        dwarfChildrenRepository.save(dwarfChildren);
    }

    @Override
    public void updateChildren(ChildrenRequest childrenRequest) {
        Children saveChildren = ModelMapperUtil.modelMapper().map(childrenRequest, Children.class);
        childrenRepository.save(saveChildren);
    }

    @Override
    public int childrenWithGift() {
        return childrenRepository.childrenWithGift();
    }

    @Override
    public int childrenWithoutGift() {
        return childrenRepository.childrenWithoutGift();
    }

    class FirstDwarf extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            DwarfChildren dwarfChildren = dwarfChildrenRepository.getChild().get(0);
            FirstDwarf.sleep((random.nextInt(4) + 6) * 1000);
            dwarfChildren.setDateFinished(dwarfChildren.getDateCreated().plusSeconds(random.nextInt(4) + 6));
            dwarfChildrenRepository.save(dwarfChildren);
            Children children = childrenRepository.findById(dwarfChildren.getChildren().getId()).orElseThrow();
            children.setDateFinished(dwarfChildren.getDateFinished());
            childrenRepository.save(children);
        }
    }

    class SecondDwarf extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            DwarfChildren dwarfChildren = dwarfChildrenRepository.getChild().get(0);
            SecondDwarf.sleep((random.nextInt(4) + 6) * 1000);
            dwarfChildren.setDateFinished(dwarfChildren.getDateCreated().plusSeconds(random.nextInt(4) + 6));
            dwarfChildrenRepository.save(dwarfChildren);
            Children children = childrenRepository.findById(dwarfChildren.getChildren().getId()).orElseThrow();
            children.setDateFinished(dwarfChildren.getDateFinished());
            childrenRepository.save(children);
        }
    }

    class ThirdDwarf extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            DwarfChildren dwarfChildren = dwarfChildrenRepository.getChild().get(0);
            ThirdDwarf.sleep((random.nextInt(4) + 6) * 1000);
            dwarfChildren.setDateFinished(dwarfChildren.getDateCreated().plusSeconds(random.nextInt(4) + 6));
            dwarfChildrenRepository.save(dwarfChildren);
            Children children = childrenRepository.findById(dwarfChildren.getChildren().getId()).orElseThrow();
            children.setDateFinished(dwarfChildren.getDateFinished());
            childrenRepository.save(children);
        }
    }
}
