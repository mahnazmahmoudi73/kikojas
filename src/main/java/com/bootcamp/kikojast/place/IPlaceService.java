package com.bootcamp.kikojast.place;

import com.bootcamp.kikojast.commen.SearchCriteria;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface IPlaceService {
    Place save(Place place);
    Place update(Place place);
    void delete(Long id);
    Place getById(Long id);
    List<Place> getAll();


    List<Place> getAllPlaceByDistanceAndPoint(Point<G2D> refPnt, double dist);

    List<Tuple> getAllWithDistance(Point<G2D> refPnt);

    List<Place> getWithin(@Param("filter") Geometry filter);

    List<Tuple> getNearestPoint(Point<G2D> refPnt, Integer page, Integer size);

    List<Place> search(List<SearchCriteria> searchCriteria);


}