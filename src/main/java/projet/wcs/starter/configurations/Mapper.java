package projet.wcs.starter.configurations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import projet.wcs.starter.dao.Product;
import projet.wcs.starter.dto.ProductDto;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Product, ProductDto> propertyMapper = modelMapper.createTypeMap(Product.class, ProductDto.class);
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getOwner().getId(), ProductDto::setOwnerId)
        );
        return modelMapper;
    }
}
