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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Denny
 */
@Entity
@Table(name = "tb_kehadiran")
public class Kehadiran implements Serializable {

    @Id
    @Column(name = "id_kehadiran")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idKehadiran;

    @Column(name = "presensi_mahasiswa", nullable = false)
    private int presensiMahasiswa;

    @Column(name = "presensi_dosen", nullable = false)
    private int presensiDosen;

    @Column(name = "status", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private Status status;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Dosen.class, mappedBy = "kehadiran")
    private List<Dosen> dosenList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Mahasiswa.class, mappedBy = "kehadiran")
    private List<Mahasiswa> mahasiswaList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Jadwal.class, mappedBy = "kehadiran")
    private List<Jadwal> jadwalList;

    public Kehadiran() {
    }

    public Kehadiran(int idKehadiran, int presensiMahasiswa, int presensiDosen, Status status,
            List<Dosen> dosenList, List<Mahasiswa> mahasiswaList, List<Jadwal> jadwalList) {
        this.idKehadiran = idKehadiran;
        this.presensiMahasiswa = presensiMahasiswa;
        this.presensiDosen = presensiDosen;
        this.status = status;
        this.dosenList = dosenList;
        this.mahasiswaList = mahasiswaList;
        this.jadwalList = jadwalList;
    }

    public int getIdKehadiran() {
        return idKehadiran;
    }

    public void setIdKehadiran(int idKehadiran) {
        this.idKehadiran = idKehadiran;
    }

    public int getPresensiMahasiswa() {
        return presensiMahasiswa;
    }

    public void setPresensiMahasiswa(int presensiMahasiswa) {
        this.presensiMahasiswa = presensiMahasiswa;
    }

    public int getPresensiDosen() {
        return presensiDosen;
    }

    public void setPresensiDosen(int presensiDosen) {
        this.presensiDosen = presensiDosen;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonManagedReference
    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    @JsonManagedReference
    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    @JsonManagedReference
    public List<Jadwal> getJadwalList() {
        return jadwalList;
    }

    public void setJadwalList(List<Jadwal> jadwalList) {
        this.jadwalList = jadwalList;
    }

    public enum Status {
        Hadir, TidakHadir
    }

}
