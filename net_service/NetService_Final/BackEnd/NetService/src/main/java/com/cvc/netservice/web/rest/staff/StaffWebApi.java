package com.cvc.netservice.web.rest.staff;

import com.cvc.netservice.service.dto.StaffDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/staff/web")
public interface StaffWebApi {

    @ApiOperation(value = "Get All Staff", notes = "", response = StaffDTO.class, tags = {"STAFF-WEB",})
    @GetMapping("/getAll")
    ResponseEntity<List<StaffDTO>> getAllStaff();
}
