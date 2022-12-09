package com.gosha.universityproject.service;

import com.gosha.universityproject.entity.Children;
import com.gosha.universityproject.model.ChildrenRequest;
import com.gosha.universityproject.repository.ChildrenRepository;
import com.gosha.universityproject.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class ThreadService {

    private final ChildrenService childrenService;

    private final DwarfService dwarfService;

    private final ChildrenRepository childrenRepository;

    Random random = new java.util.Random();

    public void startThreads() {
        new MainThread().start();
        new AddChild().start();
    }

    class AddChild extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                Children newChildren = Children.builder()
                        .name(getAlphaNumericString(6))
                        .gender(getGender())
                        .naughty(getNaughty())
                        .build();
                ChildrenRequest savedChild = ModelMapperUtil.modelMapper().map(newChildren, ChildrenRequest.class);
                try {
                    childrenService.addChildren(savedChild);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String getAlphaNumericString(int n) {

        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        String name;
        name = sb.toString();
        name = name.toLowerCase();
        name = StringUtils.capitalize(name);

        return name;
    }

    public String getGender() {
        int tmp = random.nextInt(2) + 1;
        if (tmp == 2) {
            return "M";
        } else return "F";
    }

    public String getNaughty() {
        int tmp = random.nextInt(2) + 1;
        if (tmp == 2) {
            return "N";
        } else return "Y";
    }

    class MainThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
                System.out.println("Всего детей: " + childrenRepository.findAll().size());
                System.out.println("Детей получило подарок: " + childrenService.childrenWithGift());
                System.out.println("Детей еще не получило подарок: " + childrenService.childrenWithoutGift());

                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

                System.out.println("Детей у гнома Mike: " + dwarfService.countMikeChildren());
                System.out.println("Детей у гнома Alex: " + dwarfService.countAlexChildren());
                System.out.println("Детей у гнома Tim: " + dwarfService.countTimChildren());

                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

                System.out.println("Детей у гнома Mike с подарком: " + dwarfService.countMikeChildrenWithGift());
                System.out.println("Детей у гнома Alex с подарком: " + dwarfService.countAlexChildrenWithGift());
                System.out.println("Детей у гнома Tim с подарком: " + dwarfService.countTimChildrenWithGift());

                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

                System.out.println("Детей у гнома Mike без подарка: " + dwarfService.countMikeChildrenWithoutGift());
                System.out.println("Детей у гнома Alex без подарка: " + dwarfService.countAlexChildrenWithoutGift());
                System.out.println("Детей у гнома Tim без подарка: " + dwarfService.countTimChildrenWithoutGift());
                System.out.println("____________________________________________________________________");
            }
        }
    }


}
