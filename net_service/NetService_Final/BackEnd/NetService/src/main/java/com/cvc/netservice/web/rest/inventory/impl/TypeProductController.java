package com.cvc.netservice.web.rest.inventory.impl;

import com.cvc.netservice.service.TypeProductService;
import com.cvc.netservice.service.dto.TypeProductDTO;
import com.cvc.netservice.web.model.UpdateData;
import com.cvc.netservice.web.rest.inventory.TypeProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
public class TypeProductController implements TypeProductApi {

    @Autowired
    private TypeProductService typeProductService;

    @Override
    public ResponseEntity<List<TypeProductDTO>> findAll() {
        return ResponseEntity.ok(typeProductService.findAllTypeProduct());
    }

//    @CrossOrigin(origins = "http://localhost:8080")
    @Override
    public ResponseEntity<TypeProductDTO> get(@PathVariable("id") Long id) {
        TypeProductDTO typeProductDTO;

        try {
            typeProductDTO = typeProductService.getTypeProduct(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(typeProductDTO);
    }

    @Override
    public ResponseEntity<Boolean> create(@RequestBody TypeProductDTO typeProductDTO) {
        Boolean result = true;
        try {
            typeProductService.createTypeProduct(typeProductDTO);
        } catch (Exception e) {
            result = false;
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<TypeProductDTO> update(@PathVariable("id") Long id,@RequestBody UpdateData data) {
        TypeProductDTO typeProductDTO;
        try {
            typeProductDTO = typeProductService.updateTypeProduct(data.getKey(), data.getValue(), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(typeProductDTO);
    }

    @Override
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        Boolean result = true;
        try {
            typeProductService.deleteTypeProduct(id);
        } catch (Exception e) {
            result = false;
        }
        return ResponseEntity.ok(result);
    }
}
