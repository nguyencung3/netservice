package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Store;
import com.cvc.netservice.service.dto.StoreDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-23T15:37:07+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class StoreMapperImpl implements StoreMapper {

    @Override
    public StoreDTO toStoreDTO(Store entity) {
        if ( entity == null ) {
            return null;
        }

        StoreDTO storeDTO = new StoreDTO();

        storeDTO.setId( entity.getId() );
        storeDTO.setNameStore( entity.getNameStore() );
        storeDTO.setAddress( entity.getAddress() );
        storeDTO.setPhone( entity.getPhone() );

        return storeDTO;
    }

    @Override
    public Store toEntity(StoreDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Store store = new Store();

        store.setId( dto.getId() );
        store.setNameStore( dto.getNameStore() );
        store.setAddress( dto.getAddress() );
        store.setPhone( dto.getPhone() );

        return store;
    }
}
