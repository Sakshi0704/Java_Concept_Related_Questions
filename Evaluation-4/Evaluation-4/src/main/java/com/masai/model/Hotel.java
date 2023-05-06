package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;
    @NotBlank
    private String name;
    @NotBlank
    private String imgUrl;
    @NotBlank
    private String address;
    private String city;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL , mappedBy = "hotel")
    private List<RoomType> roomTypes;


}
