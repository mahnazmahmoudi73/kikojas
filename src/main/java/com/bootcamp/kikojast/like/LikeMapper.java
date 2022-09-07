package com.bootcamp.kikojast.like;

import com.bootcamp.kikojast.place.PlaceMapper;
import com.bootcamp.kikojast.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PlaceMapper.class})
public interface LikeMapper {

    Like toLike(LikeDTO likeDTO);
    LikeDTO toLikeDTO(Like like);
    List<Like> toLikeList(List<LikeDTO> likeDTOS);
    List<LikeDTO> toLikeDTOs(List<Like> likes);

}
