package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class MovieTest {
    Movie baseMovie;
    Movie movie;
    Integer id;
    String title;
    Integer runTime;
    String genre;
    Double ticketPrice;
    Double openingWeekSales;

    @Before
    public void setUp(){
        baseMovie = new Movie(id, title, genre);
        movie = new Movie(id, title, genre, runTime, ticketPrice, openingWeekSales);
    }

    @Test
    public void testConstructor1(){
        Integer expectedId = 1;
        String expectedTitle = "Cats";
        String expectedGenre = "Musical";
        baseMovie = new Movie(expectedId, expectedTitle, expectedGenre);

        String actualTitle = baseMovie.getTitle();
        String actualGenre = baseMovie.getGenre();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedGenre, actualGenre);
    }

    @Test
    public void testConstructor2(){
        Integer expectedId = 1;
        String expectedTitle = "Cats";
        String expectedGenre = "Musical";
        Integer expectedRunTime = 105;
        Double expectedTicketPrice = 9.00;
        Double expectedOpeningWeekSales = 1000000.00;
        movie = new Movie(expectedId, expectedTitle, expectedGenre, expectedRunTime, expectedTicketPrice, expectedOpeningWeekSales);

        Assert.assertEquals(Integer.class.getName(), movie.getId().getClass().getName());
        Assert.assertEquals(expectedTitle, movie.getTitle());
        Assert.assertEquals(expectedGenre, movie.getGenre());
        Assert.assertEquals(expectedRunTime, movie.getRunTime());
        Assert.assertEquals(expectedTicketPrice, movie.getTicketPrice());
        Assert.assertEquals(expectedOpeningWeekSales, movie.getOpeningWeekSales());
    }

    @Test
    public void testGetId(){
        Integer expected = 2;
        baseMovie = new Movie(expected, null, null);
        Assert.assertEquals(expected, baseMovie.getId());
    }

    @Test
    public void testGetRunTime(){
        Integer expected = 90;
        movie = new Movie(2, "Babe", "Kids", 90, 6.00, 90000.00);

        Integer actual = movie.getRunTime();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetRunTime(){
        Integer expected = 90;
        movie = new Movie(null, null, null, null, null, null);

        movie.setRunTime(90);

        Assert.assertEquals(expected, movie.getRunTime());
    }

    @Test
    public void testGetGenre(){
        String expected = "Drama";
        movie = new Movie(null, null, "Drama", null, null, null);

        String actual = movie.getGenre();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetGenre(){
        String expected = "Fantasy";
        movie = new Movie(null, null, null, null, null, null);

        movie.setGenre("Fantasy");

        Assert.assertEquals(expected, movie.getGenre());
    }

    @Test
    public void testGetTicketPrice(){
        Double expected = 8.00;
        movie = new Movie(null, null, null, null, 8.00, null);

        Double actual = movie.getTicketPrice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetTicketPrice(){
        Double expected = 7.00;
        movie = new Movie(null, null,null,null,null,null);

        movie.setTicketPrice(7.00);

        Assert.assertEquals(expected, movie.getTicketPrice());
    }

    @Test
    public void testGetOpeningWeekSales(){
        Double expected = 10000.00;
        movie = new Movie(null, null,null,null,null, 10000.00);

        Double actual = movie.getOpeningWeekSales();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetOpeningWeekSales(){
        Double expected = 100000.00;
        movie = new Movie(null, null,null,null,null,null);

        movie.setOpeningWeekSales(100000.00);

        Assert.assertEquals(expected, movie.getOpeningWeekSales());
    }

    @Test
    public void testGetTitle(){
        String expected = "Scream";
        movie = new Movie(null, "Scream", null,null,null,null);

        String actual = movie.getTitle();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitle(){
        String expected = "Scream";
        movie = new Movie(null, null,null,null,null,null);

        movie.setTitle("Scream");

        Assert.assertEquals(expected, movie.getTitle());
    }
}
