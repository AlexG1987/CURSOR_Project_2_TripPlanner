package com.cursor.tripplanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "user_name", nullable = false, unique = true, length = 100)
    private String userName;

    @Column(name = "comment", nullable = false, unique = true, length = 50)
    private String comment;

}
