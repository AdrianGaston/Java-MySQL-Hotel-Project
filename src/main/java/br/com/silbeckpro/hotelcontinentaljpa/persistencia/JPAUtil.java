package br.com.silbeckpro.hotelcontinentaljpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPAUtil {
    //Constante para centralizar o nome da unidade de persistencia
    private static final String PERSISTENCE_UTIL = "HotelContinental-PU";
    private static EntityManager em;
    private static EntityManagerFactory emf;
    
    //Cria a entidade se estiver nula e a retorna
    public static EntityManager getEntityManager() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UTIL);
        }
        
        //Cria-se em nulo ou se o EntityManager foi fechado
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }
    
    //Fecha o EntityManager e o Factory
    public static void closeEntityManager() {
        if (em.isOpen() && em != null) {
            em.close();
            emf.close();
        }
    }
}
