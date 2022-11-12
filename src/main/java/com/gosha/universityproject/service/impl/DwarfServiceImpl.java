package com.gosha.universityproject.service.impl;

import com.gosha.universityproject.entity.Dwarf;
import com.gosha.universityproject.model.DwarfRequest;
import com.gosha.universityproject.repository.DwarfRepository;
import com.gosha.universityproject.service.DwarfService;
import com.gosha.universityproject.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DwarfServiceImpl implements DwarfService {

    private final DwarfRepository dwarfRepository;

    @Override
    public void addDwarf(DwarfRequest dwarfRequest) {
        Dwarf saveDwarf = ModelMapperUtil.modelMapper().map(dwarfRequest, Dwarf.class);
        dwarfRepository.save(saveDwarf);
    }
}
