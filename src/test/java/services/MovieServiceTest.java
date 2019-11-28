package services;

import models.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MovieServiceTest {
    MovieService ms;
    ArrayList<Movie> inventory;

    @Before
    public void setUp(){
        ms = new MovieService();
        inventory = new ArrayList<>();
        inventory.add(ms.create("The Notebook", "Drama", 125, 7.00, 800000.00));
        inventory.add(ms.create("Spider-Man", "Action", 180, 11.00, 10000000.00));
    }

    @Test
    public void testAddToInventory(){
        String expectedTitle = "Groundhog Day";
        String expectedGenre= "Comedy";
        Integer expectedRunTime = 135;
        Double expectedTicketPrice = 6.00;
        Double expectedOpeningWeekendSales = 600000.00;

        Movie movie = ms.create(expectedTitle, expectedGenre, expectedRunTime, expectedTicketPrice, expectedOpeningWeekendSales);

        inventory.add(movie);

        Assert.assertTrue(inventory.contains(movie));
    }

    @Test
    public void testCreate(){
        String expectedTitle = "It";
        String expectedGenre = "Horror";
        Integer expectedRunTime = 165;
        Double expectedTicketPrice = 9.75;
        Double expectedOpeningWeekSales = 150000000.00;

        Movie movie = ms.create(expectedTitle, expectedGenre, expectedRunTime, expectedTicketPrice,expectedOpeningWeekSales);

        Assert.assertEquals(Integer.class.getName(), movie.getId().getClass().getName());
        Assert.assertEquals(expectedTitle, movie.getTitle());
        Assert.assertEquals(expectedGenre, movie.getGenre());
        Assert.assertEquals(expectedRunTime, movie.getRunTime());
        Assert.assertEquals(expectedTicketPrice, movie.getTicketPrice());
        Assert.assertEquals(expectedOpeningWeekSales, movie.getOpeningWeekSales());
    }

    @Test
    public void testFindMovie1(){
        Integer expectedId1 = 2;
        Integer expectedId2 = 3;

        Movie movie1 = ms.create("Trolls", "Family", 145, 9.00, 1000000.00);
        Movie movie2 = ms.create("Polar Express", "Family", 155, 6.00, 12000000.00);
        movie1.setId(expectedId1);
        movie2.setId(expectedId2);
        inventory.add(movie1);
        inventory.add(movie2);

        Assert.assertEquals(movie1, ms.findMovie(3));//second index
    }

    @Test
    public void testFindMovie2(){
        Integer expectedId = 3;
        String expectedName = "Avengers: End Game";
        String expectedGenre = "Action";
        Integer expectedRunTime= 240;
        Double expectedTicketPrice = 13.00;
        Double expectedOpeningWeekSales = 3500000000.00;

        Movie movie = ms.create(expectedName, expectedGenre, expectedRunTime, expectedTicketPrice, expectedOpeningWeekSales);
        movie.setId(expectedId);
        inventory.add(movie);

        Assert.assertEquals(0, movie.getId().compareTo(expectedId));
        /* ^ asserts that the comparison of the two ids
        (the expected that is set and the id of the movie when called)
        are the same. if they are not, it will return 1 OR -1 but
        it returns 0 because they are the same when called and set*/
    }

    @Test
    public void testFindAll(){
        inventory.add(ms.create("Eragon", "Fantasy", 180, 8.50, 950000.00));
        Assert.assertEquals(inventory.size(), ms.findAll().size());
    }

    @Test
    public void testDelete(){
        ms.delete(1);
        Assert.assertTrue(inventory.size() == 2);
    }

    @Test
    public void testSize1(){
        Assert.assertTrue(ms.size().equals(2));
    }

    @Test
    public void testSize2(){
        ms.create("Jaws", "Thriller", 110, 5.00, 200000000.00);
        ms.create("Gremlins", "Family", 95, 4.00, 430000.00);
        Assert.assertTrue(ms.size().equals(4));
    }

    @Test
    public void testUpdate(){
        Movie movie = ms.create("Nightmare Before Christmas", "Family", 110, 8.75, 1000000.00);
        ms.update(3, movie);
        String expected = "Seasonal";
        movie.setGenre(expected);

        Assert.assertEquals(expected, movie.getGenre());
    }

    @Test
    public void testToString(){
        Movie movie = ms.create("Ponyo", "Family", 120, 7.50, 1230000.00);
        String actual = movie.toString();
        Assert.assertEquals("Id: 3 | Title: Ponyo | Genre: Family | Run Time: 120 | Ticket Price: 7.5 | Opening Weekend Sales: 1230000.0", actual);
    }

//    @Test
//    public void testCSVWriting(){
//        ms.csvWriting();
//        Assert.assertEquals("bob", ms.csvWriting());
//    }
}
