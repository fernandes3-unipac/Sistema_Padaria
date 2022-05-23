/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "TB_Comanda")
public class Comanda implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDComanda")
    private int IDComanda;
    @OneToMany (mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<ItemComanda> Iten= new ArrayList<ItemComanda>();
    @Column(name =  "DataComanda")
    private Date DataComanda;

    public Comanda(int IDComanda, ArrayList<ItemComanda> ItensComanda, Date DataComanda) {
        this.IDComanda = IDComanda;
        this.Iten = ItensComanda;
        this.DataComanda = DataComanda;
    }

    public Comanda() {
    }

    public Comanda(int idComanda, Date DataComanda) {
        this.IDComanda = idComanda;
        this.DataComanda = DataComanda;
    }

    public int getIDComanda() {
        return IDComanda;
    }

    public void setIDComanda(int IDComanda) {
        this.IDComanda = IDComanda;
    }

    public List<ItemComanda> getItensComanda() {
        return Iten;
    }

    public void setItensComanda(ArrayList<ItemComanda> ItensComanda) {
        this.Iten = ItensComanda;
    }

    public Date getDataComanda() {
        return DataComanda;
    }

    public void setDataComanda(Date DataComanda) {
        this.DataComanda = DataComanda;
    }

    public void addListComanda(ItemComanda item) {
        this.Iten.add(item);
    }

}
