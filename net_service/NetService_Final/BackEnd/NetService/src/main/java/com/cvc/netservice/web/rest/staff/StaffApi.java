package com.cvc.netservice.web.rest.staff;

import com.cvc.netservice.service.dto.StaffDTO;
import com.cvc.netservice.web.model.UpdateData;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/staff")
public interface StaffApi {

    @ApiOperation(value = "Get All Staff", notes = "", response = StaffDTO.class, tags = {"STAFF",})
    @GetMapping("/getAll")
    ResponseEntity<List<StaffDTO>> getAllStaff();

    @ApiOperation(value = "CHANGE PASSWORD", notes = "", response = StaffDTO.class, tags = {"STAFF",})
    @PutMapping("update/{id}")
    ResponseEntity<StaffDTO> updateProfile(@PathVariable(value = "id", required = true) Long id, @RequestBody UpdateData data);

    @ApiOperation(value = "Create employee return ID", notes = "", response = Long.class, tags = {"EMPLOYEE",})
    @PostMapping("/create")
    ResponseEntity<Long> createEmployee(@RequestBody StaffDTO staffDTO);
}
