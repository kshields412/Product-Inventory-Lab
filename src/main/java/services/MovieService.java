package services;

import models.Movie;

import java.util.ArrayList;

public class MovieService {
    private static int nextId = 1;
    private ArrayList<Movie> inventory = new ArrayList<>();

    public Movie create(String title, String genre, Integer runTime, Double ticketPrice, Double openingWeekSales) {
        Movie createdMovie = new Movie(nextId++, title, genre, runTime, ticketPrice, openingWeekSales);
        inventory.add(createdMovie);
        return createdMovie;
    }

    public Movie findMovie(Integer id) {
        return this.inventory.get(id);
    }

    public ArrayList<Movie> findAll() {
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
