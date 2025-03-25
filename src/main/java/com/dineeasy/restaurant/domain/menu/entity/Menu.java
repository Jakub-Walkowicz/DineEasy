package com.dineeasy.restaurant.domain.menu.entity;

import com.dineeasy.restaurant.domain.menu.constant.MenuLanguage;
import com.dineeasy.restaurant.domain.menu.constant.MenuType;
import com.dineeasy.restaurant.domain.menuitem.entity.MenuItem;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu",
    uniqueConstraints = {@UniqueConstraint(name = "UniqueNameAndRestaurant", columnNames = {"name", "restaurant_id"})
    },
    indexes = {
        @Index(columnList = "name")
    }
)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Menu name must not be blank")
    @Size(min = 2, max = 100, message = "Menu name must be between 2 and 100 characters")
    @Column(length = 100, nullable = false)
    private String name;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MenuItem> items = new HashSet<>();
    @NotNull(message = "Menu type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MenuType menuType;
    @NotNull(message = "Menu language is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MenuLanguage menuLanguage;
    @NotNull(message = "Restaurant is required")
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
    @Column(name = "modify_datetime")
    private LocalDateTime modifyDateTime;

    public void addItem(MenuItem item){
        this.items.add(item);
        item.setMenu(this);
    }

    public void removeItem(Long item){
        this.items.remove(item);
    }

    @PrePersist
    @PreUpdate
    protected void updateTimestamp(){
        this.modifyDateTime = LocalDateTime.now();
    }
}
