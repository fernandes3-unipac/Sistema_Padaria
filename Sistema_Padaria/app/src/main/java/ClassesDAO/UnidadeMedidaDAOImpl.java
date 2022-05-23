/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import DataBase.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class UnidadeMedidaDAOImpl implements UnidadeMedidaDAO {


    @Override
    public List<UnidadeMedida> getAllUnidadesMedida() {
        List<UnidadeMedida> lstUnidadesMedida = new ArrayList<UnidadeMedida>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstUnidadesMedida = em.createQuery("from UnidadeMedida").getResultList();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstUnidadesMedida;
    }

    @Override
    public UnidadeMedida getUnidadeMedidaByID(int id) {

        UnidadeMedida unidade = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            unidade = em.find(UnidadeMedida.class, id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return unidade;
    }

    @Override
    public UnidadeMedida getUnidadeMedidaByDesc(String unidadeMedida) {
        UnidadeMedida unidade = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("from UnidadeMedida c where c.Descricao = :descricao");
            query.setParameter("descricao", unidadeMedida);
            unidade = (UnidadeMedida) query.getSingleResult();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return unidade;
    }

    @Override
    public void updateUnidadeMedida(UnidadeMedida unidadeMedida) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(unidadeMedida);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro de BD = " + " - " + ex.getMessage());
        }
    }

    @Override
    public int insertUnidadeMedida(UnidadeMedida unidadeMedida) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(unidadeMedida);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return unidadeMedida.getIDUnidadeMedida();
    }

    @Override
    public void deleteUnidadeMedida(int id) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            UnidadeMedida unidadeMedida = em.find(UnidadeMedida.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(unidadeMedida);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

}
