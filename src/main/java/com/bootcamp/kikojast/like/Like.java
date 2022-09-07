package com.bootcamp.kikojast.like;

import com.bootcamp.kikojast.commen.BaseEntity;
import com.bootcamp.kikojast.place.Place;
import com.bootcamp.kikojast.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_like")
@Data
@Audited
public class Like extends BaseEntity {


    @NotNull
    @Column(name = "is_like")
    private Boolean isLike;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;



}