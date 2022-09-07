package com.bootcamp.kikojast.comment;

import com.bootcamp.kikojast.commen.BaseDTO;
import com.bootcamp.kikojast.place.PlaceDTO;
import com.bootcamp.kikojast.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String comment;

    @ApiModelProperty(required = true,hidden = false)
    private UserDTO user;

    @ApiModelProperty(required = true,hidden = false)
    private PlaceDTO place;

}