package services;

import models.Sneaker;
import utils.CSVUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {
    private static int nextId = 1;
    private ArrayList<Sneaker> inventory = new ArrayList<>();

    public SneakerService() throws IOException {
    }

    public Sneaker create(String name, String brand, Integer size, Double price, Integer qty) {
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, size, price, qty);
        inventory.add(createdSneaker);
        return createdSneaker;
    }

    public Sneaker findSneaker(Integer id) {
        return this.inventory.get(id - 1);
    }

    public ArrayList<Sneaker> findAll() {
        return inventory;
    }

    public boolean delete(Integer id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (!(inventory.get(i).getId().equals(id))) {
                return true;
            }
        }
        return false;
    }

    public Integer size(){
        return inventory.size();
    }

//    public void update(Integer id, Movie updatedSneaker) {
//        inventory.set(id - 1, updatedSneaker);
//    }


    String csvFile = "/Users/kai/Dev/Labs/Product-Inventory-Lab/Sneaker.csv";
    FileWriter writer = new FileWriter(csvFile);


    CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId)));

    for(Sneaker s : inventory) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(s.getId()));
        list.add(s.getName());
        list.add(s.getBrand());
        list.add(String.valueOf(s.getSize()));
        list.add(String.valueOf(s.getPrice()));
        list.add(String.valueOf(s.getQty()));


        try {
            CSVUtils.writeLine(writer, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

writer.flush();
writer.close();

}
}
