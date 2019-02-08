package com.cvc.netservice.service.impl;

import com.cvc.netservice.domain.TypeProduct;
import com.cvc.netservice.repository.TypeProductRepository;
import com.cvc.netservice.service.TypeProductService;
import com.cvc.netservice.service.dto.TypeProductDTO;
import com.cvc.netservice.service.mapper.TypeProductMapper;
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
public class TypeProductServiceImpl implements TypeProductService {
    private final TypeProductMapper typeProductMapper;

    private final TypeProductRepository typeProductRepository;

    public TypeProductServiceImpl(TypeProductMapper typeProductMapper, TypeProductRepository typeProductRepository) {
        this.typeProductMapper = typeProductMapper;
        this.typeProductRepository = typeProductRepository;
    }

    @Override
    public Boolean createTypeProduct(TypeProductDTO typeProductDTO) throws Exception {
        TypeProduct typeProduct = typeProductMapper.toEntity(typeProductDTO);
        typeProductRepository.save(typeProduct);
        return true;
    }

    @Override
    public TypeProductDTO updateTypeProduct(String field, Object value, Long id) {
        TypeProduct typeProduct = Optional.ofNullable(typeProductRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);

        //Update
        PropertyAccessor propertyAccessor = PropertyAccessorFactory.forBeanPropertyAccess(typeProduct);
        propertyAccessor.setPropertyValue(field, value);

        //Save
        typeProductRepository.save(typeProduct);
        return typeProductMapper.toProductDTO(typeProduct);
    }

    @Override
    public Boolean deleteTypeProduct(Long id) throws Exception {
        TypeProduct typeProduct = Optional.ofNullable(typeProductRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);
        typeProductRepository.delete(id);
        return true;
    }

    @Override
    public List<TypeProductDTO> findAllTypeProduct() {
        return typeProductRepository.findAll().stream()
                .map(typeProductMapper::toProductDTO)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public TypeProductDTO getTypeProduct(Long id) {
        TypeProduct typeProduct = Optional.ofNullable(typeProductRepository.findOne(id))
                .orElseThrow(EntityNotFoundException::new);
        return typeProductMapper.toProductDTO(typeProduct);
    }
}
