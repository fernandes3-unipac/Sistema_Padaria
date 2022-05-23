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
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection conexao;

    public UsuarioDAOImpl() {
        conexao = Conexao.getConnection();
    }

    @Override
    public List<Usuario> getAllUsers() {
        List<Usuario> lstUsers = new ArrayList<Usuario>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            lstUsers = em.createQuery("from Usuario").getResultList();
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return lstUsers;

    }

    @Override
    public Usuario getUserById(int id) {

        Usuario user = null;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
            EntityManager em = emf.createEntityManager();
            user = em.find(Usuario.class, id);
        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }

        return user;

    }

    @Override
    public void updateUser(Usuario user) { // Usuario u =  new Usuario ("Pedro", usuarioBusca.get
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + " - " + ex.getMessage());
        }

    }

    @Override
    public int insertUser(Usuario user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
            em.getTransaction().rollback();
        }
        return user.getIDUsuario();
    }

    @Override
    public void deleteUser(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        try {

            Usuario user = em.find(Usuario.class, id);
            // TODO Auto-generated method stub
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
    }

    @Override
    public Usuario getUserByName(String nomeUsuario) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("padaria");
        EntityManager em = emf.createEntityManager();
        Usuario user = new Usuario();
        try {
            Query query = em.createQuery("from Usuario c where c.NomeUsuario = :nome");
            query.setParameter("nome", nomeUsuario);
            user = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro = " + e.getMessage());
        }
        return user;
    }

}
