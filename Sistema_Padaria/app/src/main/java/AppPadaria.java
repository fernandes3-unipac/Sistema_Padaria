
import ClassesDAO.CategoriaDAO;
import ClassesDAO.CategoriaDAOImpl;
import ClassesDAO.ComandaDAO;
import ClassesDAO.ComandaDAOImpl;
import ClassesDAO.ItemComandaDAO;
import ClassesDAO.ItemComandaDAOImpl;
import ClassesDAO.MovimentoDAO;
import ClassesDAO.MovimentoDAOImpl;
import ClassesDAO.PerfilDAO;
import ClassesDAO.PerfilDAOImpl;
import ClassesDAO.ProdutosDAO;
import ClassesDAO.ProdutosDAOImpl;
import ClassesDAO.UnidadeMedidaDAO;
import ClassesDAO.UnidadeMedidaDAOImpl;
import ClassesDAO.UsuarioDAO;
import ClassesDAO.UsuarioDAOImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.ItemComanda;
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;
import sistema_padaria.Classes.Movimento;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Pedro
 */
public class AppPadaria {

    public static void main(String[] args) throws Exception {
        ComandaDAO com =  new ComandaDAOImpl();
       //SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        
        Comanda c =  com.getComandaByID(25);
        System.out.println("Data da comanda = " + c.getDataComanda() + " | " + c.getIDComanda());
        for(ItemComanda i : c.getItensComanda()){
            System.out.println("Produto = " + i.getProduto().getDescricao() + " | " + i.getQuantidade());
        }
        
        
        

      
        

    }

}
