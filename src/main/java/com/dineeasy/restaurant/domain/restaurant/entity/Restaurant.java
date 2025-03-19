package com.dineeasy.restaurant.domain.restaurant.entity;

import com.dineeasy.restaurant.domain.address.entity.Address;
import com.dineeasy.restaurant.domain.businesshours.entity.BusinessHours;
import com.dineeasy.restaurant.domain.diningtable.entity.DiningTable;
import com.dineeasy.restaurant.domain.menu.entity.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Menu> menus;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DiningTable> tables;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    private Double rating;
    private String phoneNumber;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BusinessHours> businessHours;

    public void addTable(DiningTable table){
        this.tables.add(table);
    }

    public void removeTable(DiningTable table){
        this.tables.remove(table);
    }

    public void addMenu(Menu menu){
        this.menus.add(menu);
    }

    public void removeMenu(Menu menu){
        this.menus.remove(menu);
    }

}
