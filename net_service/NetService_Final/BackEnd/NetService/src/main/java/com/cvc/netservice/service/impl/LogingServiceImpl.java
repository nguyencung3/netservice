package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.Staff;
import com.cvc.netservice.repository.StaffRepository;
import com.cvc.netservice.service.LogingService;
import com.cvc.netservice.service.dto.StaffDTO;
import com.cvc.netservice.service.mapper.StaffMapper;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.annotations.Cacheable;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Service
@Transactional
public class LogingServiceImpl implements LogingService {

    private final StaffRepository staffRepository;

    private final StaffMapper staffMapper;

    public LogingServiceImpl(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    @Override
    @Cacheable("findOne")
    @Transactional(readOnly = true)
    public StaffDTO checkLogin(String username, String password) {
        return staffMapper.toStaffDTO(staffRepository.findByEmailAndPassword(username, password));
    }

    @Override
    public StaffDTO changePassword(Long id, String password) {
        Staff staff = Optional.ofNullable(staffRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);

        //Update
        PropertyAccessor propertyAccessor = PropertyAccessorFactory.forBeanPropertyAccess(staff);
        propertyAccessor.setPropertyValue("password", password);

        //Save
        staffRepository.save(staff);
        return staffMapper.toStaffDTO(staff);
    }
}
