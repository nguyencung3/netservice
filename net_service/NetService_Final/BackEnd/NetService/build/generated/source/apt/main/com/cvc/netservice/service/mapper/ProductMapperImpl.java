package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Product;
import com.cvc.netservice.service.dto.ProductDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-03-20T21:27:45+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toProductDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( entity.getId() );
        productDTO.setStoreId( entity.getStoreId() );
        productDTO.setGroupProductId( entity.getGroupProductId() );
        productDTO.setProductName( entity.getProductName() );
        productDTO.setSalePrice( entity.getSalePrice() );
        productDTO.setCostPrice( entity.getCostPrice() );
        productDTO.setStatus( entity.getStatus() );
        productDTO.setDescription( entity.getDescription() );
        productDTO.setQuantityInStock( entity.getQuantityInStock() );
        productDTO.setTypeOrder( entity.getTypeOrder() );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setStoreId( dto.getStoreId() );
        product.setGroupProductId( dto.getGroupProductId() );
        product.setProductName( dto.getProductName() );
        product.setSalePrice( dto.getSalePrice() );
        product.setCostPrice( dto.getCostPrice() );
        product.setStatus( dto.getStatus() );
        product.setDescription( dto.getDescription() );
        product.setQuantityInStock( dto.getQuantityInStock() );
        product.setTypeOrder( dto.getTypeOrder() );

        return product;
    }
}
