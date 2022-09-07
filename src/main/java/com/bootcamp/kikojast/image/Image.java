package com.bootcamp.kikojast.image;

import com.bootcamp.kikojast.commen.BaseEntity;
import com.bootcamp.kikojast.place.Place;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_file_attachments")
@Data
@Audited
public class Image extends BaseEntity {


    @NotNull
    @Column(name = "image")
    private String image;


   @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

}