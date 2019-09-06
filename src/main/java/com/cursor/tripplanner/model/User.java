package com.cursor.tripplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_trip",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> tripUsers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Trip trip;

    public void setUsers(List<User> tripUsers) {
        this.tripUsers = tripUsers;
    }


}
