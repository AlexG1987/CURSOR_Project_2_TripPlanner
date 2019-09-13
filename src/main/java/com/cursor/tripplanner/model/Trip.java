package com.cursor.tripplanner.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long id;

    @Column(name = "trip_name", nullable = false, unique = true)
    private String tripName;

    @Column(name = "trip_date", nullable = false)
    private String tripDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "places_trip",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    private List<Place> tripPlaces;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "trip_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    private List<User> tripUsers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public void addPlace(Place place) {
        this.tripPlaces.add(place);
        place.setTrip(this);
    }

    public void removePlace(Place place) {
        this.getTripPlaces().remove(place);
        place.setTrip(null);
    }

}
