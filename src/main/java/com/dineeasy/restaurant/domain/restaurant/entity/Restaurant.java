package com.dineeasy.restaurant.domain.restaurant.entity;

import com.dineeasy.restaurant.domain.address.valueobject.Address;
import com.dineeasy.restaurant.domain.diningtable.entity.DiningTable;
import com.dineeasy.restaurant.domain.menu.entity.Menu;
import com.dineeasy.restaurant.domain.restaurant.validation.OpenBeforeClose;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "restaurant",
    indexes = {@Index(columnList = "name")}
)
@OpenBeforeClose
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Restaurant name must not be blank")
    @Column(length = 100, nullable = false)
    @Size(max = 100)
    private String name;
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true)
    private Set<Menu> menus = new HashSet<>();
    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true)
    private Set<DiningTable> diningTables = new HashSet<>();
    @Embedded
    @NotNull(message = "Restaurant address is required")
    private Address address;
    @Min(value = 0, message = "Rating number cannot be negative")
    private Integer ratingNumber = 0;
    @DecimalMin(value = "1.0", message = "Average rating cannot be negative")
    @DecimalMax(value = "5.0", message = "Average rating cannot exceed 5.0")
    private Double averageRating = null;
    @Pattern(regexp = "^\\d{9,11}$", message = "Phone number must be between 9 and 11 digits")
    @Column(length = 11)
    private String phoneNumber;
    private LocalTime openTime;
    private LocalTime closeTime;
    @Email(message = "Email must be valid")
    @Column(length = 100)
    private String email;
    @URL(message = "Website URL must be valid")
    @Column(length = 255)
    private String website;
    @Column(name = "modify_datetime")
    private LocalDateTime modifyDateTime;

    public void calculateNewRating(Double rating){
        if (ratingNumber == null) ratingNumber = 0;
        if (averageRating == null) averageRating = 0.0;

        double totalRating = (averageRating * ratingNumber) + rating;
        ratingNumber++;
        averageRating = totalRating / ratingNumber;
    }

    @PrePersist
    @PreUpdate
    protected void updateTimestamp(){
        this.modifyDateTime = LocalDateTime.now();
    }


}
