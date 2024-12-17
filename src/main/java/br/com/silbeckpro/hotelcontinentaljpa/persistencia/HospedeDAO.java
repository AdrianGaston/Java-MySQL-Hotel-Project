package br.com.silbeckpro.hotelcontinentaljpa.persistencia;

import br.com.silbeckpro.hotelcontinentaljpa.Hospede;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JTable;


public class HospedeDAO {
    private JTable tblHospede;
    
    //Construtores
    public HospedeDAO() {
    }

    public HospedeDAO(JTable tblHospede) {
        this.tblHospede = tblHospede;
    }
    
    //Método para cadastrar hóspede
    public void cadastrar(Hospede h) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
    
    //Método para listar
    public List<Hospede> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Query consulta = em.createQuery("SELECT h FROM Hospede h");
            List<Hospede> hospede = consulta.getResultList();
            return hospede;
        } finally {
            em.close();
        }
    }
    
    //Método para buscar hóspede pelo id
    public Hospede buscarporId(long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Hospede.class, id);
        } finally {
            em.close();
        }
    }
    
    //Método para pesquisar pelo nome do hóspede
    public List<Hospede> pesquisarNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Query consulta = em.createQuery("SELECT h FROM Hospede h WHERE h.nome LIKE :nome");
            consulta.setParameter("nome", "%" + nome + "%");
            List<Hospede> hospede = consulta.getResultList();
            return hospede;
        } finally {
            em.close();
        }
    } 
    
    //Método para pesquisar pelo cpf
    public List<Hospede> pesquisarCpf(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Query consulta = em.createQuery("SELECT h FROM Hospede h WHERE h.cpf = :cpf");
            consulta.setParameter("cpf", cpf);
            List<Hospede> hospede = consulta.getResultList();
            return hospede;
        } finally {
            em.close();
        }
    }
}
