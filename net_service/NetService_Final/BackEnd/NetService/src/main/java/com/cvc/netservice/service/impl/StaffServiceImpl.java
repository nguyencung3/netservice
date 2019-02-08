package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.Staff;
import com.cvc.netservice.repository.StaffRepository;
import com.cvc.netservice.service.StaffService;
import com.cvc.netservice.service.dto.StaffDTO;
import com.cvc.netservice.service.mapper.StaffMapper;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    private final StaffMapper staffMapper;

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffMapper staffMapper, StaffRepository staffRepository) {
        this.staffMapper = staffMapper;
        this.staffRepository = staffRepository;
    }

    @Override
    public List<StaffDTO> getListEmployee() {
        return staffRepository.findAll().stream()
                .map(staffMapper::toStaffDTO)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public StaffDTO update(Long id, String key, Object value) {
        Staff staff = Optional.ofNullable(staffRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);

        if (key.equals("birthDate")) {
            LocalDate localDate = LocalDate.parse((String) value);
            value = localDate;
        }
        //Update
        PropertyAccessor propertyAccessor = PropertyAccessorFactory.forBeanPropertyAccess(staff);
        propertyAccessor.setPropertyValue(key, value);

        //Save
        staffRepository.save(staff);
        return staffMapper.toStaffDTO(staff);
    }
}
