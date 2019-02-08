package com.cvc.netservice.service;

import com.cvc.netservice.service.dto.TypeProductDTO;

import java.util.List;

public interface TypeProductService {

    Boolean createTypeProduct(TypeProductDTO typeProductDTO) throws Exception;

    TypeProductDTO updateTypeProduct(String field, Object value, Long id) throws Exception;

    Boolean deleteTypeProduct(Long id) throws Exception;

    List<TypeProductDTO> findAllTypeProduct();

    TypeProductDTO getTypeProduct(Long id);
}
