package controllers;

import data.Constants;
import interfaces.Savable;
import model.LocationPojo;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rafal on 2016-09-11.
 */
@Controller
public class SaveToFile implements Savable {

    public void save(List<LocationPojo> locationPojoList) {

        File f = new File(Constants.fileName);
        if(f.exists() && !f.isDirectory()) {
            System.out.println("File " + Constants.fileName + " already exists. Do You want to overwrite it ? (Yes/No)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.equals("Yes")) {
                writeToFile(locationPojoList);
            } else {
                System.out.println("Old file saved.");
            }
        } else {
            writeToFile(locationPojoList);
        }
    }

    private void writeToFile(List<LocationPojo> locationPojoList) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(Constants.fileName));
            printWriter.write(Constants.columnList.toString() + "\n");
            for(LocationPojo locationPojo : locationPojoList){
                printWriter.write(
                        locationPojo.getId().toString() + "," +
                                locationPojo.getName().toString() + "," +
                                locationPojo.getType().toString() + "," +
                                String.valueOf(locationPojo.getGeo_latitude()) + "," +
                                String.valueOf(locationPojo.getGeo_longitude()) + "\n");
            }
            printWriter.close();
            System.out.println("File overwritten.");
        } catch (IOException e) {
            System.out.println("There was an error while writing to file IO Exception: " + e.toString());
        }
    }
}
