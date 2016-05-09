/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.repository;

import com.psbk.kehadiran.ws.domain.Kehadiran;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
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
//        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Kehadiran.class)
//                .setProjection(Projections.projectionList()
//                    .add(Projections.property("idKehadiran"), "id_kehadiran")
//                    .add(Projections.property("kodeMatakuliah"), "kode_matakuliah")
//                    .add(Projections.property("namaMatakuliah"), "nama_matakuliah")
//                    .add(Projections.property("kelas"), "kelas")
//                    .add(Projections.property("presensiMahasiswa"), "presensi_mahasiswa")
//                    .add(Projections.property("presensiDosen"), "presensi_dosen"))
//                .setResultTransformer(Transformers.aliasToBean(Kehadiran.class));
//        
//        List<Kehadiran> kehadiranList = cr.list();
//        return kehadiranList;
        return sessionFactory.getCurrentSession().createCriteria(Kehadiran.class).list();
    }

}
