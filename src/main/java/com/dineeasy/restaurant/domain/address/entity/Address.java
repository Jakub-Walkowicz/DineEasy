package com.dineeasy.restaurant.domain.address.entity;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "address",
        uniqueConstraints = {@UniqueConstraint(name="UniqueCountryAndPostalCode", columnNames = {"country", "postalCode"}),
        @UniqueConstraint(name="UniqueStreetNameAndBuildingNumber", columnNames = {"streetName", "buildingNumber"})})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 50, message = "Country name must be between 2 and 50 characters")
    @Column(length = 50)
    private String country;
    @Pattern(regexp = "\\d{5}", message = "Postal code must be in the format XXXXX")
    @Column(length = 5)
    private String postalCode;
    @Column(length = 100)
    @Size(min = 2, max = 100, message = "City name must be between 2 and 100 characters")
    private String city;
    @Column(length = 100)
    @Size(min = 2, max = 100, message = "Street name must be between 2 and 100 characters")
    private String streetName;
    @Column(length = 25)
    @Size(min = 2, max = 25, message = "Building number must be between 2 and 25 characters")
    private String buildingNumber;
    private LocalDateTime modifyDateTime;

    @PrePersist
    @PreUpdate
    protected void updateTimestamp() {
        this.modifyDateTime = LocalDateTime.now();
    }

}
