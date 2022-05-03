package com.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateTime;

    @ManyToOne(fetch = FetchType.LAZY) // It is not necessary the OneToMany in the other Movie table, to avoid MappedBy
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY) // It is not necessary the OneToMany in the other Movie table, to avoid MappedBy
    private Cinema cinema;

    // We need to override toString becasuse some variables are not ready to read because FetchType.LAZY
    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                '}';
    }
}
