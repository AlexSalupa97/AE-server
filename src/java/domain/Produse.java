/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexsalupa97
 */
@Entity
@Table(name = "PRODUSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produse.findAll", query = "SELECT p FROM Produse p")
    , @NamedQuery(name = "Produse.findById", query = "SELECT p FROM Produse p WHERE p.id = :id")
    , @NamedQuery(name = "Produse.findByNume", query = "SELECT p FROM Produse p WHERE p.nume = :nume")
    , @NamedQuery(name = "Produse.findByPret", query = "SELECT p FROM Produse p WHERE p.pret = :pret")
    , @NamedQuery(name = "Produse.findByCantitate", query = "SELECT p FROM Produse p WHERE p.cantitate = :cantitate")
    , @NamedQuery(name = "Produse.findByDescriere", query = "SELECT p FROM Produse p WHERE p.descriere = :descriere")})
public class Produse implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NUME")
    private String nume;
    @Column(name = "PRET")
    private BigInteger pret;
    @Column(name = "CANTITATE")
    private BigInteger cantitate;
    @Size(max = 200)
    @Column(name = "DESCRIERE")
    private String descriere;

    public Produse() {
    }

    public Produse(BigDecimal id) {
        this.id = id;
    }

    public Produse(BigDecimal id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public BigInteger getPret() {
        return pret;
    }

    public void setPret(BigInteger pret) {
        this.pret = pret;
    }

    public BigInteger getCantitate() {
        return cantitate;
    }

    public void setCantitate(BigInteger cantitate) {
        this.cantitate = cantitate;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produse)) {
            return false;
        }
        Produse other = (Produse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Produse[ id=" + id + " ]";
    }
    
}
