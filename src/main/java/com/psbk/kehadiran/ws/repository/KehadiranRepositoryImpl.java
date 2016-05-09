/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.repository;

import com.psbk.kehadiran.ws.domain.Kehadiran;
import java.util.List;
import org.hibernate.SessionFactory;
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

}
