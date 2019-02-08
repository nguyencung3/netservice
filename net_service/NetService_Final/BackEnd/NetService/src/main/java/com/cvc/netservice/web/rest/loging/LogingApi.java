package com.cvc.netservice.web.rest.loging;

import com.cvc.netservice.service.dto.StaffDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
public interface LogingApi {

    @ApiOperation(value = "AUTHO LOGING", notes = "", response = StaffDTO.class, tags = {"LOGING",})
    @GetMapping("")
    ResponseEntity<StaffDTO> loging(@RequestParam(value = "username", required = true) String username,
                                    @RequestParam(value = "password", required = false) String password);

    @ApiOperation(value = "CHANGE PASSWORD", notes = "", response = StaffDTO.class, tags = {"LOGING",})
    @PutMapping("/change-password")
    ResponseEntity<StaffDTO> changePassWord(@RequestParam(value = "id", required = true) Long id, @RequestParam(value = "id", required = true) String password);
}
