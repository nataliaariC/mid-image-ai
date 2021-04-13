/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatbotgeek.sdkwebservice.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 62878
 */
public class Tools {

    public void createFile(String path) {
        try {
            File yourFile = new File(path);
            yourFile.createNewFile(); // if file already exists will do nothing 
            FileOutputStream oFile = new FileOutputStream(yourFile, false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> getMember(String path) {
        List<String> numbers = new ArrayList<>();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                numbers.add(data);
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return numbers;
    }

    public boolean writeFile(String path, String values) {
        boolean success = false;
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(values);
            myWriter.close();
            success = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return success;
    }
}
