package com.bootcamp.kikojast.comment;

import com.bootcamp.kikojast.commen.SearchCriteria;
import com.bootcamp.kikojast.place.Place;
import com.bootcamp.kikojast.place.PlaceDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment/")
@AllArgsConstructor
public class CommentController {

    private final ICommentService service;
    private CommentMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CommentDTO commentDTO){
       Comment comment =mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CommentDTO commentDTO){
        Comment comment =mapper.toComment(commentDTO);
        service.update(comment);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<CommentDTO> getById(@PathVariable Long id ){

        Comment comment = service.getById(id);
    CommentDTO commentDTO=mapper.toCommentDTO(comment);
        return ResponseEntity.ok(commentDTO);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<CommentDTO>> getAll(){

    List<Comment> comments=    service.getAll();
    List<CommentDTO> commentDTOS=    mapper.toCommentDTOs(comments);
        return ResponseEntity.ok(commentDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-all-by-user-id/{userId}")
    public ResponseEntity<List<CommentDTO>> getAllByUserId(@PathVariable Long userId){

        List<Comment> comments= service.getAllByUserId(userId);
        List<CommentDTO> commentDTOS= mapper.toCommentDTOs(comments);
        return ResponseEntity.ok(commentDTOS);
    }

    @GetMapping("/v1/get-all-by-place-id/{placeId}")
    public ResponseEntity<List<CommentDTO>> getAllByPlaceId(@PathVariable Long placeId){

        List<Comment> comments= service.getAllByPlaceId(placeId);
        List<CommentDTO> commentDTOS= mapper.toCommentDTOs(comments);
        return ResponseEntity.ok(commentDTOS);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<CommentDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
    /*    for (SearchCriteria searchCriteria1:searchCriteria){
            if (searchCriteria1.getKey().equals("location")){
                var t = searchCriteria1.getValue();
                t.

                t.equals( {46.971746, 35.307712});
                Point<G2D> candidPoint= Geometries.mkPoint(new G2D(t., lat), CoordinateReferenceSystems.WGS84);
            }
        }*/
        List<Comment> comments= service.search(searchCriteria);
        List<CommentDTO> commentDTOS = mapper.toCommentDTOs(comments);
        return ResponseEntity.ok(commentDTOS);
    }

}