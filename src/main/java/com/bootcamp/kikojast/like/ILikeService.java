package com.bootcamp.kikojast.like;


import com.bootcamp.kikojast.commen.SearchCriteria;
import com.bootcamp.kikojast.comment.Comment;

import java.util.List;

public interface ILikeService {
    Like save(Like like);
    Like update(Like like);
    void delete(Long id);
    Like getById(Long id);
    List<Like> getAll();

    List<Like> getAllByUserId(Long userId);

    List<Like> getAllByPlaceId(Long placeId);

    List<Like> search(List<SearchCriteria> searchCriteria);


}
