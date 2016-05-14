/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.repository;

import com.psbk.kehadiran.ws.domain.Jadwal;
import com.psbk.kehadiran.ws.domain.Kehadiran;
import com.psbk.kehadiran.ws.domain.KehadiranMahasiswa;
import com.psbk.kehadiran.ws.domain.Matakuliah;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

//    @Override
//    public List<Jadwal> getJadwal(String kodeMatakuliah) {
//        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Jadwal.class)
//                .setProjection(Projections.projectionList()
//                        .add(Projections.property("kodeMatakuliah"), "kodeMatakuliah")
//                        .add(Projections.property("namaMatakuliah"), "namaMatakuliah")
//                        .add(Projections.property("kelas"), "kelas"))
//                .add(Restrictions.eq("kodeMatakuliah", kodeMatakuliah));
//
//        List<Jadwal> jadwalList = cr.list();
//        return jadwalList;
//    }
//
    @Override
    public double getPersentase(int idKehadiran) {
        Kehadiran kehadiran = sessionFactory.getCurrentSession().get(Kehadiran.class, idKehadiran);
        int presensi = kehadiran.getPresensi();
        int presensiTotal = kehadiran.getPresensiTotal();

        double persentase = ((double) presensi / (double) presensiTotal) * 100;

        return persentase;
    }

    @Override
    public List<KehadiranMahasiswa> presensiMatkul() {
        String hql = "select m.namaMatakuliah from Matakuliah m inner join KehadiranMahasiswa km on m.idMatakuliah = km.matakuliah";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<KehadiranMahasiswa> kehadiranMahasiswaList = query.list();
        

        return kehadiranMahasiswaList;
    }
}
