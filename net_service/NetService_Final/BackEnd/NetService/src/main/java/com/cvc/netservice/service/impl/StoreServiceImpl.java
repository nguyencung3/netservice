package com.cvc.netservice.service.impl;

import com.cvc.netservice.repository.StoreRepository;
import com.cvc.netservice.service.StoreService;
import com.cvc.netservice.service.dto.StoreDTO;
import com.cvc.netservice.service.mapper.StoreMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    private final StoreMapper storeMapper;


    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    @Override
    public StoreDTO findOne(Long id) {
        return storeMapper.toStoreDTO(storeRepository.findOne(id));
    }
}
