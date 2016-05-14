/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Denny
 */
@Entity
@Table(name = "kehadiran_mahasiswa")
public class KehadiranMahasiswa implements Serializable {

    @Id
    @Column(name = "idKehadiranMahasiswa")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private int idKehadiranMahasiswa;

    @Column(name = "nrp", nullable = false, length = 9, unique = true)
    private String nrp;

    @Column(name = "namaMahasiswa", nullable = false, length = 40)
    private String namaMahasiswa;

    @ManyToOne
    @JoinColumn(name = "idKehadiran")
    private Kehadiran kehadiran;

    @ManyToOne
    @JoinColumn(name = "idMatakuliah")
    private Matakuliah matakuliah;

    public KehadiranMahasiswa() {
    }

    public KehadiranMahasiswa(int idKehadiranMahasiswa, String nrp, String namaMahasiswa, Kehadiran kehadiran, Matakuliah matakuliah) {
        this.idKehadiranMahasiswa = idKehadiranMahasiswa;
        this.nrp = nrp;
        this.namaMahasiswa = namaMahasiswa;
        this.kehadiran = kehadiran;
        this.matakuliah = matakuliah;
    }

    public int getIdKehadiranMahasiswa() {
        return idKehadiranMahasiswa;
    }

    public void setIdKehadiranMahasiswa(int idKehadiranMahasiswa) {
        this.idKehadiranMahasiswa = idKehadiranMahasiswa;
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

    @JsonBackReference
    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

}
