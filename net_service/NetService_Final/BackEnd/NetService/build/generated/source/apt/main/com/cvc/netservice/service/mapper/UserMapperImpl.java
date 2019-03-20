package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.User;
import com.cvc.netservice.service.dto.UserDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-20T21:27:45+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setUsername( entity.getUsername() );
        if ( entity.getPassword() != null ) {
            userDTO.setPassword( Long.parseLong( entity.getPassword() ) );
        }

        return userDTO;
    }
}
