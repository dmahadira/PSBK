/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "mata_kuliah")
public class Matakuliah implements Serializable {

    @Id
    @Column(name = "idMatakuliah")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private int idMatakuliah;

    @Column(name = "kodeMatakuliah", nullable = false, length = 5, unique = true)
    private String kodeMatakuliah;

    @Column(name = "namaMatakuliah", nullable = false, length = 40)
    private String namaMatakuliah;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Jadwal.class, mappedBy = "matakuliah")
    private List<Jadwal> jadwalList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = KehadiranMahasiswa.class, mappedBy = "matakuliah")
    private List<KehadiranMahasiswa> kehadiranMahasiswaList;

    public Matakuliah() {
    }

    public Matakuliah(int idMatakuliah, String kodeMatakuliah, String namaMatakuliah, List<Jadwal> jadwalList, List<KehadiranMahasiswa> kehadiranMahasiswasList) {
        this.idMatakuliah = idMatakuliah;
        this.kodeMatakuliah = kodeMatakuliah;
        this.namaMatakuliah = namaMatakuliah;
        this.jadwalList = jadwalList;
        this.kehadiranMahasiswaList = kehadiranMahasiswasList;
    }

    public int getIdMatakuliah() {
        return idMatakuliah;
    }

    public void setIdMatakuliah(int idMatakuliah) {
        this.idMatakuliah = idMatakuliah;
    }

    public String getKodeMatakuliah() {
        return kodeMatakuliah;
    }

    public void setKodeMatakuliah(String kodeMatakuliah) {
        this.kodeMatakuliah = kodeMatakuliah;
    }

    public String getNamaMatakuliah() {
        return namaMatakuliah;
    }

    public void setNamaMatakuliah(String namaMatakuliah) {
        this.namaMatakuliah = namaMatakuliah;
    }

    @JsonManagedReference
    public List<Jadwal> getJadwalList() {
        return jadwalList;
    }

    public void setJadwalList(List<Jadwal> jadwalList) {
        this.jadwalList = jadwalList;
    }

    @JsonManagedReference
    public List<KehadiranMahasiswa> getKehadiranMahasiswaList() {
        return kehadiranMahasiswaList;
    }

    public void setKehadiranMahasiswaList(List<KehadiranMahasiswa> kehadiranMahasiswaList) {
        this.kehadiranMahasiswaList = kehadiranMahasiswaList;
    }

}
