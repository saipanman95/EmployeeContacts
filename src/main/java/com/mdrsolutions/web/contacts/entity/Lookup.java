/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdrsolutions.web.contacts.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author michael
 */
@Entity
@Table(catalog = "CONTACTS", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lookup.findAll", query = "SELECT l FROM Lookup l"),
    @NamedQuery(name = "Lookup.findByLookupId", query = "SELECT l FROM Lookup l WHERE l.lookupId = :lookupId"),
    @NamedQuery(name = "Lookup.findByCode", query = "SELECT l FROM Lookup l WHERE l.code = :code"),
    @NamedQuery(name = "Lookup.findByShortDesc", query = "SELECT l FROM Lookup l WHERE l.shortDesc = :shortDesc"),
    @NamedQuery(name = "Lookup.findByLongDesc", query = "SELECT l FROM Lookup l WHERE l.longDesc = :longDesc"),
    @NamedQuery(name = "Lookup.findByModuleCd", query = "SELECT l FROM Lookup l WHERE l.moduleCd = :moduleCd")})
public class Lookup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOOKUP_ID", nullable = false)
    private Integer lookupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(nullable = false, length = 6)
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "SHORT_DESC", nullable = false, length = 25)
    private String shortDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LONG_DESC", nullable = false, length = 100)
    private String longDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MODULE_CD", nullable = false, length = 6)
    private String moduleCd;

    public Lookup() {
    }

    public Lookup(Integer lookupId) {
        this.lookupId = lookupId;
    }

    public Lookup(Integer lookupId, String code, String shortDesc, String longDesc, String moduleCd) {
        this.lookupId = lookupId;
        this.code = code;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.moduleCd = moduleCd;
    }

    public Integer getLookupId() {
        return lookupId;
    }

    public void setLookupId(Integer lookupId) {
        this.lookupId = lookupId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getModuleCd() {
        return moduleCd;
    }

    public void setModuleCd(String moduleCd) {
        this.moduleCd = moduleCd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lookupId != null ? lookupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lookup)) {
            return false;
        }
        Lookup other = (Lookup) object;
        if ((this.lookupId == null && other.lookupId != null) || (this.lookupId != null && !this.lookupId.equals(other.lookupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mdrsolutions.web.contacts.entity.Lookup[ lookupId=" + lookupId + " ]";
    }
    
}
