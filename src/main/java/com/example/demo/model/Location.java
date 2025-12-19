package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String locationCode;

    private String locationName;

    private Integer capacity;

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
