package com.coordinador.horaequipo;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class HoraEquipo implements Serializable {
    private int id;
    private int idHUTC;
    private int idEquipo;
    private String hEquipo;
    private String aEquipo;
    private float ralentizar;

    public int getIdHUTC() {
        return idHUTC;
    }

    public void setIdHUTC(int idHUTC) {
        this.idHUTC = idHUTC;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String gethEquipo() {
        return hEquipo;
    }

    public void sethEquipo(String hEquipo) {
        this.hEquipo = hEquipo;
    }

    public String getaEquipo() {
        return aEquipo;
    }

    public void setaEquipo(String aEquipo) {
        this.aEquipo = aEquipo;
    }

    public float getRalentizar() {
        return ralentizar;
    }

    public void setRalentizar(float ralentizar) {
        this.ralentizar = ralentizar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
