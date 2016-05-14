/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "kehadiran")
public class Kehadiran implements Serializable {

    @Id
    @Column(name = "idKehadiran")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private int idKehadiran;

    @Column(name = "presensi", nullable = false)
    private int presensi;

    @Column(name = "presensiTotal", nullable = false)
    private int presensiTotal;

    @Column(name = "idDosen", nullable = false, length = 5, unique = true)
    private String idDosen;

    @Column(name = "namaDosen", nullable = false, length = 40)
    private String namaDosen;

    @Column(name = "status", nullable = false, length = 150)
    private String status;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = KehadiranMahasiswa.class, mappedBy = "kehadiran")
    private List<KehadiranMahasiswa> kehadiranMahasiswaList;

    @ManyToOne
    @JoinColumn(name = "idJadwal")
    private Jadwal jadwal;

    public Kehadiran() {
    }

    public Kehadiran(int idKehadiran, int presensi, int presensiTotal, String idDosen, String namaDosen, String status, List<KehadiranMahasiswa> kehadiranMahasiswaList, Jadwal jadwal) {
        this.idKehadiran = idKehadiran;
        this.presensi = presensi;
        this.presensiTotal = presensiTotal;
        this.idDosen = idDosen;
        this.namaDosen = namaDosen;
        this.status = status;
        this.kehadiranMahasiswaList = kehadiranMahasiswaList;
        this.jadwal = jadwal;
    }

    public int getIdKehadiran() {
        return idKehadiran;
    }

    public void setIdKehadiran(int idKehadiran) {
        this.idKehadiran = idKehadiran;
    }

    public int getPresensi() {
        return presensi;
    }

    public void setPresensi(int presensi) {
        this.presensi = presensi;
    }

    public int getPresensiTotal() {
        return presensiTotal;
    }

    public void setPresensiTotal(int presensiTotal) {
        this.presensiTotal = presensiTotal;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonManagedReference
    public List<KehadiranMahasiswa> getKehadiranMahasiswaList() {
        return kehadiranMahasiswaList;
    }

    public void setKehadiranMahasiswaList(List<KehadiranMahasiswa> kehadiranMahasiswaList) {
        this.kehadiranMahasiswaList = kehadiranMahasiswaList;
    }

    @JsonBackReference
    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

}
