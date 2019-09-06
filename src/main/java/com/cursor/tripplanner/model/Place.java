package com.cursor.tripplanner.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "places")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private long id;

    @Column(name = "place_name", nullable = false, unique = true, length = 100)
    private String placeName;

    @Column(name = "country", nullable = false, unique = true, length = 50)
    private String country;

    @Column(name = "address", nullable = false, unique = true, length = 200)
    private String address;

    @ElementCollection
    @CollectionTable(name = "user_rate_for_place", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "rate")
    private Map<User, Double> userRates = new HashMap<User, Double>();

    @ElementCollection
    @CollectionTable(name = "user_comments_for_place", joinColumns = @JoinColumn(name = "comment_id"))
    @Column(name = "comment")
    private Map<User, String> userComments = new HashMap<User, String>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Trip trip;

}
