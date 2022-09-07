package com.bootcamp.kikojast.image;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/image/")
@AllArgsConstructor
public class ImageController {

    private final IImageService service;
    private ImageMapper mapper;


    @PostMapping("/v1")
    @RolesAllowed("admin")
    public ResponseEntity save(@RequestBody ImageDTO imageDTO){
        Image image =mapper.toImage(imageDTO);
        service.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ImageDTO imageDTO){
        Image image =mapper.toImage(imageDTO);
        service.update(image);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/v1/{id}")
    public ResponseEntity<ImageDTO> getById(@PathVariable Long id ){

    Image image = service.getById(id);
    ImageDTO imageDTO =mapper.toImageDTO(image);
        return ResponseEntity.ok(imageDTO);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<ImageDTO>> getAll(){

    List<Image> images = service.getAll();
    List<ImageDTO> imageDTOS =    mapper.toImageDTOs(images);
        return ResponseEntity.ok(imageDTOS);
    }

    @GetMapping("/v1/get-all-by-place-id/{placeId}")
    public ResponseEntity<List<ImageDTO>> getAllByPlaceId(@PathVariable Long placeId){

        List<Image> images = service.getAllByPlaceId(placeId);
        List<ImageDTO> imageDTOS = mapper.toImageDTOs(images);
        return ResponseEntity.ok(imageDTOS);
    }

    @DeleteMapping("/v1/{id}")
    @RolesAllowed("admin")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }



}