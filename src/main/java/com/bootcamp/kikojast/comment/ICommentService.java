package com.bootcamp.kikojast.comment;


import com.bootcamp.kikojast.commen.SearchCriteria;

import java.util.List;

public interface ICommentService {
    Comment save(Comment comment);
    Comment update(Comment comment);
    void delete(Long id);
    Comment getById(Long id);
    List<Comment> getAll();

    List<Comment> getAllByUserId(Long userId);

    List<Comment> getAllByPlaceId(Long placeId);

    List<Comment> search(List<SearchCriteria> searchCriteria);


}
