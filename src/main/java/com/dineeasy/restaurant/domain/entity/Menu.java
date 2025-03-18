package com.dineeasy.restaurant.domain.entity;

import com.dineeasy.restaurant.domain.constant.MenuLanguage;
import com.dineeasy.restaurant.domain.constant.MenuType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "menu")
    private Set<MenuItem> items = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private MenuType menuType;
    @Enumerated(EnumType.STRING)
    private MenuLanguage menuLanguage;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public void addItem(){}

    public void removeItem(){}
}
