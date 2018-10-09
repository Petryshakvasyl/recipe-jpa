package com.pv.recipejpa.domain;

import com.pv.recipejpa.Difficulty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    @Lob
    private Difficulty difficulty;
    private Byte [] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

}
