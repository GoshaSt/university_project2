package com.gosha.universityproject.service.impl;

import com.gosha.universityproject.entity.Dwarf;
import com.gosha.universityproject.entity.DwarfChildren;
import com.gosha.universityproject.repository.DwarfChildrenRepository;
import com.gosha.universityproject.repository.DwarfRepository;
import com.gosha.universityproject.service.DwarfChildrenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DwarfChildrenServiceImpl implements DwarfChildrenService {

    private final DwarfChildrenRepository dwarfChildrenRepository;

    private final DwarfRepository dwarfRepository;

    @Override
    public Long getFreeDwarfId() {
        DwarfChildren dwarfChildren;
        Dwarf dwarf;
        dwarfChildren = dwarfChildrenRepository.getTopByOrderByIdDesc();
        if (dwarfChildren != null) {
            dwarf = dwarfRepository.getTopByOrderByIdDesc();
            if (dwarfChildren.getDwarf().getId() < dwarf.getId()) {
                return dwarfChildren.getDwarf().getId() + 1;
            } else if (Objects.equals(dwarf.getId(), dwarfChildren.getDwarf().getId())) {
                return 1L;
            }
        }
        return 1L;
    }
}
