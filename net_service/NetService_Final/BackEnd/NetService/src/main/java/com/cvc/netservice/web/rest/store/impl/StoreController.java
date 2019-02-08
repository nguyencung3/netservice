package com.cvc.netservice.web.rest.store.impl;

import com.cvc.netservice.service.StoreService;
import com.cvc.netservice.service.dto.StoreDTO;
import com.cvc.netservice.web.rest.store.StoreApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class StoreController implements StoreApi {

    @Autowired
    private StoreService storeService;


    @Override
    public ResponseEntity<StoreDTO> updateProfile(Long id) {
        StoreDTO storeDTO = storeService.findOne(id);
        return ResponseEntity.ok(storeDTO);
    }
}
