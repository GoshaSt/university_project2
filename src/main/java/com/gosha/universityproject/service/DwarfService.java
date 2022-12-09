package com.gosha.universityproject.service;

import com.gosha.universityproject.model.DwarfRequest;

public interface DwarfService {

    void addDwarf(DwarfRequest dwarfRequest);

    Integer countMikeChildren();

    Integer countMikeChildrenWithGift();

    Integer countMikeChildrenWithoutGift();

    Integer countAlexChildren();

    Integer countAlexChildrenWithGift();

    Integer countAlexChildrenWithoutGift();

    Integer countTimChildren();

    Integer countTimChildrenWithGift();

    Integer countTimChildrenWithoutGift();
}
