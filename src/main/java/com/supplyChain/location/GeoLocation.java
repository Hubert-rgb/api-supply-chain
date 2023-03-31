package com.supplyChain.location;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private float longitude;
    private float latitude;

    public GeoLocation(float longitude, float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
