package com.bootcamp.kikojast.image;

import com.bootcamp.kikojast.place.PlaceMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-07T14:01:48+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public Image toImage(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( imageDTO.getId() );
        image.setVersion( imageDTO.getVersion() );
        image.setCreatedDate( imageDTO.getCreatedDate() );
        image.setCreatedBy( imageDTO.getCreatedBy() );
        image.setLastModifiedDate( imageDTO.getLastModifiedDate() );
        image.setLastModifiedBy( imageDTO.getLastModifiedBy() );
        image.setImage( imageDTO.getImage() );
        image.setPlace( placeMapper.toPlace( imageDTO.getPlace() ) );

        return image;
    }

    @Override
    public ImageDTO toImageDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setId( image.getId() );
        imageDTO.setVersion( image.getVersion() );
        imageDTO.setCreatedDate( image.getCreatedDate() );
        imageDTO.setCreatedBy( image.getCreatedBy() );
        imageDTO.setLastModifiedDate( image.getLastModifiedDate() );
        imageDTO.setLastModifiedBy( image.getLastModifiedBy() );
        imageDTO.setImage( image.getImage() );
        imageDTO.setPlace( placeMapper.toPlaceDTO( image.getPlace() ) );

        return imageDTO;
    }

    @Override
    public List<Image> toImageList(List<ImageDTO> imageDTOS) {
        if ( imageDTOS == null ) {
            return null;
        }

        List<Image> list = new ArrayList<Image>( imageDTOS.size() );
        for ( ImageDTO imageDTO : imageDTOS ) {
            list.add( toImage( imageDTO ) );
        }

        return list;
    }

    @Override
    public List<ImageDTO> toImageDTOs(List<Image> images) {
        if ( images == null ) {
            return null;
        }

        List<ImageDTO> list = new ArrayList<ImageDTO>( images.size() );
        for ( Image image : images ) {
            list.add( toImageDTO( image ) );
        }

        return list;
    }
}
