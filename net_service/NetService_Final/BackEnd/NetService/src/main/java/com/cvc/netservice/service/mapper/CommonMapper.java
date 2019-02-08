package com.cvc.netservice.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface CommonMapper {

    default String toString(LocalDateTime localDateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return localDateTime != null ? localDateTime.format(formatter) : null;
    }
}
