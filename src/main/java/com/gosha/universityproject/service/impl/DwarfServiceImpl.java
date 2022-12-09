package com.gosha.universityproject.service.impl;

import com.gosha.universityproject.entity.Dwarf;
import com.gosha.universityproject.model.DwarfRequest;
import com.gosha.universityproject.repository.DwarfChildrenRepository;
import com.gosha.universityproject.repository.DwarfRepository;
import com.gosha.universityproject.service.DwarfService;
import com.gosha.universityproject.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DwarfServiceImpl implements DwarfService {

    private final DwarfChildrenRepository dwarfChildrenRepository;

    private final DwarfRepository dwarfRepository;

    @Override
    public void addDwarf(DwarfRequest dwarfRequest) {
        Dwarf saveDwarf = ModelMapperUtil.modelMapper().map(dwarfRequest, Dwarf.class);
        dwarfRepository.save(saveDwarf);
    }

    @Override
    public Integer countMikeChildren() {
        return dwarfChildrenRepository.countMikeChildren();
    }

    @Override
    public Integer countMikeChildrenWithGift() {
        return dwarfChildrenRepository.countMikeChildrenWithGift();
    }

    @Override
    public Integer countMikeChildrenWithoutGift() {
        return dwarfChildrenRepository.countMikeChildrenWithoutGift();
    }

    @Override
    public Integer countAlexChildren() {
        return dwarfChildrenRepository.countAlexChildren();
    }

    @Override
    public Integer countAlexChildrenWithGift() {
        return dwarfChildrenRepository.countAlexChildrenWithGift();
    }

    @Override
    public Integer countAlexChildrenWithoutGift() {
        return dwarfChildrenRepository.countAlexChildrenWithoutGift();
    }

    @Override
    public Integer countTimChildren() {
        return dwarfChildrenRepository.countTimChildren();
    }

    @Override
    public Integer countTimChildrenWithGift() {
        return dwarfChildrenRepository.countTimChildrenWithGift();
    }

    @Override
    public Integer countTimChildrenWithoutGift() {
        return dwarfChildrenRepository.countTimChildrenWithoutGift();
    }
}
