package com.cvc.netservice.web.rest.loging.impl;

import com.cvc.netservice.service.LogingService;
import com.cvc.netservice.service.dto.StaffDTO;
import com.cvc.netservice.web.rest.loging.LogingApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class LogingController implements LogingApi {

    @Autowired
    private LogingService logingService;

    @Override
    public ResponseEntity<StaffDTO> loging(String username, String password) {
        return ResponseEntity.ok(logingService.checkLogin(username, password));
    }

    @Override
    public ResponseEntity<StaffDTO> changePassWord(Long id, String password) {
        StaffDTO staffDTO = logingService.changePassword(id, password);
        return ResponseEntity.ok(staffDTO);
    }
}
