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
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class ProdutosDAOImpl implements ProdutosDAO {

    private Connection conexao;

    public ProdutosDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<Produtos> getAllProducts() {

        List<Produtos> lstProducts = new ArrayList<Produtos>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstProducts = em.createQuery("from Produtos").getResultList();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstProducts;

    }

    @Override
    public Produtos getProdutoByID(int id) {
        Produtos produto = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            produto = em.find(Produtos.class, id);

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return produto;
    }

    @Override
    public Produtos getProdutoByDesc(String nomeProduto) {

        Produtos produto = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("from Produtos c where c.Descricao = :descricao");
            query.setParameter("descricao", nomeProduto);
            produto = (Produtos) query.getSingleResult();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return produto;
    }

    @Override
    public void updateProduto(Produtos produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro de BD = " + " - " + ex.getMessage());
        }
    }

    @Override
    public int insertProduto(Produtos produto) {

        // produto = Descricao  = Banana do batman, 
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return produto.getIDProduto();
    }

    @Override
    public void deleteProduto(int id) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Produtos produto = em.find(Produtos.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();


        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

}
