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
@Table(name = "tb_jadwal")
public class Jadwal implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "kode_matakuliah", nullable = false, length = 8, unique = true)
    private String kodeMatakuliah;

    @Column(name = "nama_matakuliah", nullable = false, length = 40)
    private String namaMatakuliah;

    @Column(name = "kelas", nullable = false, length = 1)
    private char kelas;

    @Column(name = "sks", nullable = false)
    private int sks;

    @ManyToOne
    @JoinColumn(name = "id_kehadiran")
    private Kehadiran kehadiran;

    public Jadwal() {
    }

    public Jadwal(int id, String kodeMatakuliah, String namaMatakuliah, char kelas, int sks, Kehadiran kehadiran) {
        this.id = id;
        this.kodeMatakuliah = kodeMatakuliah;
        this.namaMatakuliah = namaMatakuliah;
        this.kelas = kelas;
        this.sks = sks;
        this.kehadiran = kehadiran;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeMatakuliah() {
        return kodeMatakuliah;
    }

    public void setKodeMatakuliah(String kode_matakuliah) {
        this.kodeMatakuliah = kodeMatakuliah;
    }

    public String getNamaMatakuliah() {
        return namaMatakuliah;
    }

    public void setNamaMatakuliah(String namaMatakuliah) {
        this.namaMatakuliah = namaMatakuliah;
    }

    public char getKelas() {
        return kelas;
    }

    public void setKelas(char kelas) {
        this.kelas = kelas;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    @JsonBackReference
    public Kehadiran getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(Kehadiran kehadiran) {
        this.kehadiran = kehadiran;
    }

}
