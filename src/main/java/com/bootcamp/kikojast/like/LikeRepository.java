package com.bootcamp.kikojast.like;
import com.bootcamp.kikojast.place.Place;
import com.bootcamp.kikojast.user.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends PagingAndSortingRepository<Like,Long>, JpaSpecificationExecutor<Like> {

    List<Like> findAllByUser(User user);
    List<Like> findAllByPlace(Place place);

    List<Like> findAll(Specification<Like> specification);
}
