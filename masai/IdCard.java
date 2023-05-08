package com.masai;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "IDCARD")
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private LocalDate dob;

    private String gender;

    private String address;
    private String city;
    private String state;
    private String pincode;

    @Column(unique = true)
    private String pancardNo;

    @Column(unique = true)
    private String aadharNo;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Member member;


}
