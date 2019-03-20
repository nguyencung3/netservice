package com.cvc.netservice.web.rest.staff.impl;

import com.cvc.netservice.service.StaffService;
import com.cvc.netservice.service.dto.StaffDTO;
import com.cvc.netservice.web.model.UpdateData;
import com.cvc.netservice.web.rest.staff.StaffApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StaffController implements StaffApi {

    @Autowired
    private StaffService staffService;

    @Override
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        List<StaffDTO> staffDTOS;
        staffDTOS = staffService.getListEmployee();
        return ResponseEntity.ok(staffDTOS);
    }

    @Override
    public ResponseEntity<StaffDTO> updateProfile(Long id, UpdateData data) {
        StaffDTO staffDTO = staffService.update(id, data.getKey(), data.getValue());
        return ResponseEntity.ok(staffDTO);
    }

    @Override
    public ResponseEntity<Long> createEmployee(StaffDTO staffDTO) {
        Long id;
        try {
            id = staffService.createEmployee(staffDTO);
        } catch (Exception e) {
            id = null;
        }
        return ResponseEntity.ok(id);
    }
}
