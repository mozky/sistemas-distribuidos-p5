package com.coordinador.horacentral;

import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class HoraCentral implements Serializable {
    private int id;
    private String hUTC;
    private String hLocal;

    public HoraCentral() {
        Instant instant = Instant.now();
        OffsetDateTime utcTime = instant.atOffset(ZoneOffset.UTC);
        ZonedDateTime localTime = instant.atZone(ZoneId.of("America/Mexico_City"));

        this.sethUTC(utcTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        this.sethLocal(localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gethUTC() {
        return hUTC;
    }

    public void sethUTC(String hUTC) {
        this.hUTC = hUTC;
    }

    public String gethLocal() {
        return hLocal;
    }

    public void sethLocal(String hLocal) {
        this.hLocal = hLocal;
    }
}
