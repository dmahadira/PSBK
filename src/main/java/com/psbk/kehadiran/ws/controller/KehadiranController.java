/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psbk.kehadiran.ws.controller;

import com.psbk.kehadiran.ws.domain.Kehadiran;
import com.psbk.kehadiran.ws.service.KehadiranService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/kehadiran", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Kehadiran> getKehadirans() {
        return kehadiranService.getKehadirans();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/kehadiran", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> save(@RequestBody Kehadiran kehadiran) {
        kehadiranService.save(kehadiran);

        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Tersimpan");

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> update(@RequestBody Kehadiran kehadiran) {
        kehadiranService.update(kehadiran);

        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Berhasil di update");

        return m;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/kehadiran/{idKehadiran}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> delete(@PathVariable("idKehadiran") String idKehadiran) {
        kehadiranService.delete(kehadiranService.getKehadiran(idKehadiran));

        Map<String, Object> m = new HashMap<>();
        m.put("Success", Boolean.TRUE);
        m.put("Info", "Data Berhasil di hapus");

        return m;
    }

}
