package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Goods;
import com.cvc.netservice.service.dto.GoodsDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-20T21:27:45+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class GoodsMapperImpl implements GoodsMapper {

    @Override
    public GoodsDTO toGoodsDTO(Goods entity) {
        if ( entity == null ) {
            return null;
        }

        GoodsDTO goodsDTO = new GoodsDTO();

        goodsDTO.setId( entity.getId() );
        goodsDTO.setGoodName( entity.getGoodName() );
        goodsDTO.setCostPrice( entity.getCostPrice() );
        goodsDTO.setNameUnit( entity.getNameUnit() );
        goodsDTO.setBasicUnitId( entity.getBasicUnitId() );
        goodsDTO.setExchangeValue( entity.getExchangeValue() );
        goodsDTO.setQuantityInStock( entity.getQuantityInStock() );
        goodsDTO.setStatus( entity.getStatus() );
        goodsDTO.setRemove( entity.getRemove() );
        goodsDTO.setDescription( entity.getDescription() );

        return goodsDTO;
    }

    @Override
    public Goods toEntity(GoodsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Goods goods = new Goods();

        goods.setId( dto.getId() );
        goods.setGoodName( dto.getGoodName() );
        goods.setCostPrice( dto.getCostPrice() );
        goods.setNameUnit( dto.getNameUnit() );
        goods.setBasicUnitId( dto.getBasicUnitId() );
        goods.setExchangeValue( dto.getExchangeValue() );
        goods.setQuantityInStock( dto.getQuantityInStock() );
        goods.setStatus( dto.getStatus() );
        goods.setRemove( dto.getRemove() );
        goods.setDescription( dto.getDescription() );

        return goods;
    }
}
