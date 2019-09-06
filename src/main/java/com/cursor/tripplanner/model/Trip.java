package com.cursor.tripplanner.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trips")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private long id;

    @Column(name = "trip_name", nullable = false, unique = true, length = 100)
    private String tripName;

    @Column(name = "trip_date", nullable = false)
    private LocalDate tripDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "places_trip",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    private List<Place> tripPlaces = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "trip_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    private List<User> tripUsers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
