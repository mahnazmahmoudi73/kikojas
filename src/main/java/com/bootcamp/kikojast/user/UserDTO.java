package com.bootcamp.kikojast.user;

import com.bootcamp.kikojast.commen.BaseDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private String emailOrPhone;

    @ApiModelProperty(required = true,hidden = false)
    private String password;

    @ApiModelProperty(required = false,hidden = false)
    private String profile;

}