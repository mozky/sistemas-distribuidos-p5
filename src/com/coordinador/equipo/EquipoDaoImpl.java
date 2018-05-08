package com.coordinador.equipo;

import com.utils.DBConnector;

import java.sql.*;

public class EquipoDaoImpl extends DBConnector implements EquipoDao {
    private static final String INSERT = "INSERT INTO equipos(IP, Nombre, Latencia) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE equipos SET IP=?, Nombre=?, Latencia=? WHERE ID=?";

    public int insert(Equipo equipo) {

        try {
            openDBConnection();
            preparedStmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, equipo.getIp());
            preparedStmt.setString(2, equipo.getNombre());
            preparedStmt.setFloat(3, equipo.getLatencia());

            int result = preparedStmt.executeUpdate();
            ResultSet rs = preparedStmt.getGeneratedKeys();

            if (rs.next()) {
                equipo.setId(rs.getInt(1));
            }

            return equipo.getId();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }

    public int update(Equipo equipo) {
        try {
            openDBConnection();
            preparedStmt = conn.prepareStatement(UPDATE);
            preparedStmt.setString(1, equipo.getIp());
            preparedStmt.setString(2, equipo.getNombre());
            preparedStmt.setFloat(3, equipo.getLatencia());
            preparedStmt.setInt(4, equipo.getId());

            return preparedStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }
}
