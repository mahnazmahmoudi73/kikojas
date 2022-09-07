package com.bootcamp.kikojast.comment;

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
public class CommentService implements ICommentService {

  private  final CommentRepository repository;
  private  final IUserService userService;
  private  final IPlaceService placeService;


    @Override
    public Comment save(Comment comment) {

        Long userId = comment.getUser().getId();
        Long placeId = comment.getPlace().getId();
        User user = userService.getById(userId);
        Place place = placeService.getById(placeId);
        comment.setUser(user);
        comment.setPlace(place);

        return repository.save(comment);
    }



    @Override
    public Comment update(Comment comment) {

        Comment lastComment = getById(comment.getId());
        lastComment.setComment(comment.getComment());
        Long userId = comment.getUser().getId();
        Long placeId = comment.getPlace().getId();
        User user = userService.getById(userId);
        Place place = placeService.getById(placeId);
        lastComment.setUser(user);
        lastComment.setPlace(place);
        return repository.save(lastComment);
    }



    @Override
    public void delete(Long id) {
        Optional<Comment> optionalComment = repository.findById(id);

        if (!optionalComment.isPresent()){
            throw new NotFoundException("Comment Not Found");
        }

        repository.deleteById(id);
    }


    @Override
    public Comment getById(Long id) {
        Optional<Comment> optionalComment=repository.findById(id);

        if (!optionalComment.isPresent()){

            throw new NotFoundException("Comment Not Found");
        }


        return optionalComment.get();
    }



    @Override
    public List<Comment> getAll() {
        return (List<Comment>) repository.findAll();
    }


    @Override
    public List<Comment> getAllByUserId(Long userId) {
        User user = userService.getById(userId);
        List<Comment> commentList = repository.findAllByUser(user);
        return commentList;
    }


    @Override
    public List<Comment> getAllByPlaceId(Long placeId) {
        Place place = placeService.getById(placeId);
        List<Comment> commentList = repository.findAllByPlace(place);
        return commentList;
    }


    @Override
    public List<Comment> search(List<SearchCriteria> searchCriteria) {
        CommentSpecification commentSpecification = new CommentSpecification();
        searchCriteria.forEach(criteria -> commentSpecification.add(criteria));

        return repository.findAll(commentSpecification);
    }


}