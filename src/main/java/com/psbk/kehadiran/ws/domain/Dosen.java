/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@Table(name = "tb_dosen")
public class Dosen implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_dosen", nullable = false, length = 15, unique = true)
    private String idDosen;

    @Column(name = "nama_dosen", nullable = false, length = 40)
    private String namaDosen;

    @ManyToOne
    @JoinColumn(name = "id_kehadiran")
    private Kehadiran kehadiran;

    public Dosen() {
    }

    public Dosen(int id, String idDosen, String namaDosen, Kehadiran kehadiran) {
        this.id = id;
        this.idDosen = idDosen;
        this.namaDosen = namaDosen;
        this.kehadiran = kehadiran;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    @JsonBackReference
    public Kehadiran getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(Kehadiran kehadiran) {
        this.kehadiran = kehadiran;
    }

}
