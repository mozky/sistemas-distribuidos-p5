package com.coordinador.horacentral;

import com.utils.DBConnector;

import java.sql.*;

public class HoraCentralDaoImpl extends DBConnector implements HoraCentralDao {
    private static final String INSERT = "INSERT INTO horacentral(hUTC, hLocal) VALUES(?, ?)";


    public int insert(HoraCentral horaCentral) {
        try {
            openDBConnection();
            preparedStmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStmt.setString(1, horaCentral.gethUTC());
            preparedStmt.setString(2, horaCentral.gethLocal());

            int result = preparedStmt.executeUpdate();
            ResultSet rs = preparedStmt.getGeneratedKeys();


            if (rs.next()) {
                horaCentral.setId(rs.getInt(1));
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
