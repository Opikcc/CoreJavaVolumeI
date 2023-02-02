package com.deapika.CoreJavaVolumeI;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JacksonTest {
  public static void main(String[] args) throws IOException {
    ObjectMapper oMapper = new ObjectMapper();
    ObjectMapper oMapper2 = new ObjectMapper();
    Car car = new Car("yellow", "renault");
    oMapper.writeValue(new File("car.json"), car);
    
    String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
    Car mobil = oMapper2.readValue(json, Car.class);	
    Car mobil2 = oMapper.readValue(new File("car.json"), Car.class);
    
    System.out.println("mobil : " + mobil.toString());
    System.out.println("mobil2 : " + mobil2.toString());
  }
}
