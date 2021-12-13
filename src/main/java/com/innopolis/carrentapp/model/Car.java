package com.innopolis.carrentapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "cars")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Car {

    @Id
    private UUID id;
    private String regNumber;
    private String manufacturer;
    private String model;
    @Column(name = "seat_capacity")
    private Integer seatCapacity;
    @Column(name = "type_transmission")
    @Enumerated(EnumType.STRING)
    private TypeTransmission typeTransmission;
    @Column(name = "rent_per_day")
    private Double rentPerDay;
    boolean available;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
}


