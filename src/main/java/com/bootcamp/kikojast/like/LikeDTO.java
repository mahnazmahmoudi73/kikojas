package com.bootcamp.kikojast.like;

import com.bootcamp.kikojast.commen.BaseDTO;
import com.bootcamp.kikojast.place.PlaceDTO;
import com.bootcamp.kikojast.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LikeDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Boolean isLike;

    @ApiModelProperty(required = true,hidden = false)
    private UserDTO user;

    @ApiModelProperty(required = true,hidden = false)
    private PlaceDTO place;

}