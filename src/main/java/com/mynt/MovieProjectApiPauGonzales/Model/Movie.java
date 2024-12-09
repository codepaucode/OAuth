package com.mynt.MovieProjectApiPauGonzales.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity //mark class as entity
@Table //defining class name as Table name
@Getter
@Setter
public class Movie {

    @Column //defining id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String name;

    @Column
    public Integer yearReleased;

    @Column
    public Boolean isSequel;

    @ManyToOne
    @JoinColumn(name = "genre") // Specify the foreign key column
    private Genre genre;

    @Column
    public List<String> castList;
}
