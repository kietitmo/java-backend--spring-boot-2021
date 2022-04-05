package com.kietnguyen.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cat_friend")
public class CatAndFriend implements Serializable {
    public CatAndFriend() {}
    public CatAndFriend(Cat cat, Cat friend ) {
        this.cat = cat;
        this.friend = friend;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn (name = "id_cat")
    @OneToOne
    private Cat cat;

    @OneToOne
    @JoinColumn(name = "id_friend")
    private Cat friend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Cat getFriend() {
        return friend;
    }

    public void setFriend(Cat friend) {
        this.friend = friend;
    }
}
