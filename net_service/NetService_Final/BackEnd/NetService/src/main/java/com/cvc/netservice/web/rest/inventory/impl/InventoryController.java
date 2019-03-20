package com.cvc.netservice.web.rest.inventory.impl;

import com.cvc.netservice.service.InventoryService;
import com.cvc.netservice.service.dto.GoodsDTO;
import com.cvc.netservice.web.model.UpdateData;
import com.cvc.netservice.web.rest.inventory.InventoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class InventoryController implements InventoryApi {

    @Autowired
    private InventoryService inventoryService;


    @Override
    public ResponseEntity<List<GoodsDTO>> findAllGoods() {
        List<GoodsDTO> goodsDTOS = inventoryService.findAllGoods();
        return ResponseEntity.ok(goodsDTOS);
    }

    @Override
    public ResponseEntity<Long> create(@RequestBody GoodsDTO goodsDTO) {
        Long id;
        try {
            id = inventoryService.createGoods(goodsDTO);
        } catch (Exception e) {
            id = 0L;
        }
        return ResponseEntity.ok(id);
    }

    @Override
    public ResponseEntity<GoodsDTO> update(@RequestBody UpdateData data) {
        GoodsDTO goodsDTO;
        try {
            goodsDTO = inventoryService.updateGooods(data.getKey(), data.getValue(), data.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(goodsDTO);
    }

    @Override
    public ResponseEntity<GoodsDTO> delete(Long id) {
        GoodsDTO goodsDTO;
        try {
            goodsDTO = inventoryService.deleteGoods(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(goodsDTO);
    }
}
