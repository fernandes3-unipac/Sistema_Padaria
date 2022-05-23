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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Movimento;
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class MovimentoDAOImpl implements MovimentoDAO {

    private Connection conexao;

    public MovimentoDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<Movimento> getAllMovimentos() {

        List<Movimento> lstMovimentos = new ArrayList<Movimento>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstMovimentos = em.createQuery("from Movimento").getResultList();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstMovimentos;

    }

    @Override
    public Movimento getMovimentoByID(int id) {
        Movimento mov = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            mov = em.find(Movimento.class, id);
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return mov;
    }

    @Override
    public Movimento getMovimentoByDesc(String descricaoMovimentox) {
        Movimento mov = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("from Movimento c where c.Descricao = :descricao");
            query.setParameter("descricao", descricaoMovimentox);
            mov = (Movimento) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return mov;
    }

    public void updateMovimento(Movimento movimento) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(movimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        
    }

    @Override
    public int insertMovimento(Movimento movimento) {
        // SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return movimento.getIDMovimento();
    }

    @Override
    public void deleteMovimento(int id) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Movimento movimento = em.find(Movimento.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(movimento);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

    }
}
