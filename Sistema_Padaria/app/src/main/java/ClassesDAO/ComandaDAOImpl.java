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
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.ItemComanda;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class ComandaDAOImpl implements ComandaDAO {

    @Override
    public List<Comanda> getAllComandas() {

        List<Comanda> lstComanda = new ArrayList<Comanda>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstComanda = em.createQuery("from Comanda").getResultList();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstComanda;

    }

    @Override
    public Comanda getComandaByID(int id) {
        Comanda com = new Comanda();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            com = em.find(Comanda.class, id);
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return com;
    }

    @Override
    public void updateComanda(Comanda comanda) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(comanda);
            em.getTransaction().commit();
        }catch (Exception ex) {
            System.out.println("Erro de BD = " + " - " + ex.getMessage());
        }
    }

    @Override
    public int insertComanda(Comanda comanda) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(comanda);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return comanda.getIDComanda()   ;
    }

    @Override
    public void deleteComanda(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Comanda com = em.find(Comanda.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(com);
            em.getTransaction().commit();

        }catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

}
