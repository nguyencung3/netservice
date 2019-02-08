package com.cvc.netservice.web.rest.image.impl;

import com.cvc.netservice.service.StaffService;
import com.cvc.netservice.web.rest.image.ImageStaffApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ImageStaffController implements ImageStaffApi {

    @Autowired
    private StaffService staffService;

    @Override
    public ResponseEntity<InputStreamResource> getImageStaff(@RequestParam String name) throws IOException {
        ClassPathResource imgFile = new ClassPathResource("images/" + name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }
}
