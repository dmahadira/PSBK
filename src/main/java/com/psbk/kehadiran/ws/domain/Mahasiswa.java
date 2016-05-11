/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
 * @author Denny
 */
@Entity
@Table(name = "tb_mahasiswa")
public class Mahasiswa implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nrp", nullable = false, length = 15, unique = true)
    private String nrp;

    @Column(name = "nama_mahasiswa", nullable = false, length = 40)
    private String namaMahasiswa;

    @ManyToOne
    @JoinColumn(name = "id_kehadiran")
    private Kehadiran kehadiran;

    public Mahasiswa() {
    }

    public Mahasiswa(int id, String nrp, String namaMahasiswa, Kehadiran kehadiran) {
        this.id = id;
        this.nrp = nrp;
        this.namaMahasiswa = namaMahasiswa;
        this.kehadiran = kehadiran;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    @JsonBackReference
    public Kehadiran getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(Kehadiran kehadiran) {
        this.kehadiran = kehadiran;
    }

}
