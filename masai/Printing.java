package com.masai;

import EM.EntityM;

import javax.persistence.EntityManager;

public class Printing {
    public static void main(String[] args) {
        EntityManager em = EntityM.getEM();

        System.out.println(em.find(Member.class, 1).getIdCard());

    }
}
