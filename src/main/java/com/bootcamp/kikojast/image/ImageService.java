package com.bootcamp.kikojast.image;

import com.bootcamp.kikojast.commen.exception.NotFoundException;
import com.bootcamp.kikojast.place.IPlaceService;
import com.bootcamp.kikojast.place.Place;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService implements IImageService {
  private  final ImageRepository repository;
  private  final IPlaceService placeService;


    @Override
    public Image save(Image image) {
        Long placeId = image.getPlace().getId();

        Place place = placeService.getById(placeId);
        image.setPlace(place);

        return repository.save(image);
    }


    @Override
    public Image update(Image image) {
       Image lastImage = getById(image.getId());
       lastImage.setImage(image.getImage());
       Long placeId = image.getPlace().getId();
       Place place = placeService.getById(placeId);
       lastImage.setPlace(place);

        return repository.save(lastImage);
    }



    @Override
    public void delete(Long id) {

        Optional<Image> optionalImage = repository.findById(id);

        if (!optionalImage.isPresent()){
            throw new NotFoundException("Image Not Found");
        }
        repository.deleteById(id);
    }


    @Override
    public Image getById(Long id) {
        Optional<Image> optionalImage=repository.findById(id);

        if (!optionalImage.isPresent()){

            throw new NotFoundException("Image Not Found");
        }
        return optionalImage.get();
    }


    @Override
    public List<Image> getAll() {
        return (List<Image>) repository.findAll();
    }



    @Override
    public List<Image> getAllByPlaceId(Long placeId) {

        Place place = placeService.getById(placeId);
        List<Image> imageList = repository.findAllByPlace(place);
        return imageList;
    }
}