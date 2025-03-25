package com.dineeasy.restaurant.domain.menuitem.entity;

import com.dineeasy.restaurant.domain.menu.entity.Menu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_item",
    uniqueConstraints = {@UniqueConstraint(name = "UniqueName", columnNames = {"name"})},
    indexes = {@Index(columnList = "name")}
)
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Menu name must not be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
    @Column(name = "modify_datetime")
    private LocalDateTime modifyDateTime;

    @PrePersist
    @PreUpdate
    protected void setTimestamp(){
        this.modifyDateTime = LocalDateTime.now();
    }
}
