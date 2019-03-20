package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Staff;
import com.cvc.netservice.domain.Store;
import com.cvc.netservice.service.dto.StaffDTO;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-20T21:27:45+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class StaffMapperImpl implements StaffMapper {

    @Override
    public StaffDTO toStaffDTO(Staff entity) {
        if ( entity == null ) {
            return null;
        }

        StaffDTO staffDTO = new StaffDTO();

        staffDTO.setNameStore( entityStoreNameStore( entity ) );
        staffDTO.setPassword( entity.getPassword() );
        staffDTO.setEmail( entity.getEmail() );
        staffDTO.setFullName( entity.getFullName() );
        staffDTO.setId( entity.getId() );
        staffDTO.setStoreId( entity.getStoreId() );
        staffDTO.setFirstName( entity.getFirstName() );
        staffDTO.setLastName( entity.getLastName() );
        if ( entity.getBirthDate() != null ) {
            staffDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( entity.getBirthDate() ) );
        }
        staffDTO.setAddress( entity.getAddress() );
        staffDTO.setPhone( entity.getPhone() );
        staffDTO.setPhoto( entity.getPhoto() );
        staffDTO.setStatus( entity.getStatus() );
        staffDTO.setRole( entity.getRole() );
        staffDTO.setWorkingShift( entity.getWorkingShift() );

        return staffDTO;
    }

    @Override
    public Staff toEntity(StaffDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setPassword( dto.getPassword() );
        staff.setEmail( dto.getEmail() );
        staff.setFullName( dto.getFullName() );
        staff.setId( dto.getId() );
        staff.setStoreId( dto.getStoreId() );
        staff.setFirstName( dto.getFirstName() );
        staff.setLastName( dto.getLastName() );
        if ( dto.getBirthDate() != null ) {
            staff.setBirthDate( java.time.LocalDate.parse( dto.getBirthDate() ) );
        }
        staff.setAddress( dto.getAddress() );
        staff.setPhone( dto.getPhone() );
        staff.setPhoto( dto.getPhoto() );
        staff.setStatus( dto.getStatus() );
        staff.setRole( dto.getRole() );
        staff.setWorkingShift( dto.getWorkingShift() );

        return staff;
    }

    private String entityStoreNameStore(Staff staff) {

        if ( staff == null ) {
            return null;
        }
        Store store = staff.getStore();
        if ( store == null ) {
            return null;
        }
        String nameStore = store.getNameStore();
        if ( nameStore == null ) {
            return null;
        }
        return nameStore;
    }
}
