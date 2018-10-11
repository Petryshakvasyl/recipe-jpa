package com.pv.recipejpa.domain;

import com.pv.recipejpa.Difficulty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    @Enumerated(value = EnumType.STRING )
    private Difficulty difficulty;
    @Lob
    private Byte [] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    Set<Ingridient> ingridients;

}
