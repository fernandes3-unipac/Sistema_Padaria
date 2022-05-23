/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "TB_Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDUsuario;
    @ManyToOne
    @JoinColumn(name = "IDPerfil")
    private Perfil perfil;
    @Column(name = "Nome")
    private String NomeUsuario;
    @Column(name = "Senha")
    private String Senha;
    @Column(name = "Status")
    private String Status;
    @Column(name = "Login")
    private String Login;
    public Usuario(int IDUsuario, Perfil perfil, String NomeUsuario, String Senha, String Status,String Login) {
        this.IDUsuario = IDUsuario;
        this.perfil = perfil;
        this.NomeUsuario = NomeUsuario;
        this.Senha = Senha;
        this.Status = Status;
        this.Login = Login;
    }

    public Usuario() {
    }
    public String getLogin(){
        return Login;
    }
    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public void setLogin(String Login){
        this.Login =  Login;
    }
}
