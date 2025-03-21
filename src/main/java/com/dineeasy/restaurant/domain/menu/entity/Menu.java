package com.dineeasy.restaurant.domain.menu.entity;

import com.dineeasy.restaurant.domain.menu.constant.MenuLanguage;
import com.dineeasy.restaurant.domain.menu.constant.MenuType;
import com.dineeasy.restaurant.domain.menuitem.entity.MenuItem;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
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
