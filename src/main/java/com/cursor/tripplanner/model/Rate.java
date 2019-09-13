package com.cursor.tripplanner.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rates")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id")
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Trip trip;

}
