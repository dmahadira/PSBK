/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.repository;

import com.psbk.kehadiran.ws.domain.Dosen;
import com.psbk.kehadiran.ws.domain.Jadwal;
import com.psbk.kehadiran.ws.domain.Kehadiran;
import com.psbk.kehadiran.ws.domain.Mahasiswa;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denny
 */
@Repository
public class KehadiranRepositoryImpl implements KehadiranRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Kehadiran kehadiran) {
        sessionFactory.getCurrentSession().save(kehadiran);
    }

    @Override
    public void update(Kehadiran kehadiran) {
        sessionFactory.getCurrentSession().update(kehadiran);
    }

    @Override
    public void delete(Kehadiran kehadiran) {
        sessionFactory.getCurrentSession().delete(kehadiran);
    }

    @Override
    public Kehadiran getKehadiran(int idKehadiran) {
        return sessionFactory.getCurrentSession().get(Kehadiran.class, idKehadiran);
    }

    @Override
    public List<Kehadiran> getKehadirans() {
        return sessionFactory.getCurrentSession().createCriteria(Kehadiran.class).list();
    }

    @Override
    public double getPersentase(int idKehadiran) {
        Kehadiran kehadiran = sessionFactory.getCurrentSession().get(Kehadiran.class, idKehadiran);
        int presensiMahasiswa = kehadiran.getPresensiMahasiswa();
        int presensiDosen = kehadiran.getPresensiDosen();

        double persentase = ((double) presensiMahasiswa / (double) presensiDosen) * 100;

        return persentase;
    }

    @Override
    public List<Dosen> getDosen(String idDosen) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Dosen.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("idDosen"), "idDosen")
                        .add(Projections.property("namaDosen"), "namaDosen"))
                .add(Restrictions.eq("idDosen", idDosen));

        List<Dosen> dosenList = cr.list();
        return dosenList;
    }

    @Override
    public List<Mahasiswa> getMahasiswa(String nrp) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Jadwal.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("nrp"), "nrp")
                        .add(Projections.property("namaMahasiswa"), "namaMahasiswa"))
                .add(Restrictions.eq("nrp", nrp));

        List<Mahasiswa> mahasiswaList = cr.list();
        return mahasiswaList;
    }

    @Override
    public List<Jadwal> getJadwal(String kodeMatakuliah) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Jadwal.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("kodeMatakuliah"), "kodeMatakuliah")
                        .add(Projections.property("namaMatakuliah"), "namaMatakuliah")
                        .add(Projections.property("kelas"), "kelas"))
                .add(Restrictions.eq("kodeMatakuliah", kodeMatakuliah));

        List<Jadwal> jadwalList = cr.list();
        return jadwalList;
    }
}
