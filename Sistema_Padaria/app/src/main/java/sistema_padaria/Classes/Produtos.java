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
@Table(name = "TB_Produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDProduto")
    private int IDProduto;
    @ManyToOne
    @JoinColumn(name = "IDCategoria")
    private Categoria Categoria;
    @ManyToOne
    @JoinColumn(name = "IDUnidadeMedida")
    private UnidadeMedida UnidadeMedida;
    @Column(name = "Descricao")
    private String Descricao;
    @Column(name = "CodigoDeBarras")
    private String CodigoDeBarras;
    @Column(name = "Quantidade")
    private Double Quantidade;
    @Column(name = "QuantidadeMinima")
    private Double QuantidadeMinima;
    @Column(name = "ValorUnitario")
    private Double ValorUnitario;

    public Produtos(int IDProduto, Categoria Categoria, UnidadeMedida UnidadeMedida, String Descricao, String CodigoDeBarras, Double Quantidade, Double QuantidadeMinima, Double ValorUnitario) {
        this.IDProduto = IDProduto;
        this.Categoria = Categoria;
        this.UnidadeMedida = UnidadeMedida;
        this.Descricao = Descricao;
        this.CodigoDeBarras = CodigoDeBarras;
        this.Quantidade = Quantidade;
        this.QuantidadeMinima = QuantidadeMinima;
        this.ValorUnitario = ValorUnitario;
    }

    public Produtos() {
    }

    public int getIDProduto() {
        return IDProduto;
    }

    public void setIDProduto(int IDProduto) {
        this.IDProduto = IDProduto;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public UnidadeMedida getUnidadeMedida() {
        return UnidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida UnidadeMedida) {
        this.UnidadeMedida = UnidadeMedida;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getCodigoDeBarras() {
        return CodigoDeBarras;
    }

    public void setCodigoDeBarras(String CodigoDeBarras) {
        this.CodigoDeBarras = CodigoDeBarras;
    }

    public Double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Double Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Double getQuantidadeMinima() {
        return QuantidadeMinima;
    }

    public void setQuantidadeMinima(Double QuantidadeMinima) {
        this.QuantidadeMinima = QuantidadeMinima;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

}
