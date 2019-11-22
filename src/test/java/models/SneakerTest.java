package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SneakerTest {
    Sneaker sneaker;
    Integer id;
    String name;
    String brand;
    Integer size;
    Double price;
    Integer qty;

    @Before
    public void setUp() {
        sneaker = new Sneaker(id, name, brand, size, price, qty);
    }

    @Test
    public void testSetId() {
        Integer expected = 1;
        sneaker = new Sneaker(null, null, null, null, null, null);

        sneaker.setId(expected);

        Assert.assertEquals(expected, sneaker.getId());
    }

    @Test
    public void testGetId() {
        Integer expected = 1;
        sneaker = new Sneaker(expected, null, null, null, null, null);

        Integer actual = sneaker.getId();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        String expected = "Air Force 1";
        sneaker = new Sneaker(null, null, null, null, null, null);

        sneaker.setName(expected);

        Assertions.assertEquals(expected, sneaker.getName());
    }

    @Test
    public void testGetName() {
        String expected = "Air Force 1";
        sneaker = new Sneaker(null, expected, null, null, null, null);

        String actual = sneaker.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBrand() {
        String expected = "Nike";
        sneaker = new Sneaker(null, null, null, null, null, null);

        sneaker.setBrand(expected);

        Assert.assertEquals(expected, sneaker.getBrand());
    }

    @Test
    public void testGetBrand() {
        String expected = "Nike";
        sneaker = new Sneaker(null, null, expected, null, null, null);

        String actual = sneaker.getBrand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetSize() {
        Integer expected = 8;
        sneaker = new Sneaker(null, null, null, null, null, null);

        sneaker.setSize(expected);

        Assert.assertEquals(expected, sneaker.getSize());
    }

    @Test
    public void testGetSize() {
        Integer expected = 8;
        sneaker = new Sneaker(null, null, null, 8, null, null);

        Integer actual = sneaker.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetQty() {
        Integer expected = 1000;
        sneaker = new Sneaker(null, null, null, null, null, null);

        sneaker.setQty(1000);

        Assert.assertEquals(expected, sneaker.getQty());
    }

    @Test
    public void testGetQty() {
        Integer expected = 1000;
        sneaker = new Sneaker(null, null, null, null, null, expected);

        Integer actual = sneaker.getQty();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetPrice() {
        Double expected = 200.00;
        sneaker = new Sneaker(null, null, null,null, null, null);

        sneaker.setPrice(expected);

        Assert.assertEquals(expected, sneaker.getPrice());
    }

    @Test
    public void testGetPrice() {
        Double expected = 200.00;
        sneaker = new Sneaker(null, null, null, null, expected, null);

        Double actual = sneaker.getPrice();

        Assert.assertEquals(expected, actual);
    }
}
