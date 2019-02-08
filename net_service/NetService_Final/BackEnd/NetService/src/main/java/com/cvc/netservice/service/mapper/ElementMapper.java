package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Element;
import com.cvc.netservice.service.dto.ElementDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ElementMapper {

    ElementDTO toElementDTO (Element entity);
}
