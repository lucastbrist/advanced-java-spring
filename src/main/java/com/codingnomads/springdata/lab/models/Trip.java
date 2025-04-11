package com.codingnomads.springdata.lab.models;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "trips")
@Builder
@ToString
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "origin_area_id", nullable = false, foreignKey = @ForeignKey(name = "fk_trips_origin_area_id"))
    private Area origin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stop_area_id", nullable = false, foreignKey = @ForeignKey(name = "fk_trips_stop_area_id"))
    private Area stop;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "destination_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_trips_destination_area_id"))
    private Area destination;

    public String generateCode() {

        String origin = this.origin.getCode();
        String stop = this.stop.getCode();
        String destination = this.destination.getCode();

        String code = origin + "-" + stop + "-" + destination;

        return code;
    }
}
