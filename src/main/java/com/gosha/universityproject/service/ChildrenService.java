package com.gosha.universityproject.service;

import com.gosha.universityproject.model.ChildrenRequest;

public interface ChildrenService {

    void addChildren(ChildrenRequest childrenRequest) throws InterruptedException;

    void updateChildren(ChildrenRequest childrenRequest);

    int childrenWithGift();

    int childrenWithoutGift();
}
