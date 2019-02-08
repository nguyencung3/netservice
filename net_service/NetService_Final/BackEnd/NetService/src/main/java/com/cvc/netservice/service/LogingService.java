package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.StaffDTO;

public interface LogingService {

    StaffDTO checkLogin(String username, String password);

    StaffDTO changePassword(Long id, String password) ;

}
