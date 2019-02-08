package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.StaffDTO;

import java.util.List;

public interface StaffService {

    List<StaffDTO> getListEmployee();

    StaffDTO update(Long id, String key, Object value);
}
