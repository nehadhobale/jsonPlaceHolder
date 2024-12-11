package com.tektom.testCases;


import com.tektom.utility.TestDataReader;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    public static String usersEndpoint;
    public static String postsEndpoint;

    @BeforeSuite
    @Parameters({"env"})
    public void setUp(@Optional("test") String env){
        Properties properties = TestDataReader.loadProperties(env);
        usersEndpoint = properties.getProperty("usersEndpoint");
        postsEndpoint = properties.getProperty("postsEndpoint");
    }

}
