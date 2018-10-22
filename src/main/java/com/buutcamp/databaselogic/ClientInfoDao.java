package com.buutcamp.databaselogic;

import com.buutcamp.objects.ClientInfo;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ClientInfoDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<ClientInfo> getAllData() {
        String query ="SELECT * FROM dev_table";
        List<ClientInfo> clients = jdbcTemplate.query(query,new ClientInfoRowMapper());

        return clients;
    }

    public boolean createRow(ClientInfo clientInfo) {
        String query = "INSERT INTO dev_table (first_name, last_name, age) VALUES(?,?,?)";

        Object[] args = new Object[] {clientInfo.getFirstName(), clientInfo.getLastName(), clientInfo.getAge()};

        return jdbcTemplate.update(query,args)==1;
    }

    
}
