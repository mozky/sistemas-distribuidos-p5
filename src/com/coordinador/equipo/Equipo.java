package com.coordinador.equipo;

import java.io.Serializable;

public class Equipo implements Serializable {
    private int id;
    private String ip;
    private String nombre;
    private float latencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getLatencia() {
        return latencia;
    }

    public void setLatencia(float latencia) {
        this.latencia = latencia;
    }
}
