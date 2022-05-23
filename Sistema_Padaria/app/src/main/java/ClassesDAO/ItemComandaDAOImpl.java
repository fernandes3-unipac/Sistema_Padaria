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
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.ItemComanda;
import sistema_padaria.Classes.Produtos;

/**
 *
 * @author Pedro
 */
public class ItemComandaDAOImpl implements ItemComandaDAO {



    @Override
    public List<ItemComanda> getAllItensComanda() {
        List<ItemComanda> lstItensComanda = new ArrayList<ItemComanda>();

        List<Produtos> lstProducts = new ArrayList<Produtos>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstProducts = em.createQuery("from ItemComanda").getResultList();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstItensComanda;

    }

    @Override
    public ItemComanda getItemComandaByID(int id) {
        ItemComanda item = new ItemComanda();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            item = em.find(ItemComanda.class, id);
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return item;
    }

    @Override
    public void updateItemComanda(ItemComanda itemComanda) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(itemComanda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro de BD = "  + " - " + ex.getMessage());
        }

    }

    @Override
    public void deleteItemComanda(int id) {
        
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            ItemComanda item = em.find(ItemComanda.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(item);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
            em.getTransaction().rollback();
        }

    }

 
}
