package com.dineeasy.restaurant.domain.menuitem.entity;

import com.dineeasy.restaurant.domain.menu.entity.Menu;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_item")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
