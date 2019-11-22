package services;

import models.Sneaker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SneakerServiceTest {
    SneakerService ss;
    ArrayList<Sneaker> inventory;


    @Before
    public void setUp(){
        ss = new SneakerService();
        inventory = new ArrayList<>();
        inventory.add(ss.create("Cloudform", "Adidas", 9, 75.00, 15));
        inventory.add(ss.create("Nike Air", "Nike", 11, 89.00, 30));
    }

    @Test
    public void testAddToInventory(){
        String expectedName = "Air Force 1";
        String expectedBrand = "Nike";
        Integer expectedSize = 10;
        Double expectedPrice = 80.00;
        Integer expectedQty = 100;

        Sneaker sneaker = ss.create(expectedName, expectedBrand, expectedSize, expectedPrice, expectedQty);

        inventory.add(sneaker);

        Assert.assertTrue(inventory.contains(sneaker));
    }

    @Test
    public void testCreate() {
        String expectedName = "Air Force 1";
        String expectedBrand = "Nike";
        Integer expectedSize = 10;
        Double expectedPrice = 80.00;
        Integer expectedQty = 100;

        Sneaker sneaker = ss.create(expectedName, expectedBrand, expectedSize, expectedPrice, expectedQty);

        Assert.assertEquals(Integer.class.getName(), sneaker.getId().getClass().getName());
        Assert.assertEquals(expectedName, sneaker.getName());
        Assert.assertEquals(expectedBrand, sneaker.getBrand());
        Assert.assertEquals(expectedSize, sneaker.getSize());
        Assert.assertEquals(expectedQty, sneaker.getQty());
        Assert.assertEquals(expectedPrice, sneaker.getPrice());
    }

    @Test
    public void testFindSneaker1(){
        Integer expectedId1 = 2;
        Integer expectedId2 = 3;

        Sneaker sneaker1 = ss.create("Air Force 1", "Nike", 10, 100.00, 10);
        Sneaker sneaker2 = ss.create("Cloudform", "Adidas", 11, 75.00, 100);
        sneaker1.setId(expectedId1);
        sneaker2.setId(expectedId2);
        inventory.add(sneaker1);
        inventory.add(sneaker2);

        Assert.assertEquals(sneaker1, ss.findSneaker(3)); //second index
    }

    @Test
    public void testFindSneaker2() {
        Sneaker sneaker = ss.create("Air Force 1", "Nike", 10, 100.00, 10);
        sneaker.setId(3);
        inventory.add(sneaker);

        Assert.assertEquals(0, sneaker.getId().compareTo(3));
        /* ^ asserts that the comparison of the two ids
        (the expected that is set and the id of the movie when called)
        are the same. if they are not, it will return 1 OR -1 but
        it returns 0 because they are the same when called and set*/
    }

    @Test
    public void testFindAll(){
        inventory.add(ss.create("Air Force 1", "Nike", 10, 100.00, 10));
        Assert.assertEquals(inventory.size(), ss.findAll().size());
    }

    @Test
    public void testDelete(){
        ss.delete(1);
        Assert.assertTrue(inventory.size() == 2);
    }

    @Test
    public void testSize1(){
        Assert.assertTrue(ss.size().equals(2));
    }

    @Test
    public void testSize2(){
        ss.create("Hurrachi", "Nike", 9, 150.00, 20);
        ss.create("Chanel Boots", "Chanel", 7, 70.00, 43);
        Assert.assertTrue(ss.size().equals(4));
    }
//
//    @Test
//    public void testUpdate(){
//        Sneaker sneaker = ss.create("All-Star", "Converse", 8, 65.00, 1000);
//        ss.update(3, sneaker);
//        Integer expected = 999;
//        sneaker.setQty(expected);
//
//        Assert.assertEquals(expected, sneaker.getQty());
//    }

}
