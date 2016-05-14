/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.repository;

import com.psbk.kehadiran.ws.domain.Kehadiran;
import com.psbk.kehadiran.ws.domain.KehadiranMahasiswa;
import com.psbk.kehadiran.ws.domain.Matakuliah;
import java.util.List;

/**
 *
 * @author Denny
 */
public interface KehadiranRepository {

    public void save(Kehadiran kehadiran);

    public void update(Kehadiran kehadiran);

    public void delete(Kehadiran kehadiran);

    public Kehadiran getKehadiran(int idKehadiran);

    public List<Kehadiran> getKehadirans();
    
    public double getPersentase(int idKehadiran);

    public List<KehadiranMahasiswa> presensiMatkul();

//    public List<KehadiranMahasiswa> allPresensiMatkul();
}
