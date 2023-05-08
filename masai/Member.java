package com.masai;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;

    private boolean dose1status = false;

    private boolean dose2status = false;

    private LocalDate dose1date;

    private LocalDate dose2date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private VaccineRegistration vaccineRegistration;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "member")
    private IdCard idCard;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "member")
    private List<Appointment> appointmentList = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "blockedId")
    private BlockedAppointments blockedAppointments;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccineId")
    private Vaccine vaccine;


}
