/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Denny
 */
@Entity
@Table(name = "jadwal")
public class Jadwal implements Serializable {

    @Id
    @Column(name = "idJadwal")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private int idJadwal;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "hari", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hari;

    @Column(name = "kelas", nullable = false, length = 1)
    private char kelas;

    @Column(name = "ruang", nullable = false, length = 5)
    private String ruang;

    @ManyToOne
    @JoinColumn(name = "idMatakuliah")
    private Matakuliah matakuliah;

    public Jadwal() {
    }

    public Jadwal(int idJadwal, Date hari, char kelas, String ruang, List<Kehadiran> kehadiranList, Matakuliah matakuliah) {
        this.idJadwal = idJadwal;
        this.hari = hari;
        this.kelas = kelas;
        this.ruang = ruang;
        this.matakuliah = matakuliah;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    public Date getHari() {
        return hari;
    }

    public void setHari(Date hari) {
        this.hari = hari;
    }

    public char getKelas() {
        return kelas;
    }

    public void setKelas(char kelas) {
        this.kelas = kelas;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    @JsonBackReference
    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

}
