package com.cvc.netservice.web.rest.staff.impl;

import com.cvc.netservice.service.StaffService;
import com.cvc.netservice.service.dto.StaffDTO;
import com.cvc.netservice.web.rest.staff.StaffWebApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StaffWebController implements StaffWebApi {

    @Autowired
    private StaffService staffService;

    @Override
    public ResponseEntity<List<StaffDTO>> getAllStaff() {
        List<StaffDTO> staffDTOS;
        staffDTOS = staffService.getListEmployee();
        return ResponseEntity.ok(staffDTOS);
    }
}
