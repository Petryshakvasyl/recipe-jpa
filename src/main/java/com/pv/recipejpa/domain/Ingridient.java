package com.pv.recipejpa.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Data
public class Ingridient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMesure unitOfMesure;
}
