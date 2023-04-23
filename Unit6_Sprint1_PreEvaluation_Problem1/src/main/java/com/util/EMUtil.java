package com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
			private static EntityManagerFactory ef;
		static {
			ef = Persistence.createEntityManagerFactory("consultancy-unit");
		}
		
		public static EntityManager getEntityMangaer() {
			return ef.createEntityManager();
		}
		
		
}
