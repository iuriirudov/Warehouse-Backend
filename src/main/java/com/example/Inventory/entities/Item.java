package com.example.Inventory.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Item extends Base {

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Price must not be null")
    @PositiveOrZero(message = "Price must be a number. Positive or Zero")
    private Double price;

    @NotNull(message = "Quantity cannot be null")
    @PositiveOrZero(message = "Quantity must be a number. Positive or Zero")
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String image;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    @NotNull(message = "You have to select a category.")
    private Category category;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private Set<User> users;

}
