package com.bootcamp.kikojast.comment;

import com.bootcamp.kikojast.place.Place;
import com.bootcamp.kikojast.user.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {

    List<Comment> findAllByUser(User user);

    List<Comment> findAllByPlace(Place place);

    //search
    List<Comment> findAll(Specification<Comment> specification);
}
