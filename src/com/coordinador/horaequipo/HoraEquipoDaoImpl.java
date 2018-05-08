package com.coordinador.horaequipo;

import com.coordinador.equipo.Equipo;
import com.coordinador.horacentral.HoraCentral;
import com.utils.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoraEquipoDaoImpl extends DBConnector implements HoraEquipoDao {
    private static final String INSERT = "INSERT INTO horaequipos(IDhUTC, IDEquipo, hEquipo, aEquipo, ralentizar) VALUES(?, ?, ?, ?, ?)";


    public int insert(HoraEquipo horaEquipo) {
        try {
            openDBConnection();
            preparedStmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setInt(1, horaEquipo.getIdHUTC());
            preparedStmt.setInt(2, horaEquipo.getIdEquipo());
            preparedStmt.setString(3, horaEquipo.gethEquipo());
            preparedStmt.setString(4, horaEquipo.getaEquipo());
            preparedStmt.setFloat(5, horaEquipo.getRalentizar());

            int result = preparedStmt.executeUpdate();
            ResultSet rs = preparedStmt.getGeneratedKeys();


            if (rs.next()) {
                horaEquipo.setId(rs.getInt(1));
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }
}
