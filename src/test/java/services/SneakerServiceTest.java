package services;

import models.Sneaker;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SneakerServiceTest {
    @Test
    public void createTest() {
        String expectedName = "Air Force 1";
        String expectedBrand = "Nike";
        Integer expectedSize = 10;
        Double expectedPrice = 80.00;
        Integer expectedQty = 100;

        SneakerService sneakerService = new SneakerService();
        Sneaker sneaker = sneakerService.create(expectedName, expectedBrand, expectedSize, expectedPrice, expectedQty);

        Integer actualId = sneaker.getId();
        String actualName = sneaker.getName();
        String actualBrand = sneaker.getBrand();
        Integer actualSize = sneaker.getSize();
        Double actualPrice = sneaker.getPrice();
        Integer actualQty = sneaker.getQty();

        Assert.assertEquals(Integer.class.getName(), actualId.getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testFindSneaker(){
        SneakerService ss = new SneakerService();
        String expectedName = "Air Force 1";
        String expectedBrand = "Nike";
        Integer expectedSize = 10;
        Double expectedPrice = 100.00;
        Integer expectedQty = 10;

        Sneaker sneaker = ss.create(expectedName, expectedBrand, expectedSize, expectedPrice, expectedQty);
        Integer expectedId = sneaker.getId();

        Sneaker actual = ss.findSneaker(expectedId);

        Assert.assertEquals(expectedId, actual);
    }
    @Test
    public void testFindAll(){
        SneakerService ss = new SneakerService();
        ss.create("Air Force 1", "Nike", 10, 100.00, 10);
        ArrayList<Sneaker> inventory = ss.findAll();
        Assert.assertTrue(inventory.size() == 1);
    }

}
