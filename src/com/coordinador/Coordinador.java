package com.coordinador;

import com.coordinador.equipo.Equipo;
import com.coordinador.equipo.EquipoDaoImpl;
import com.coordinador.horacentral.HoraCentral;
import com.coordinador.horacentral.HoraCentralDaoImpl;
import com.coordinador.horaequipo.HoraEquipo;
import com.coordinador.horaequipo.HoraEquipoDaoImpl;

public class Coordinador {
    public static void main(String[] args) {
        HoraCentralDaoImpl horaCentralDao = new HoraCentralDaoImpl();
        HoraCentral hora = new HoraCentral();
        horaCentralDao.insert(hora);

        EquipoDaoImpl equipoDao = new EquipoDaoImpl();
        Equipo equipo = new Equipo();
        equipoDao.insert(equipo);

        HoraEquipoDaoImpl horaEquipoDao = new HoraEquipoDaoImpl();
        HoraEquipo horaEquipo = new HoraEquipo();
        horaEquipo.setIdEquipo(equipo.getId());
        horaEquipo.setIdHUTC(hora.getId());
        horaEquipo.sethEquipo("HORA MAL");
        horaEquipo.setaEquipo("SABE QUE ES");
        horaEquipo.setRalentizar(231212);
        horaEquipoDao.insert(horaEquipo);

        // Iniciamos el servidor Multicast
        MulticastServer server = new MulticastServer(8888, "224.0.0.4");
        server.run();
    }
}
