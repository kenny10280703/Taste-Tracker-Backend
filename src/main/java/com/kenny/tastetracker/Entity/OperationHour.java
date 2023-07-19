package com.kenny.tastetracker.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "operation_hour")
public class OperationHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "opening_time")
    private String openingTime;

    @Column(name = "closing_time")
    private String closingTime;

    public String toString() {
        return dayOfWeek + " " + openingTime + " - " + closingTime;
    }

}
