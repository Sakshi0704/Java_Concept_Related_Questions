package com.masai;

import EM.EntityM;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        EntityManager em = EntityM.getEM();


        VaccineRegistration vR = new VaccineRegistration();
        vR.setMobileNO("9833626870");
        Member member1 = new Member();
        member1.setDose1status(true);


        IdCard idCard1 = new IdCard();
        idCard1.setCity("City1");
        idCard1.setDob(LocalDate.now());
        idCard1.setGender("Male");
        idCard1.setAddress("Address1");
        idCard1.setAadharNo("123412341234");
        idCard1.setPincode("Pin1");
        idCard1.setState("State1");

        Vaccine vaccine1 = new Vaccine();
        vaccine1.setVaccineName("CoviShield");
        vaccine1.setDescription("Desc1");

        member1.setVaccine(vaccine1);

        idCard1.setMember(member1);
        member1.setIdCard(idCard1);

        vR.setMembers(new ArrayList<>());
        vR.getMembers().add(member1);

        em.getTransaction().begin();
        em.persist(vR);

        em.persist(idCard1);
        em.persist(member1);

        em.getTransaction().commit();

        System.out.println("DONE SUCCESSFULLY");





    }
}
