package com.cvc.netservice.web.rest.inventory;

import com.cvc.netservice.service.dto.TypeProductDTO;
import com.cvc.netservice.web.model.UpdateData;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("null")
@RequestMapping("/type-product")
public interface TypeProductApi {

    @ApiOperation(value = "Find all type goods", notes = "", response = TypeProductDTO.class, tags = {"INVENTORY",})
    @GetMapping("/findAll")
    ResponseEntity<List<TypeProductDTO>> findAll();

    @ApiOperation(value = "Get type goods", notes = "", response = TypeProductDTO.class, tags = {"INVENTORY",})
    @GetMapping("/get/{id}")
    ResponseEntity<TypeProductDTO> get(@PathVariable("id") Long id);

    @ApiOperation(value = "Create type goods", notes = "", response = Boolean.class, tags = {"INVENTORY",})
    @PostMapping("/create")
    ResponseEntity<Boolean> create(@RequestBody TypeProductDTO typeProductDTO);

    @ApiOperation(value = "Update type goods", notes = "", response = TypeProductDTO.class, tags = {"INVENTORY",})
    @PutMapping("/update/{id}")
    ResponseEntity<TypeProductDTO> update(@PathVariable("id") Long id, @RequestBody UpdateData data);

    @ApiOperation(value = "Delete type goods", notes = "", response = Boolean.class, tags = {"INVENTORY",})
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> delete(@PathVariable("id") Long id);

}
