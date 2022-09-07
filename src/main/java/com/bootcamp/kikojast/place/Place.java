package com.bootcamp.kikojast.place;

import com.bootcamp.kikojast.commen.BaseEntity;
import com.bootcamp.kikojast.comment.Comment;
import com.bootcamp.kikojast.image.Image;
import com.bootcamp.kikojast.like.Like;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_place")
@Data
@Audited
public class Place extends BaseEntity {

    @NotNull
    @Column(name = "title", unique = true)
    private String title;

    @NotNull
    @Column(name = "start_service")
    private Integer startService;

    @NotNull
    @Column(name = "end_service")
    private Integer endService;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @NotNull
    @Column(name = "place_location")
    private Point<G2D> location;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "place",cascade = CascadeType.ALL)
    private List<Image> imageList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "place",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "place",cascade = CascadeType.ALL)
    private List<Like> likes;









}