package com.example.projet1springboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="locations")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Location {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private Long id_location;
    @Column(nullable = false)
    private int latitude;
    @Column(nullable = false)
    private int longitude;
    @Column(nullable = false)
    private String location_date;  // page 17


    @ManyToMany
    @JsonIgnore // pour ne pas produire des cycles
    private List<User> users;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public Long getId_location() {
        return id_location;
    }

    public void setId_location(Long id_location) {
        this.id_location = id_location;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getLocation_date() {
        return location_date;
    }

    public void setLocation_date(String location_date) {
        this.location_date = location_date;
    }
}
