package com.mynt.MovieProjectApiPauGonzales.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //mark class as entity
@Table //defining class name as Table name
@Getter
@Setter
public class Genre {
    @Column //defining id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String genre_name;
}
