package com.bootcamp.kikojast.image;

import com.bootcamp.kikojast.place.PlaceMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PlaceMapper.class})
public interface ImageMapper {

    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toImageList(List<ImageDTO> imageDTOS);
    List<ImageDTO> toImageDTOs(List<Image> images);

}
