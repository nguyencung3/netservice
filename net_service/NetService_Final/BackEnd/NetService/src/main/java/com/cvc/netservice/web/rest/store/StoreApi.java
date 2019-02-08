package com.cvc.netservice.web.rest.store;

import com.cvc.netservice.service.dto.StaffDTO;
import com.cvc.netservice.service.dto.StoreDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/store")
public interface StoreApi {

    @ApiOperation(value = "GET STORE INFO", notes = "", response = StaffDTO.class, tags = {"STORE",})
    @GetMapping("/get-info")
    ResponseEntity<StoreDTO> updateProfile(@RequestParam Long id);
}
