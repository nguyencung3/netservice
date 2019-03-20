package com.cvc.netservice.web.rest.inventory;

import com.cvc.netservice.service.dto.GoodsDTO;
import com.cvc.netservice.service.dto.ProductDTO;
import com.cvc.netservice.web.model.UpdateData;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8383")
@RequestMapping("/inventory")
public interface InventoryApi {

    @ApiOperation(value = "Check Inventory Goods", notes = "", response = ProductDTO.class, tags = {"INVENTORY",})
    @GetMapping("/findAllGoods")
    ResponseEntity<List<GoodsDTO>> findAllGoods();

    @ApiOperation(value = "Create Goods return ID", notes = "", response = Long.class, tags = {"INVENTORY",})
    @PostMapping("/create-goods")
    ResponseEntity<Long> create(@RequestBody GoodsDTO goodsDTO);

    @ApiOperation(value = "Update goods", notes = "", response = GoodsDTO.class, tags = {"INVENTORY",})
    @PutMapping("/update")
    ResponseEntity<GoodsDTO> update(@RequestBody UpdateData data);

    @ApiOperation(value = "Delete type goods", notes = "", response = GoodsDTO.class, tags = {"INVENTORY",})
    @PutMapping("/delete-goods")
    ResponseEntity<GoodsDTO> delete(@RequestParam Long id);

}
