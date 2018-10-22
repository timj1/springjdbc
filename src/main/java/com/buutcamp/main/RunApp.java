package com.buutcamp.main;

import com.buutcamp.databaselogic.ClientInfoDao;
import com.buutcamp.objects.ClientInfo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class RunApp {

    public RunApp() {

        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("beans.xml");

        ClientInfoDao clientInfoDao =
                (ClientInfoDao) ctx.getBean("clientInfoDao");

        List<ClientInfo> list = clientInfoDao.getAllData();

        System.out.println(list.get(0).getFirstName());
        System.out.println(list.get(0).getLastName());

        ClientInfo clientInfo = new ClientInfo("First name", "Last name", 100);
        clientInfoDao.createRow(clientInfo);

        ctx.close();
    }
}
