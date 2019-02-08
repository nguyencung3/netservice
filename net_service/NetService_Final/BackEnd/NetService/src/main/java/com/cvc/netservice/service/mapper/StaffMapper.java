package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Staff;
import com.cvc.netservice.service.dto.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CommonMapper.class,StoreMapper.class})
public interface StaffMapper {

    @Mapping(target = "nameStore", source = "entity.store.nameStore")
    StaffDTO toStaffDTO(Staff entity);

    Staff toEntity(StaffDTO dto);
}
