package controllers;

import data.Constants;
import interfaces.Savable;
import model.LocationPOJO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rafal on 2016-09-11.
 */
public class SaveToFile implements Savable {

    public void save(List<LocationPOJO> locationPOJOList) {

        File f = new File(Constants.fileName);
        if(f.exists() && !f.isDirectory()) {
            System.out.println("File " + Constants.fileName + " already exists. Do You want to overwrite it ? (Yes/No)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            if (response.equals("Yes")) {
                writeToFile(locationPOJOList);
            } else {
                System.out.println("Old file saved.");
            }
        } else {
            writeToFile(locationPOJOList);
        }
    }

    private void writeToFile(List<LocationPOJO> locationPOJOList) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(Constants.fileName));
            printWriter.write(Constants.columnList.toString() + "\n");
            for(LocationPOJO locationPOJO : locationPOJOList){
                printWriter.write(
                        locationPOJO.getId().toString() + "," +
                                locationPOJO.getName().toString() + "," +
                                locationPOJO.getType().toString() + "," +
                                String.valueOf(locationPOJO.getGeo_latitude()) + "," +
                                String.valueOf(locationPOJO.getGeo_longitude()) + "\n");
            }
            printWriter.close();
            System.out.println("File overwritten.");
        } catch (IOException e) {
            System.out.println("There was an error while writing to file IO Exception: " + e.toString());
        }
    }
}
