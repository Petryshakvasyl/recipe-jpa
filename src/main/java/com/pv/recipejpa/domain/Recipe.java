package com.pv.recipejpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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
    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING )
    private Difficulty difficulty;
    @Lob
    private Byte [] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
            @JoinTable(name="recepy_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories = new HashSet<>();


    public void setNotes(Notes notes){
        this.notes = notes;
        notes.setRecipe(this);
    }

    public void addIngredient(Ingredient ingredient){
        this.getIngredients().add(ingredient);
        ingredient.setRecipe(this);
    }
}
