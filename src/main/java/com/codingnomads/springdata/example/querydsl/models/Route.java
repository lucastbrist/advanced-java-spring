/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.querydsl.models;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "routes")
@Builder
@ToString
public class Route implements Serializable {

    private static final long serialVersionUID = -5696564962139780350L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String code;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "origin_area_id", nullable = false, foreignKey = @ForeignKey(name = "fk_routes_origin_area_id"))
    private Area origin;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(
            name = "destination_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_destination_area_id"))
    private Area destination;

    public String generateCode() {

        String origin = this.origin.getCode();
        String destination = this.destination.getCode();

        String code = origin + "-" + destination;

        return code;
    }
}
