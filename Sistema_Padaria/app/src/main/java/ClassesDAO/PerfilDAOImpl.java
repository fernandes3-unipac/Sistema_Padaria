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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Perfil;

/**
 *
 * @author Pedro
 */
public class PerfilDAOImpl implements PerfilDAO {

    @Override
    public List<Perfil> getAllPerfis() {
        List<Perfil> lstPerfis = new ArrayList<Perfil>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstPerfis = em.createQuery("from Perfil").getResultList();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstPerfis;
    }

    @Override
    public Perfil getPerfilByID(int id) {
        // TODO Auto-generated method stub
        Perfil perf = new Perfil();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            perf = em.find(Perfil.class, id);
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return perf;

    }

    @Override
    public Perfil getPerfilByDesc(String descricao) {
        Perfil perf = new Perfil();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("from Perfil c where c.Descricao = :descricao");
            query.setParameter("descricao", descricao);
            perf = (Perfil) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return perf;

    }

    @Override
    public void updatePerfil(Perfil perfil) {
       
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(perfil);
            em.getTransaction().commit();

            } catch (Exception ex) {
                System.out.println("Erro de BD = " + " - " + ex.getMessage());
            }

        

    }

    @Override
    public int insertPerfil(Perfil perfil) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(perfil);

            em.getTransaction().commit();
        
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return perfil.getIDPerfil();

    }

    @Override
    public void deletePerfil(int id) {
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Perfil perf = em.find(Perfil.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(perf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
            em.getTransaction().rollback();
        }
        
    }

}
