package models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class MovieTest {
    @Test
    public void testConstructor1(){
        String expectedTitle = "Cats";
        String expectedGenre = "Musical";
        Movie movie = new Movie(expectedTitle, expectedGenre);
        String actualTitle = movie.getTitle();
        String actualGenre = movie.getGenre();
        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedGenre, actualGenre);
    }

    @Test
    public void testConstructor2(){
        String expectedTitle = "Cats";
        String expectedGenre = "Musical";
        Integer expectedRunTime = 105;
        Double expectedTicketPrice = 9.00;
        Double expectedOpeningWeekSales = 1000000.00;
        Movie movie = new Movie(expectedTitle, expectedGenre, expectedRunTime, expectedTicketPrice, expectedOpeningWeekSales);

        String actualTitle = movie.getTitle();
        String actualGenre = movie.getGenre();
        Integer actualRunTime = movie.getRunTime();
        Double actualTicketPrice = movie.getTicketPrice();
        Double actualOpeningWeekSales = movie.getOpeningWeekSales();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedGenre, actualGenre);
        Assert.assertEquals(expectedRunTime, actualRunTime);
        Assert.assertEquals(expectedTicketPrice, actualTicketPrice);
        Assert.assertEquals(expectedOpeningWeekSales, actualOpeningWeekSales);
    }

    @Test
    public void testGetRunTime(){
        Integer expected = 90;
        Movie movie = new Movie("Babe", "Kids", 90, 6.00, 90000.00);
        Integer actual = movie.getRunTime();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetRunTime(){
        Integer expected = 90;
        Movie movie = new Movie(null, null, null, null, null);
        movie.setRunTime(90);
        Assert.assertEquals(expected, movie.getRunTime());
    }

    @Test
    public void testGetGenre(){
        String expected = "Drama";
        Movie movie = new Movie(null, "Drama", null, null, null);
        String actual = movie.getGenre();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetGenre(){
        String expected = "Fantasy";
        Movie movie = new Movie(null, null, null, null, null);
        movie.setGenre("Fantasy");
        Assert.assertEquals(expected, movie.getGenre());
    }

    @Test
    public void testGetTicketPrice(){
        Double expected = 8.00;
        Movie movie = new Movie(null, null, null, 8.00, null);
        Double actual = movie.getTicketPrice();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetTicketPrice(){
        Double expected = 7.00;
        Movie movie = new Movie(null,null,null,null,null);
        movie.setTicketPrice(7.00);
        Assert.assertEquals(expected, movie.getTicketPrice());
    }

    @Test
    public void testGetOpeningWeekSales(){
        Double expected = 10000.00;
        Movie movie = new Movie(null,null,null,null, 10000.00);
        Double actual = movie.getOpeningWeekSales();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetOpeningWeekSales(){
        Double expected = 100000.00;
        Movie movie = new Movie(null,null,null,null,null);
        movie.setOpeningWeekSales(100000.00);
        Assert.assertEquals(expected, movie.getOpeningWeekSales());
    }

    @Test
    public void testGetTitle(){
        String expected = "Scream";
        Movie movie = new Movie("Scream", null,null,null,null);
        String actual = movie.getTitle();
        Assert.assertEquals(expected, movie.getTitle());
    }

    @Test
    public void testSetTitle(){
        String expected = "Scream";
        Movie movie = new Movie(null,null,null,null,null);
        movie.setTitle("Scream");
        Assert.assertEquals(expected, movie.getTitle());
    }
}
