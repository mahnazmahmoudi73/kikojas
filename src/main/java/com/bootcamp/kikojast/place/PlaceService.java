package com.bootcamp.kikojast.place;

import com.bootcamp.kikojast.commen.SearchCriteria;
import com.bootcamp.kikojast.commen.exception.ConflictException;
import com.bootcamp.kikojast.commen.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaceService implements IPlaceService {

  private  final PlaceRepository repository;


    @Override
    public Place save(Place place) {
       var placeList= repository.findAll();
       for(Place place1:placeList){
           if(place1.getTitle().equals(place.getTitle())){

               throw new ConflictException("This place has already been registered!");
           }
       }
        return repository.save(place);
    }


    @Override
    public Place update(Place place) {

        var places = repository.findAll();
      Place lastPlace=  getById(place.getId());

        for (Place place1:places){

            if (place1.getTitle().equals(place.getTitle())){

                if(place1.getId() == place.getId()){
                    continue;
                }
                //else {
                throw new ConflictException("This place has already been registered!");
                //}
            }

        }

      lastPlace.setType(place.getType());
      lastPlace.setEndService(place.getEndService());
      lastPlace.setAddress(place.getAddress());
      lastPlace.setPhone(place.getPhone());
      lastPlace.setLocation(place.getLocation());
        if(!(lastPlace.getTitle().equals(place.getTitle()))){
            lastPlace.setTitle(place.getTitle());
        }
        return repository.save(lastPlace);
    }

    @Override
    public void delete(Long id) {
        Optional<Place> optionalPlace=repository.findById(id);

        if (!optionalPlace.isPresent()){

            throw new NotFoundException("Place Not Found");
        }
        repository.deleteById(id);
    }


    @Override
    public Place getById(Long id) {
        Optional<Place> optionalPlace=repository.findById(id);

        if (!optionalPlace.isPresent()){

            throw new NotFoundException("Place Not Found");
        }


        return optionalPlace.get();
    }


    @Override
    public List<Place> getAll() {
        return (List<Place>) repository.findAll();
    }

    @Override
    public List<Place> getAllPlaceByDistanceAndPoint(Point<G2D> refPnt, double dist) {
        return repository.findAllPlaceByDistanceAndPoint(refPnt,dist);
    }

    @Override
    public List<Tuple> getAllWithDistance(Point<G2D> refPnt) {
        return  repository.findAllWithDistance(refPnt);
    }

    @Override
    public List<Place> getWithin(Geometry filter) {
        return repository.findWithin(filter);
    }

    @Override
    public List<Tuple> getNearestPoint(Point<G2D> refPnt, Integer page, Integer size) {
        return repository.findNearestPoint(refPnt, PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public List<Place> search(List<SearchCriteria> searchCriteria) {

        PlaceSpecification placeSpecification = new PlaceSpecification();
        searchCriteria.forEach(criteria -> placeSpecification.add(criteria));

        return repository.findAll(placeSpecification);
    }


}