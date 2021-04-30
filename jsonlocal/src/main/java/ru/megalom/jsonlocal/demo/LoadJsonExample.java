package ru.megalom.jsonlocal.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            Student student=objectMapper.readValue(new File("data/data-full.json"),Student.class);
            System.out.println("Student:\n"+student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
