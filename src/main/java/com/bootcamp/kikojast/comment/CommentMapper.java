package com.bootcamp.kikojast.comment;

import com.bootcamp.kikojast.place.PlaceMapper;
import com.bootcamp.kikojast.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PlaceMapper.class})
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);
    CommentDTO toCommentDTO(Comment comment);
    List<Comment> toCommentList(List<CommentDTO> commentDTOS);
    List<CommentDTO> toCommentDTOs(List<Comment> comments);

}
