package utils;

import models.Sneaker;
import services.SneakerService;

public class SneakerMainUtils {
        public static void selectSneaker(SneakerService sneakerService) {
            Integer selection = Console.getIntegerInput("Make a selection!\n\n" +
                    "1 - Create A Sneaker!\n" + "2 - Read About Our Sneakers!\n" +
                    "3 - Update A Sneaker!\n" + "4 - Delete A Sneaker!\n" + "5 - Get Report!");
            getUserSneakerSelection(selection, sneakerService);
        }

        public static void getUserSneakerSelection(Integer selection, SneakerService sneakerService) {
            switch (selection) {
                case 1:
                    createSneaker("Input Your New Sneaker's", sneakerService);
                    Console.println("The id of your new sneaker is %s", sneakerService.size());
                    break;
                case 2:
                    readSneaker("Movie!", sneakerService);
                    break;
                case 3:
                    updateSneaker(sneakerService);
                    break;
                case 4:
                    deleteSneaker(sneakerService);
                    break;
                default:
                    selectSneaker(sneakerService);
            }
        }

        public static void createSneaker (String value, SneakerService sneakerService){
            String name = Console.getStringInput("%s name: ", value);
            String brand = Console.getStringInput("%s brand: ", value);
            Integer size = Console.getIntegerInput("%s size: ", value);
            Double price = Console.getDoubleInput("%s price: ", value);
            Integer qty = Console.getIntegerInput("%s quantity: ", value);

            sneakerService.create(name, brand, size, price, qty);
        }

        public static void readSneaker(String value, SneakerService sneakerService){
            Console.println(sneakerService.findAll().toString());
        }

        public static void updateSneaker(SneakerService sneakerService) {
            Integer id = Console.getIntegerInput("Enter the Id of the Sneaker You Want To Update: ");
            Sneaker updating = sneakerService.findSneaker(id);
            Integer selection = Console.getIntegerInput("What would you like to update about your sneaker?\n" +
                    "1 - Name!\n" + "2 - Brand!\n" + "3 - Size!\n" +
                    "4 - Price!\n" + "5 - Quantity!\n");
            updating = updateChoice(selection, updating, sneakerService);
            sneakerService.update(id, updating);
            Console.println("Your sneaker is updated! （｡>‿‿<｡ ）");
        }

        public static Sneaker updateChoice(Integer selection, Sneaker sneaker, SneakerService sneakerService){
            switch (selection) {
                case 1:
                    String name = Console.getStringInput("Change name: ");
                    sneaker.setName(name);
                    break;
                case 2:
                    String brand = Console.getStringInput("Change brand: ");
                    sneaker.setBrand(brand);
                    break;
                case 3:
                    Integer size = Console.getIntegerInput("Change size: ");
                    sneaker.setSize(size);
                    break;
                case 4:
                    Double price = Console.getDoubleInput("Change price: ");
                    sneaker.setPrice(price);
                    break;
                case 5:
                    Integer qty = Console.getIntegerInput("Change quantity: ");
                    sneaker.setQty(qty);
                    break;
                default:
                    Console.println("Not a valid input. Try again!\n\n");
                    updateSneaker(sneakerService);
            }
            return sneaker;
        }

        public static void deleteSneaker(SneakerService sneakerService) {
            Integer id = Console.getIntegerInput("Enter Id of Sneaker to Delete: ");
            if (sneakerService.delete(id)) {
                Console.println("%s sneaker has been deleted o(╥﹏╥)");
            } else
                Console.println("Couldn't Delete Sneaker. Try Again~!");
        }
}
