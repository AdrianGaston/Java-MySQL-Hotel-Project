package br.com.silbeckpro.hotelcontinentaljpa.persistencia;

import br.com.silbeckpro.hotelcontinentaljpa.Reserva;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JTable;


public class ReservasDAO {
    private JTable tblReservas;
    
    //Construtores
    public ReservasDAO() {
    }

    public ReservasDAO(JTable tblReservas) {
        this.tblReservas = tblReservas;
    }
    
    //Método para cadastrar reserva
    public void cadastrar (Reserva r) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }  
    }
  
    //Método para listar reservas por status
    public List<Reserva> listarReservas(String status) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT r FROM Reserva r WHERE r.estatus = :status");
            consulta.setParameter("status", status);
            return consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    //Método para listar Check-In
    public List<Reserva> listarCheckIn(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("SELECT r FROM Reserva r WHERE checkin = CURDATE() AND estatus = 'Confirmada'");
            List<Reserva> reservas = consulta.getResultList();
            return reservas;
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    //Método para listar Check-Out
    public List<Reserva> listarCheckOut(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("SELECT r FROM Reserva r WHERE checkout = CURDATE() AND estatus = 'Em andamento'");
            List<Reserva> reservas = consulta.getResultList();
            return reservas;
        }finally{
            JPAUtil.closeEntityManager();
        }
    }  
    
    //Método para fazer Check-In
    public void fazerCheckIn(long reservaId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("UPDATE Reserva r SET r.estatus = 'Em andamento' WHERE r.id = :reservaId");
            query.setParameter("reservaId", reservaId);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    //Método para fazer Check-Out
    public void fazerCheckOut(long reservaId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("UPDATE Reserva r SET r.estatus = 'Finalizada' WHERE r.id = :reservaId");
            query.setParameter("reservaId", reservaId);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    //Método para obter o status de uma reserva
    public String getStatus(long reservaId) {
        EntityManager em = JPAUtil.getEntityManager();
        String status = null; 

        try {
            em.getTransaction().begin(); 
            Query query = em.createQuery("SELECT r.estatus FROM Reserva r WHERE r.id = :reservaId");
            query.setParameter("reservaId", reservaId);

            status = (String) query.getSingleResult();
            em.getTransaction().commit(); 
        } catch (Exception e) {
            em.getTransaction().rollback(); 
            e.printStackTrace();
        } finally {
            em.close(); 
        }
        return status; 
    }
   
    //Método para cancelar reserva
    public void cancelarReserva(long reservaId) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            Query query = em.createQuery("UPDATE Reserva r SET r.estatus = 'Cancelada' WHERE r.id = :reservaId");
            query.setParameter("reservaId", reservaId);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    //Método para recuperar o valor total da reserva
    public double getValorReserva(long reservaId) {
        EntityManager em = JPAUtil.getEntityManager();
        Reserva reserva = null;
        
        try {
            reserva = em.find(Reserva.class, reservaId);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return (reserva != null) ? reserva.getValorTotal() : 0.0;
    }
    
    //Método para listar as reservas em andamento
    public List<Reserva> listarOcupacao(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("SELECT r FROM Reserva r WHERE checkout >= CURDATE() AND estatus = 'Em andamento'");
            List<Reserva> reservas = consulta.getResultList();
            return reservas;
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
    
     //Método para pesquisar reservas pelo ID e status específico
    public List<Reserva> pesquisarId(long id, String status) {
        EntityManager em = JPAUtil.getEntityManager();
    
        try {
            Query consulta = em.createQuery("SELECT r FROM Reserva r WHERE r.id = :id AND r.estatus = :status");
            consulta.setParameter("id", id);
            consulta.setParameter("status", status);
            return consulta.getResultList();
        } finally {
            em.close();
        }
    }
    
    //Método para pesquisar reservas pelo nome do hóspede e status específico
    public List<Reserva> pesquisarNome(String nome, String status) {
        EntityManager em = JPAUtil.getEntityManager();
    
        try {
            Query consulta = em.createQuery("SELECT r FROM Reserva r JOIN r.hospede h WHERE h.nome LIKE :nome AND r.estatus = :status");
            consulta.setParameter("nome", "%" + nome + "%");
            consulta.setParameter("status", status);
            return consulta.getResultList();
        } finally {
            em.close();
        }
    }
    
    //Método para atualizar o status da reserva para No Show
    public void setNoShow() {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        try {
            Query consulta = em.createQuery("UPDATE Reserva r SET r.estatus = 'No Show' WHERE r.checkin < CURRENT_DATE AND r.estatus = 'Confirmada'");
            consulta.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    //Método para encerrar os Check-Out's que não foram feitos
    public void encerrarCheckOuts() {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        try {
            Query consulta = em.createQuery("UPDATE Reserva r SET r.estatus = 'Finalizada' WHERE r.checkout < CURRENT_DATE AND r.estatus = 'Em andamento'");
            consulta.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
