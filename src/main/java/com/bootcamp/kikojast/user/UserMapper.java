package com.bootcamp.kikojast.user;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOS(List<User> users);
    List<User> toUsers(List<UserDTO> userDTOS);

}