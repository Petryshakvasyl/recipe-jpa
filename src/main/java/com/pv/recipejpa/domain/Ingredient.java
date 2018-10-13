package com.pv.recipejpa.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Data
@RequiredArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn
    private Recipe recipe;
    @NonNull
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMesure unitOfMesure;
}
