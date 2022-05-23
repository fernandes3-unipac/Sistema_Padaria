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
@Table(name = "TB_UnidadeMedida")
public class UnidadeMedida {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column (name = "IDUnidadeMedida")
private int IDUnidadeMedida;
@Column(name = "Descricao")
private String Descricao;

    public UnidadeMedida(int IDUnidadeMedida, String Descricao) {
        this.IDUnidadeMedida = IDUnidadeMedida;
        this.Descricao = Descricao;
    }

    public UnidadeMedida() {
    }

    public int getIDUnidadeMedida() {
        return IDUnidadeMedida;
    }

    public void setIDUnidadeMedida(int IDUnidadeMedida) {
        this.IDUnidadeMedida = IDUnidadeMedida;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

}
