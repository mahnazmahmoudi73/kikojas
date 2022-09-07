package com.bootcamp.kikojast.user;


import com.bootcamp.kikojast.commen.BaseEntity;
import com.bootcamp.kikojast.comment.Comment;
import com.bootcamp.kikojast.like.Like;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
@Audited
public class User extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "email_or_phone")
    private String emailOrPhone;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "profile")
    private String profile;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Like> likes;

}
