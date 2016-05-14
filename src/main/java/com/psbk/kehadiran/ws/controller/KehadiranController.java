/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.controller;

import com.psbk.kehadiran.ws.domain.Jadwal;
import com.psbk.kehadiran.ws.domain.Kehadiran;
import com.psbk.kehadiran.ws.domain.KehadiranMahasiswa;
import com.psbk.kehadiran.ws.domain.Matakuliah;
import com.psbk.kehadiran.ws.service.KehadiranService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.core.convert.TypeDescriptor.array;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denny
 */
@RestController
@RequestMapping(value = "/api")
public class KehadiranController {

    @Autowired
    private KehadiranService kehadiranService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran/id={idKehadiran}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> getKehadiran(@PathVariable("idKehadiran") int idKehadiran) {
        Map<String, Object> m = new HashMap<>();

        try {
            Kehadiran kehadiran = kehadiranService.getKehadiran(idKehadiran);

            m.put("Status", Boolean.TRUE);
            m.put("Result", kehadiran);
        } catch (Exception e) {
            m.put("Message", "Gagal Karena : " + e.getMessage());
        }

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> getKehadirans() {
        Map<String, Object> m = new HashMap<>();

        try {
            List<Kehadiran> kehadiranList = kehadiranService.getKehadirans();

            m.put("Status", Boolean.TRUE);
            m.put("Result", kehadiranList);
        } catch (Exception e) {
            m.put("Message", "Gagal Karena : " + e.getMessage());
        }

        return m;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/kehadiran/insert", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> save(@RequestBody Kehadiran kehadiran) {
        Map<String, Object> m = new HashMap<>();

        try {
            kehadiranService.save(kehadiran);

            m.put("Status", Boolean.TRUE);
            m.put("Message", "Data Berhasil di simpan");
        } catch (Exception e) {
            m.put("Message", "Gagal Karena : " + e.getMessage());
        }

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran/update", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> update(@RequestBody Kehadiran kehadiran) {
        Map<String, Object> m = new HashMap<>();

        try {
            kehadiranService.update(kehadiran);

            m.put("Status", Boolean.TRUE);
            m.put("Message", "Data Berhasil di update");
        } catch (Exception e) {
            m.put("Message", "Gagal Karena : " + e.getMessage());
        }

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran/delete/id={idKehadiran}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> delete(@PathVariable("idKehadiran") int idKehadiran) {
        Map<String, Object> m = new HashMap<>();

        try {
            kehadiranService.delete(kehadiranService.getKehadiran(idKehadiran));

            m.put("Status", Boolean.TRUE);
            m.put("Message", "Data Berhasil di hapus");
        } catch (Exception e) {
            m.put("Message", "Gagal Karena : " + e.getMessage());
        }

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran/presensi", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> presensiMatkul() {
        Map<String, Object> m = new HashMap<>();

        try {
            List<KehadiranMahasiswa> kehadiranMahasiswaList = kehadiranService.presensiMatkul();

            m.put("Status", Boolean.TRUE);
            m.put("Matakuliah", kehadiranMahasiswaList);

        } catch (Exception e) {
            m.put("Message", "Gagal Karena : " + e.getMessage());
        }

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran/presensi/id={idKehadiran}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> getPersentase(@PathVariable("idKehadiran") int idKehadiran) {
        Map<String, Object> m = new HashMap<>();

        try {
            double persentase = kehadiranService.getPersentase(idKehadiran);

            m.put("Status", Boolean.TRUE);
            m.put("Persentase", persentase);

        } catch (Exception e) {
            m.put("Message", "Gagal Karena : " + e.getMessage());
        }

        return m;
    }
}
