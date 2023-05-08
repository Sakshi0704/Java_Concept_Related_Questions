package com.masai;

import javax.persistence.*;

@Entity
public class BlockedAppointments {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer blockedid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Member member;

}
