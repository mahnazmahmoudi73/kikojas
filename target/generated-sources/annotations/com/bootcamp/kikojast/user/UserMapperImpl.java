package com.bootcamp.kikojast.user;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-07T14:01:48+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setVersion( userDTO.getVersion() );
        user.setCreatedDate( userDTO.getCreatedDate() );
        user.setCreatedBy( userDTO.getCreatedBy() );
        user.setLastModifiedDate( userDTO.getLastModifiedDate() );
        user.setLastModifiedBy( userDTO.getLastModifiedBy() );
        user.setName( userDTO.getName() );
        user.setEmailOrPhone( userDTO.getEmailOrPhone() );
        user.setPassword( userDTO.getPassword() );
        user.setProfile( userDTO.getProfile() );

        return user;
    }

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setVersion( user.getVersion() );
        userDTO.setCreatedDate( user.getCreatedDate() );
        userDTO.setCreatedBy( user.getCreatedBy() );
        userDTO.setLastModifiedDate( user.getLastModifiedDate() );
        userDTO.setLastModifiedBy( user.getLastModifiedBy() );
        userDTO.setName( user.getName() );
        userDTO.setEmailOrPhone( user.getEmailOrPhone() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setProfile( user.getProfile() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toUserDTOS(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }

    @Override
    public List<User> toUsers(List<UserDTO> userDTOS) {
        if ( userDTOS == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOS.size() );
        for ( UserDTO userDTO : userDTOS ) {
            list.add( toUser( userDTO ) );
        }

        return list;
    }
}
