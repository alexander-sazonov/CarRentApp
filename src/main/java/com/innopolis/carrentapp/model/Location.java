package com.innopolis.carrentapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "locations")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Location {
    @Id
    private UUID id;
    private String country;
    private String city;
    private String address;
    private String email;
    private String phone;
}
