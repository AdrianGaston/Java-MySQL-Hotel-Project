package br.com.silbeckpro.hotelcontinentaljpa.persistencia;

import br.com.silbeckpro.hotelcontinentaljpa.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {

    public CategoriaDAO() {
    }
    
    //Método para listar as categorias
    public List<Categoria> listarCategoria() {
        EntityManager em = JPAUtil.getEntityManager();
        
        List<Categoria> categorias = new ArrayList<Categoria>();
        try {
            Query consulta = em.createQuery("SELECT c FROM Categoria c");
            categorias = consulta.getResultList();
        }catch(Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
        return categorias;
    }
}
