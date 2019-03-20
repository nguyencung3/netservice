package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.Goods;
import com.cvc.netservice.repository.InventoryRepository;
import com.cvc.netservice.service.InventoryService;
import com.cvc.netservice.service.dto.GoodsDTO;
import com.cvc.netservice.service.mapper.GoodsMapper;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final GoodsMapper goodsMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, GoodsMapper goodsMapper) {
        this.inventoryRepository = inventoryRepository;
        this.goodsMapper = goodsMapper;
    }

    @Override
    public List<GoodsDTO> findAllGoods() {
        return inventoryRepository.findAllGoods()
                .stream().map(goodsMapper::toGoodsDTO).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public Long createGoods(GoodsDTO goodsDTO) {
        Goods goods = goodsMapper.toEntity(goodsDTO);
        goods.setRemove(false);
        inventoryRepository.save(goods);
        return inventoryRepository.findFirstByOrderByIdDesc().getId();
    }

    @Override
    public GoodsDTO updateGooods(String field, Object value, Long id) throws Exception {
        Goods goods = Optional.ofNullable(inventoryRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);

        //Update
        PropertyAccessor propertyAccessor = PropertyAccessorFactory.forBeanPropertyAccess(goods);
        propertyAccessor.setPropertyValue(field, value);

        //Save
        inventoryRepository.save(goods);
        return goodsMapper.toGoodsDTO(goods);
    }

    @Override
    public GoodsDTO deleteGoods(Long id) {
        Goods goods = Optional.ofNullable(inventoryRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);

        goods.setRemove(true);
        inventoryRepository.save(goods);

        return goodsMapper.toGoodsDTO(goods);
    }
}
