/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Denny
 */
@Entity
@Table(name = "tb_kehadiran")
public class Kehadiran implements Serializable {

    @Id
    @Column(name = "id_kehadiran", length =3)
    private String idKehadiran;

    @Column(name = "presensi_mahasiswa", nullable= false)
    private int presensiMahasiswa;

    @Column(name = "presensi_dosen", nullable= false)
    private int presensiDosen;

    @Column(name = "status", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private String status;

    @Column(name = "nrp", nullable = false, length = 15)
    private String nrp;

    @Column(name = "nama_mahasiswa", nullable = false, length = 40)
    private String namaMahasiswa;

    @Column(name = "id_dosen", nullable = false, length = 15)
    private String idDosen;

    @Column(name = "nama_dosen", nullable = false, length = 40)
    private String namaDosen;

    @Column(name = "kode_matakuliah", nullable = false, length = 8)
    private String kodeMatakuliah;

    @Column(name = "nama_matakuliah", nullable = false, length = 40)
    private String namaMatakuliah;

    @Column(name = "sks", nullable = false)
    private int sks;

    public Kehadiran() {
    }

    public Kehadiran(String idKehadiran, int presensiMahasiswa, int presensiDosen, String status,
            String nrp, String namaMahasiswa, String idDosen, String namaDosen,
            String kodeMatakuliah, String namaMatakuliah, int sks) {
        this.idKehadiran = idKehadiran;
        this.presensiMahasiswa = presensiMahasiswa;
        this.presensiDosen = presensiDosen;
        this.status = status;
        this.nrp = nrp;
        this.namaMahasiswa = namaMahasiswa;
        this.idDosen = idDosen;
        this.namaDosen = namaDosen;
        this.kodeMatakuliah = kodeMatakuliah;
        this.namaMatakuliah = namaMatakuliah;
        this.sks = sks;
    }
    
    public String getIdKehadiran() {
        return idKehadiran;
    }

    public void setIdKehadiran(String idKehadiran) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
    
    public enum status {
        Hadir, TidakHadir
    }
    
    @Override
    public String toString() {
        return "ID Kehadiran : " + idKehadiran
                + " Presensi Mahasiswa : " + presensiMahasiswa
                + " Presensi Dosen : " + presensiDosen
                + " Status : " + status
                + " NRP : " + nrp
                + " Nama Mahasiswa : " + namaMahasiswa
                + " ID Dosen : " + idDosen
                + " Nama Dosen : " + namaDosen
                + " Kode Matakuliah : " + presensiDosen
                + " Nama Matakuliah : " + status
                + " SKS : " + sks;
    }
}
