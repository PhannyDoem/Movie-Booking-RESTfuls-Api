package com.moviebooking.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "showtimes")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_id")
    private Long showtimeId;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    public Showtime(){}

    public Showtime(LocalDate startDate, LocalDate endDate, Movie movie, Theater theater) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.movie = movie;
        this.theater = theater;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
