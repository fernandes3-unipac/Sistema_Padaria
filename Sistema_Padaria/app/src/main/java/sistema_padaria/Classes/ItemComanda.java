/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

import javax.persistence.CascadeType;
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
@Table(name = "TB_Item_Comanda")
public class ItemComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDItemComanda")
    private int IDItemComanda;
    @ManyToOne
    @JoinColumn(name = "IDProduto")
    private Produtos produto;
    @Column(name = "Quantidade")
    private Double Quantidade;
    @Column(name = "ValorUnitario")
    private Double ValorUnitario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDComanda")
    private Comanda comanda;

    public ItemComanda(int IDItemComanda, Produtos produto, Double Quantidade, Double ValorUnitario, Comanda comanda) {
        this.IDItemComanda = IDItemComanda;
        this.produto = produto;
        this.Quantidade = Quantidade;
        this.ValorUnitario = ValorUnitario;
        this.comanda = comanda;
    }

    public ItemComanda() {
    }

    public int getIDItemComanda() {
        return IDItemComanda;
    }

    public void setIDItemComanda(int IDItemComanda) {
        this.IDItemComanda = IDItemComanda;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Double Quantidade) {
        this.Quantidade = Quantidade;
    }

    public Double getValorUnitario() {
        return ValorUnitario;
    }

    public void setValorUnitario(Double ValorUnitario) {
        this.ValorUnitario = ValorUnitario;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

}
