package com.bootcamp.kikojast.image;

import java.util.List;

public interface IImageService {
    Image save(Image image);
    Image update(Image image);
    void delete(Long id);
    Image getById(Long id);
    List<Image> getAll();

    List<Image> getAllByPlaceId(Long placeId);



}
