package com.cybertek.entity;

import com.cybertek.enums.MovieState;
import com.cybertek.enums.MovieType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

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

}
