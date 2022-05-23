/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

/**
 *
 * @author Pedro
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCategoria")
    private int IDCategoria;
    @Column(name = "Descricao")
    private String Descricao;

    public Categoria(int IDCategoria, String Descricao) {
        this.IDCategoria = IDCategoria;
        this.Descricao = Descricao;
    }

    public Categoria() {
    }

    public int getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(int IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

}
