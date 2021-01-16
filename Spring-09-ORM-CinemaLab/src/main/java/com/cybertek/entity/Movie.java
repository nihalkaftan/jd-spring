package com.cybertek.entity;

import com.cybertek.enums.MovieState;
import com.cybertek.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseEntity{

    private String name;
    private Integer duration;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @Column(columnDefinition = "Date")
    private LocalDate releaseDate;

    @Column(columnDefinition = "text")
    private String summary;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel", joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList = new ArrayList<>();

    public Movie(String name, Integer duration, BigDecimal price, MovieState state, MovieType type, LocalDate releaseDate, String summary) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.state = state;
        this.type = type;
        this.releaseDate = releaseDate;
        this.summary = summary;
    }
}
