package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.StoreDTO;

public interface StoreService {

    StoreDTO findOne(Long id);

}
