package com.dineeasy.restaurant.domain.diningtable.entity;

import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dining_table")
public class DiningTable {
    @Id
    private Long id;
    @Min(value = 1, message = "Table capacity must be at least 1")
    @NotNull
    private Integer capacity;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
