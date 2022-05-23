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
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "TB_Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPerfil")
    private int IDPerfil;
    @Column(name = "Descricao")
    private String Descricao;

    public Perfil(int IDPerfil, String Descricao) {
        this.IDPerfil = IDPerfil;
        this.Descricao = Descricao;
    }

    public Perfil() {
    }

    public int getIDPerfil() {
        return IDPerfil;
    }

    public void setIDPerfil(int IDPerfil) {
        this.IDPerfil = IDPerfil;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

}
