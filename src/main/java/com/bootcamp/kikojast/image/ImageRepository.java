package com.bootcamp.kikojast.image;

import com.bootcamp.kikojast.place.Place;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image,Long> {

List<Image> findAllByPlace(Place place);
}
