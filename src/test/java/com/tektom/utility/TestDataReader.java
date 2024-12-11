package com.tektom.utility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestDataReader {

    /**
     * method to get dataprovider format from csv
     * @param filePath provide csv file path
     * @return object[][] of csv
     */
    public static Object[][] provideData(String filePath){

        List<Object[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(new Object[]{line});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new Object[0][]);
    }

    /**
     *  method to retrieve Json data from file
     * @param path provide json file path
     * @return Json string
     * @throws IOException
     */
    public static String getJsonData(String path) throws IOException {
         return new String(Files.readAllBytes(Paths.get(path)));
    }

    /**
     * method to load property file
     * @param envName name to select env property file
     * @return properties for particular env
     */
    public static Properties loadProperties(String envName) {
        try {
            File f1 = new File("src//test//resources//" + envName + "-env.properties");
            FileInputStream fs = new FileInputStream(f1);

            Properties properties = new Properties();
            properties.load(fs);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
