package services;

import models.Movie;
import models.Sneaker;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieService {
    private static int nextId = 1;
    private ArrayList<Movie> inventory = new ArrayList<>();

    public Movie create(String title, String genre, Integer runTime, Double ticketPrice, Double openingWeekSales) {
        Movie createdMovie = new Movie(nextId++, title, genre, runTime, ticketPrice, openingWeekSales);
        inventory.add(createdMovie);
        return createdMovie;
    }

    public Movie findMovie(Integer id) {
        return this.inventory.get(id - 1);
    }

    public ArrayList<Movie> findAll() {
        return inventory;
    }

    public boolean delete(Integer id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId().equals(id)) {
                inventory.remove(inventory.get(i));
                return true;
            }
        }
        return false;
    }

    public Integer size(){
        return inventory.size();
    }

    public void update(Integer id, Movie updatedMovie) {
        inventory.set(id - 1, updatedMovie);
    }

    public String toString(){
        String result = "";
        for(int i = inventory.size() -1; i >= 0; i--){
            if (i != 0){
                result += inventory.get(i).toString() + '\n';
            }else{
                result += inventory.get(i).toString();
            }
        }
        return result;
    }

    public void csvWriting() {
        try {
            String csvFile = "/Users/kai/Dev/Labs/Product-Inventory-Lab/Movie.csv";
            FileWriter writer = new FileWriter(csvFile);


            CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));

            for (Movie m : inventory) {
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(m.getId()));
                list.add(m.getTitle());
                list.add(m.getGenre());
                list.add(String.valueOf(m.getRunTime()));
                list.add(String.valueOf(m.getTicketPrice()));
                list.add(String.valueOf(m.getOpeningWeekSales()));


                CSVUtils.writeLine(writer, list);
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData(){
        String csvFile = "/Users/kai/Dev/Labs/Product-Inventory-Lab/Movie.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] movie = line.split(csvSplitBy);

                Integer id = Integer.parseInt(movie[0]);
                String title = movie[1];
                String genre = movie[2];
                Integer runTime = Integer.parseInt(movie[3]);
                Double ticketPrice = Double.parseDouble(movie[5]);
                Double openingWeekSales = Double.parseDouble(movie[5]);

                inventory.add(new Movie(id, title, genre, runTime, ticketPrice, openingWeekSales));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
