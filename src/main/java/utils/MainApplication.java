package utils;

import models.Movie;
import services.MovieService;
import services.SneakerService;

import java.util.Comparator;

public class MainApplication {
//    private SneakerService sneakerService = new SneakerService();
    private MovieService movieService = new MovieService();

    public static void main(String... args){
        MainApplication application = new MainApplication();
        application.init();
    }

    public void init(){
        Console.println("Welcome! ˭̡̞(◞⁎˃ᆺ˂)◞*✰");
//        Integer selection = Console.getIntegerInput("1 - Shoes!\n" + "2 - Movies!\n\n" + "Please make a selection.");
        Integer selection = Console.getIntegerInput("Make a selection!\n\n" +
                "1 - Create A Movie!\n" + "2 - Read About Our Movies!\n" +
                "3 - Update A Movie!\n" + "4 - Delete A Movie!\n" + "5 - Get Report!");
        getUserSelection(selection);
    }

    public void getUserSelection(Integer selection){
        switch(selection) {
            case 1:
                create("Input Your New Movie's");
                Console.println("The id of your new movie is %s", movieService.size());
                break;
            case 2:
                read("Movie!");
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            default:
                init();
        }
        init();
    }

    public void create(String value){
        String title = Console.getStringInput("%s title: ", value);
        String genre = Console.getStringInput("%s genre: ", value);
        Integer runTime = Console.getIntegerInput("%s run time: ", value);
        Double ticketPrice = Console.getDoubleInput("%s ticket price: ", value);
        Double openingWeekendSales = Console.getDoubleInput("%s opening weekend sales: ", value);

        movieService.create(title, genre, runTime, ticketPrice, openingWeekendSales);
    }

    public void read(String value) {
        Console.println(movieService.findAll().toString());
    }

    public void update(){
        Integer id = Console.getIntegerInput("Enter the Id of the Movie You Want To Update: ");
        Movie updating = movieService.findMovie(id);
        Integer selection = Console.getIntegerInput("What would you like to update about your movie?\n" +
                "1 - Title!\n" + "2 - Genre!\n" + "3 - Run Time!\n" +
                "4 - Ticket Price!\n" + "5 - Opening Sales Weekend!\n");
        updating = updateChoice(selection, updating);
        movieService.update(id, updating);
        Console.println("Your movie is updated! （｡>‿‿<｡ ）");
    }

    public Movie updateChoice(Integer selection, Movie movie){
        switch(selection) {
            case 1:
                String title = Console.getStringInput("Change Title: ");
                movie.setTitle(title);
                break;
            case 2:
                String genre = Console.getStringInput("Change genre: ");
                movie.setGenre(genre);
                break;
            case 3:
                Integer runTime = Console.getIntegerInput("Change Run Time: ");
                movie.setRunTime(runTime);
                break;
            case 4:
                Double ticketPrice = Console.getDoubleInput("Change Ticket Price: ");
                movie.setTicketPrice(ticketPrice);
                break;
            case 5:
                Double openingWeekendSales = Console.getDoubleInput("Change Opening Weekend Sales: ");
                movie.setOpeningWeekSales(openingWeekendSales);
                break;
            default:
                Console.println("Not a valid input. Try again!\n\n");
                update();
        }
        return movie;
    }

    public void delete() {
        Integer id = Console.getIntegerInput("Enter Id of Movie to Delete: ");
        if (movieService.delete(id)){
            Console.println("%s movie has been deleted o(╥﹏╥)");
        }else
            Console.println("Couldn't Delete Movie. Try Again~!");
    }
}
