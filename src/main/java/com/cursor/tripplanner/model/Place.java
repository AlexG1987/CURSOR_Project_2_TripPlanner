package com.cursor.tripplanner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    @Column(name = "place_name", nullable = false, unique = true)
    private String placeName;

    @Column(name = "country", nullable = false, unique = true)
    private String country;

    @ElementCollection
    @CollectionTable(name = "user_rate_for_place", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "rate")
    private List<Double> userRates = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_comments_for_place", joinColumns = @JoinColumn(name = "comment_id"))
    @Column(name = "comment")
    private List<String> userComments = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Trip trip;

}
