package org.ait.qa25.utils;

import org.ait.qa25.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> newUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Max","Adams","maxx@gm.com","Max1234$"});
        list.add(new Object[]{"Max1","Adams","maxx@gm.com","Max1234$"});
        list.add(new Object[]{"Max2","Adams","maxx@gm.com","Max1234$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newUserWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/UsersRegistrationList.csv")));
        String line = reader.readLine();
        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User().setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();

    }
}
