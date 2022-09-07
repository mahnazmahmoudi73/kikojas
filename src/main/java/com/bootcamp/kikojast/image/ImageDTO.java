package com.bootcamp.kikojast.image;

import com.bootcamp.kikojast.commen.BaseDTO;
import com.bootcamp.kikojast.place.PlaceDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ImageDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String image;


    @ApiModelProperty(required = true,hidden = false)
    private PlaceDTO place;

}