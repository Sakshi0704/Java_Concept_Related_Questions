package com.masai;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "VaccinERegistration")
public class VaccineRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regId;

    private String mobileNO;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vaccineRegistration")
    private List<Member> members;

    private LocalDate dateOfRegistration;
}
