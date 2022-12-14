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
                System.out.println("?????????? ??????????: " + childrenRepository.findAll().size());
                System.out.println("?????????? ???????????????? ??????????????: " + childrenService.childrenWithGift());
                System.out.println("?????????? ?????? ???? ???????????????? ??????????????: " + childrenService.childrenWithoutGift());

                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

                System.out.println("?????????? ?? ?????????? Mike: " + dwarfService.countMikeChildren());
                System.out.println("?????????? ?? ?????????? Alex: " + dwarfService.countAlexChildren());
                System.out.println("?????????? ?? ?????????? Tim: " + dwarfService.countTimChildren());

                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

                System.out.println("?????????? ?? ?????????? Mike ?? ????????????????: " + dwarfService.countMikeChildrenWithGift());
                System.out.println("?????????? ?? ?????????? Alex ?? ????????????????: " + dwarfService.countAlexChildrenWithGift());
                System.out.println("?????????? ?? ?????????? Tim ?? ????????????????: " + dwarfService.countTimChildrenWithGift());

                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");

                System.out.println("?????????? ?? ?????????? Mike ?????? ??????????????: " + dwarfService.countMikeChildrenWithoutGift());
                System.out.println("?????????? ?? ?????????? Alex ?????? ??????????????: " + dwarfService.countAlexChildrenWithoutGift());
                System.out.println("?????????? ?? ?????????? Tim ?????? ??????????????: " + dwarfService.countTimChildrenWithoutGift());
                System.out.println("____________________________________________________________________");
            }
        }
    }


}
