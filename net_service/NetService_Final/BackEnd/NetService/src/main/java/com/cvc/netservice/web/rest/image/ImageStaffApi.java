package com.cvc.netservice.web.rest.image;

import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/image/")
public interface ImageStaffApi {

    @ApiOperation(value = "Get All Staff", notes = "", tags = {"IMAGE-STAFF",}, produces = MediaType.IMAGE_JPEG_VALUE)
    @GetMapping("/staff")
    ResponseEntity<InputStreamResource> getImageStaff(@RequestParam String name) throws IOException;
}
