package com.buutcamp.databaselogic;

import com.buutcamp.objects.ClientInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientInfoRowMapper implements RowMapper<ClientInfo> {

    public ClientInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setFirstName(resultSet.getString("first_name"));
        clientInfo.setLastName(resultSet.getString("last_name"));

        clientInfo.setAge(resultSet.getInt("age"));
        clientInfo.setId(resultSet.getInt("ID"));

        return clientInfo;
    }
}
