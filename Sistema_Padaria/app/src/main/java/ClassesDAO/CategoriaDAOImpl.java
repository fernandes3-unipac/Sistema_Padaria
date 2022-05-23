/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import DataBase.Conexao;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> getAllCategorias() {
        List<Categoria> lstCategorias = new ArrayList<Categoria>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstCategorias = em.createQuery("from Categoria").getResultList();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstCategorias;
    }

    @Override
    public Categoria getCategoria(int id) {
        Categoria cat = new Categoria();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            cat = em.find(Categoria.class, id);
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return cat;

    }

    @Override
    public Categoria getCategoria(String descricao) {
        Categoria cat = new Categoria();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("from Categoria c where c.Descricao = :descricao");
            query.setParameter("descricao", descricao);
            cat = (Categoria) query.getSingleResult();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return cat;

    }

    @Override
    public void updateCategoria(Categoria categoria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(categoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro de BD = " + ex.getMessage());
            em.getTransaction().rollback();
        }

    }

    @Override
    public int insertCategoria(Categoria categoria) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(categoria);

            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
        System.out.println(categoria.getIDCategoria());
        return categoria.getIDCategoria();

    }

    @Override
    public void deleteCategoria(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Categoria categoria = em.find(Categoria.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(categoria);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
            em.getTransaction().rollback();
        }

    }
}
