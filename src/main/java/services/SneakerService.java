package services;

import models.Sneaker;

import java.util.ArrayList;

public class SneakerService {
    private static int nextId = 1;
    private ArrayList<Sneaker> inventory = new ArrayList<>();

    public Sneaker create(String name, String brand, Integer size, Double price, Integer qty) {
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, size, price, qty);
        inventory.add(createdSneaker);
        return createdSneaker;
    }

    public Sneaker findSneaker(Integer id) {
        return this.inventory.get(id);
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
}
