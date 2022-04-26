package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateTime;

    @ManyToOne(fetch = FetchType.LAZY) // It is not necessary the OneToMany in the other Movie table, to avoid MappedBy
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY) // It is not necessary the OneToMany in the other Movie table, to avoid MappedBy
    private Cinema cinema;
}
