package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.User;
import com.cvc.netservice.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {

    UserDTO toUserDTO(User entity);
}
