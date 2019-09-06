package com.cursor.tripplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id")
    private long id;

    @Column(name = "user_name", nullable = false, unique = true, length = 100)
    private String userName;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Trip trip;

}
