package com.kietnguyen.models;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.enums.CatBreed;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cat")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    @Type(type = "com.kietnguyen.tools.EnumTypePostgreSql")
    private CatColor color;

    @Column(name = "breed")
    @Enumerated(EnumType.STRING)
    @Type(type = "com.kietnguyen.tools.EnumTypePostgreSql")
    private CatBreed breed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public CatBreed getBreed() {
        return breed;
    }

    public void setBreed(CatBreed breed) {
        this.breed = breed;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void clone(Cat cat) {
        this.name = cat.getName();
        this.dateOfBirth = cat.getDateOfBirth();
        this.owner = cat.getOwner();
        this.color = cat.getColor();
        this.breed = cat.getBreed();
    }

    public String toString()
    {
        return ("ID:" + id + "\t\tNAME:" + name + "\t\tBIRTHDAY:"+ dateOfBirth.toString() + "\t\tBREED:" + breed.toString()  + "\t\tCOLOR:" + color.toString() + ".");
    }
}
