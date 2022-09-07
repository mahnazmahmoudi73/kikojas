package com.bootcamp.kikojast.like;

import com.bootcamp.kikojast.commen.SearchCriteria;
import com.bootcamp.kikojast.commen.exception.NotFoundException;
import com.bootcamp.kikojast.place.IPlaceService;
import com.bootcamp.kikojast.place.Place;
import com.bootcamp.kikojast.user.IUserService;
import com.bootcamp.kikojast.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeService implements ILikeService {

  private  final LikeRepository repository;
  private  final IUserService userService;
  private  final IPlaceService placeService;



    @Override
    public Like save(Like like) {
        Long userId = like.getUser().getId();
        Long placeId = like.getPlace().getId();
        User user = userService.getById(userId);
        Place place = placeService.getById(placeId);
        like.setUser(user);
        like.setPlace(place);
        return repository.save(like);
    }

    @Override
    public Like update(Like like) {
        Like lastLike = getById(like.getId());
        lastLike.setIsLike(like.getIsLike());
        Long userId = like.getUser().getId();
        Long placeId = like.getPlace().getId();
        User user = userService.getById(userId);
        Place place = placeService.getById(placeId);
        lastLike.setUser(user);
        lastLike.setPlace(place);
        return repository.save(lastLike);
    }


    @Override
    public void delete(Long id) {
        Optional<Like> optionalLike = repository.findById(id);

        if (!optionalLike.isPresent()){
            throw new NotFoundException("Like Not Found");
        }

        repository.deleteById(id);
    }


    @Override
    public Like getById(Long id) {
        Optional<Like> optionalLike=repository.findById(id);

        if (!optionalLike.isPresent()){

            throw new NotFoundException("Like Not Found");
        }


        return optionalLike.get();
    }


    @Override
    public List<Like> getAll() {
        return (List<Like>) repository.findAll();
    }


    @Override
    public List<Like> getAllByUserId(Long userId) {
        User user = userService.getById(userId);
        List<Like> likeList = repository.findAllByUser(user);
        return likeList;
    }


    @Override
    public List<Like> getAllByPlaceId(Long placeId) {
        Place place = placeService.getById(placeId);
        List<Like> likeList = repository.findAllByPlace(place);
        return likeList;
    }



    @Override
    public List<Like> search(List<SearchCriteria> searchCriteria) {
        LikeSpecification likeSpecification = new LikeSpecification();
        searchCriteria.forEach(criteria -> likeSpecification.add(criteria));

        return repository.findAll(likeSpecification);
    }


}