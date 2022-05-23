/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

import java.util.Date;
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
@Table (name = "TB_Movimento")
public class Movimento {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMovimento")
    private int IDMovimento;
    @ManyToOne
    @JoinColumn(name = "IDUsuario")
    private Usuario usuario;
    @Column(name = "DataMovimento")
    private Date DataMovimento;
    @Column(name = "Tipo")
    private String Tipo;
    @Column(name = "Descricao")
    private String Descricao;
    @Column(name = "Valor")
    private Double Valor;

    public Movimento(int IDMovimento, Usuario usuario, Date DataMovimento, String Tipo, String Descricao, Double Valor) {
        this.IDMovimento = IDMovimento;
        this.usuario = usuario;
        this.DataMovimento = DataMovimento;
        this.Tipo = Tipo;
        this.Descricao = Descricao;
        this.Valor = Valor;
    }

    public Movimento() {
    }

    public int getIDMovimento() {
        return IDMovimento;
    }

    public void setIDMovimento(int IDMovimento) {
        this.IDMovimento = IDMovimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataMovimento() {
        return DataMovimento;
    }

    public void setDataMovimento(Date DataMovimento) {
        this.DataMovimento = DataMovimento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Double getValor() {
        return Valor;
    }

    public void setValor(Double Valor) {
        this.Valor = Valor;
    }

}
