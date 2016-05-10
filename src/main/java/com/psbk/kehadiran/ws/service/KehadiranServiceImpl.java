/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.service;

import com.psbk.kehadiran.ws.domain.Kehadiran;
import com.psbk.kehadiran.ws.repository.KehadiranRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denny
 */

@Service
@Transactional(readOnly =true)
public class KehadiranServiceImpl implements KehadiranService {

    @Autowired
    private KehadiranRepository kehadiranRepository;

    @Transactional
    @Override
    public void save(Kehadiran kehadiran) {
        kehadiranRepository.save(kehadiran);
    }

    @Transactional
    @Override
    public void update(Kehadiran kehadiran) {
        kehadiranRepository.update(kehadiran);
    }

    @Transactional
    @Override
    public void delete(Kehadiran kehadiran) {
        kehadiranRepository.delete(kehadiran);
    }

    @Override
    public Kehadiran getKehadiran(int idKehadiran) {
        return kehadiranRepository.getKehadiran(idKehadiran);
    }

    @Override
    public List<Kehadiran> getKehadirans() {
        return kehadiranRepository.getKehadirans();
    }
    
    @Override
    public double getPersentase(int idKehadiran){
        return kehadiranRepository.getPersentase(idKehadiran);
    }

}
