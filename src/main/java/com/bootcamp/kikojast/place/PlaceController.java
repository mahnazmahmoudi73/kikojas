package com.bootcamp.kikojast.place;

import com.bootcamp.kikojast.commen.SearchCriteria;
import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Tuple;
import java.util.List;

@RestController
@RequestMapping(value = "/place/")
@AllArgsConstructor
public class PlaceController {

    private final IPlaceService service;
    private PlaceMapper mapper;


    @PostMapping("/v1")
    @RolesAllowed("admin")
    public ResponseEntity save(@RequestBody PlaceDTO placeDTO){
    Place place =mapper.toPlace(placeDTO);
        service.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")

    public ResponseEntity update(@RequestBody PlaceDTO placeDTO){
        Place place =mapper.toPlace(placeDTO);
        service.update(place);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")

    public ResponseEntity<PlaceDTO> getById(@PathVariable Long id ){
    Place place = service.getById(id);
    PlaceDTO placeDTO =mapper.toPlaceDTO(place);
        return ResponseEntity.ok(placeDTO);
    }


    @GetMapping("/v1")

    public ResponseEntity<List<PlaceDTO>> getAll(){
    List<Place> places=    service.getAll();
    List<PlaceDTO> placeDTOS =    mapper.toPlaceDTOS(places);

        return ResponseEntity.ok(placeDTOS);
    }

    @DeleteMapping("/v1/{id}")

    @RolesAllowed("admin")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();


    }

    @GetMapping("/v1/{lat}/{lng}/{distance}")

    public ResponseEntity getAllPlaceByDistanceAndPoint(
            @PathVariable("lat") double lat,
            @PathVariable("lng") double lng,
            @PathVariable("distance") double distance){
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);
        List<Place> places = service.getAllPlaceByDistanceAndPoint(candidPoint, distance);
        List<PlaceDTO> placeDTOS =mapper.toPlaceDTOS(places);
        return ResponseEntity.ok(placeDTOS);
    }

    @GetMapping("/v1/{lat}/{lng}")

    public ResponseEntity getAllWithDistance(
            @PathVariable("lat") double lat,
            @PathVariable("lng") double lng){
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);
        List<Tuple> places = service.getAllWithDistance(candidPoint);

        //List<PlaceDTO> placeDTOS =mapper.toPlaceDTOS(places);
        return ResponseEntity.ok(places);
    }

    @GetMapping("/v1/within/{filter}")

    public ResponseEntity getWithin(
            @PathVariable("filter") Geometry filter){
        List<Place> places = service.getWithin(filter);
        List<PlaceDTO> placeDTOS =mapper.toPlaceDTOS(places);
        return ResponseEntity.ok(placeDTOS);
    }

    @GetMapping("/v1/paging/{lat}/{lng}/{page}/{size}")
    public ResponseEntity<List<Tuple>> getNearestPoint( @PathVariable("lat") double lat,
                                                        @PathVariable("lng") double lng,
                                                        @PathVariable("page") Integer page,
                                                        @PathVariable("size") Integer size ){
        Point<G2D> candidPoint= Geometries.mkPoint(new G2D(lng, lat), CoordinateReferenceSystems.WGS84);
        List<Tuple> tuples = service.getNearestPoint(candidPoint,page, size);

        return ResponseEntity.ok(tuples);
    }


    @PostMapping("/v1/search")
    public ResponseEntity<List<PlaceDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
    /*    for (SearchCriteria searchCriteria1:searchCriteria){
            if (searchCriteria1.getKey().equals("location")){
                var t = searchCriteria1.getValue();
                t.

                t.equals( {46.971746, 35.307712});
                Point<G2D> candidPoint= Geometries.mkPoint(new G2D(t., lat), CoordinateReferenceSystems.WGS84);
            }
        }*/
        List<Place> places= service.search(searchCriteria);
        List<PlaceDTO> placeDTOS = mapper.toPlaceDTOS(places);
        return ResponseEntity.ok(placeDTOS);
    }



}