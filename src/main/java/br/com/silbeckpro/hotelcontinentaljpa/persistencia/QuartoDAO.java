package br.com.silbeckpro.hotelcontinentaljpa.persistencia;

import br.com.silbeckpro.hotelcontinentaljpa.Quarto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class QuartoDAO {
    
    //Construtor sem argumentos
    public QuartoDAO() {
    }

    //Método para listar os quartos por categoria
    public List<Quarto> listarQuartosPorCategoria(int categoriaId) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Quarto> quartos = new ArrayList<>();
        try {
            Query consulta = em.createQuery("SELECT q FROM Quarto q WHERE q.categoria.id = :categoriaId");
            consulta.setParameter("categoriaId", categoriaId);
            quartos = consulta.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
        return quartos;
    }
    
   //Método para listar os quartos disponíveis por categoria
    public List<Quarto> listarQuartosDisponiveis(int categoriaId, LocalDate checkIn, LocalDate checkOut) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Quarto> quartosDisponiveis = new ArrayList<>();
        try { 
            Query consulta = em.createQuery("SELECT q FROM Quarto q WHERE q.categoria.id = :categoriaId " +
                                            "AND q NOT IN (SELECT r.quarto FROM Reserva r WHERE " +
                                            "((r.checkin < :checkOut AND r.checkout > :checkIn) OR " +
                                            "(r.checkin = :checkOut)) " +
                                            "AND (r.estatus = 'Confirmada' OR r.estatus IS NULL))"); 
            consulta.setParameter("categoriaId", categoriaId);
            consulta.setParameter("checkIn", checkIn);
            consulta.setParameter("checkOut", checkOut);
    
            quartosDisponiveis = consulta.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback(); 
            throw e; 
        } finally {
            em.close(); 
        }
        return quartosDisponiveis;
    }
}
