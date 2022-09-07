package com.bootcamp.kikojast.like;

import com.bootcamp.kikojast.commen.SearchCriteria;
import com.bootcamp.kikojast.comment.Comment;
import com.bootcamp.kikojast.comment.CommentDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/like/")
@AllArgsConstructor
public class LikeController {

    private final ILikeService service;
    private LikeMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody LikeDTO likeDTO){
        Like like =mapper.toLike(likeDTO);
        service.save(like);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody LikeDTO likeDTO){
        Like like =mapper.toLike(likeDTO);
        service.update(like);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<LikeDTO> getById(@PathVariable Long id ){

        Like like = service.getById(id);
        LikeDTO likeDTO=mapper.toLikeDTO(like);
        return ResponseEntity.ok(likeDTO);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<LikeDTO>> getAll(){

    List<Like> likes=    service.getAll();
    List<LikeDTO> likeDTOS=    mapper.toLikeDTOs(likes);
        return ResponseEntity.ok(likeDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-all-by-user-id/{userId}")
    public ResponseEntity<List<LikeDTO>> getAllByUserId(@PathVariable Long userId){

        List<Like> likes= service.getAllByUserId(userId);
        List<LikeDTO> likeDTOS= mapper.toLikeDTOs(likes);
        return ResponseEntity.ok(likeDTOS);
    }

    @GetMapping("/v1/get-all-by-place-id/{placeId}")
    public ResponseEntity<List<LikeDTO>> getAllByPlaceId(@PathVariable Long placeId){

        List<Like> likes= service.getAllByPlaceId(placeId);
        List<LikeDTO> likeDTOS= mapper.toLikeDTOs(likes);
        return ResponseEntity.ok(likeDTOS);
    }


    @PostMapping("/v1/search")
    public ResponseEntity<List<LikeDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
    /*    for (SearchCriteria searchCriteria1:searchCriteria){
            if (searchCriteria1.getKey().equals("location")){
                var t = searchCriteria1.getValue();
                t.

                t.equals( {46.971746, 35.307712});
                Point<G2D> candidPoint= Geometries.mkPoint(new G2D(t., lat), CoordinateReferenceSystems.WGS84);
            }
        }*/
        List<Like> likes= service.search(searchCriteria);
        List<LikeDTO> likeDTOS = mapper.toLikeDTOs(likes);
        return ResponseEntity.ok(likeDTOS);
    }

}