package com.bootcamp.kikojast.place;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import javax.persistence.Tuple;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceMapper {



    @Mappings({
            @Mapping(source = "locationDTO", target = "location", ignore = false, qualifiedByName = "locationDtoToLocation")})
    Place toPlace(PlaceDTO placeDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", ignore = false, qualifiedByName = "locationToLocationDTO")})
    PlaceDTO toPlaceDTO(Place place);

    List<PlaceDTO> toPlaceDTOS(List<Place> places);

    List<Place> toPlaces(List<PlaceDTO> placeDTOS);


    @Named("locationDtoToLocation")
    default Point<G2D> convertLocationDtoToLocation(LocationDTO locationDTO) {
        if (locationDTO!=null) {
            Point<G2D> candidPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
            return  candidPoint;
        }
        return null;
    }

 @Named("locationToLocationDTO")
    default  LocationDTO  convertlLocationToLocationDTO(Point<G2D> point) {
     if (point!=null) {
        G2D g2D=   point.getPosition();
       LocationDTO locationDTO=new LocationDTO();
       locationDTO.setLat(g2D.getLat());
       locationDTO.setLng(g2D.getLon());
       return  locationDTO;
     }
     return null;
    }



}