package utils;

import models.Movie;
import services.MovieService;

public class MovieMainUtils {
    public static void selectMovie(MovieService movieService) {
        Integer selection = Console.getIntegerInput("Make a selection!\n\n" +
                "1 - Create A Movie!\n" + "2 - Read About Our Movies!\n" +
                "3 - Update A Movie!\n" + "4 - Delete A Movie!\n" + "5 - Get Report!");
        getUserMovieSelection(selection, movieService);
    }

    public static void getUserMovieSelection(Integer selection, MovieService movieService) {
        switch (selection) {
            case 1:
                createMovie("Input Your New Movie's", movieService);
                Console.println("The id of your new movie is %s ", movieService.size());
                break;
            case 2:
                readMovie("Movie!", movieService);
                break;
            case 3:
                updateMovie(movieService);
                break;
            case 4:
                deleteMovie(movieService);
                break;
            default:
                selectMovie(movieService);
        }
    }

    public static void createMovie(String value, MovieService movieService) {
        String title = Console.getStringInput("%s title: ", value);
        String genre = Console.getStringInput("%s genre: ", value);
        Integer runTime = Console.getIntegerInput("%s run time: ", value);
        Double ticketPrice = Console.getDoubleInput("%s ticket price: ", value);
        Double openingWeekendSales = Console.getDoubleInput("%s opening weekend sales: ", value);

        movieService.create(title, genre, runTime, ticketPrice, openingWeekendSales);
    }

    public static void readMovie(String value, MovieService movieService) {
        Console.println(movieService.findAll().toString());
    }

    public static void updateMovie(MovieService movieService) {
        Integer id = Console.getIntegerInput("Enter the Id of the Movie You Want To Update: ");
        Movie updating = movieService.findMovie(id);
        Integer selection = Console.getIntegerInput("What would you like to update about your movie?\n" +
                "1 - Title!\n" + "2 - Genre!\n" + "3 - Run Time!\n" +
                "4 - Ticket Price!\n" + "5 - Opening Sales Weekend!\n");
        updating = updateChoice(selection, updating, movieService);
        movieService.update(id, updating);
        Console.println("Your movie is updated! （｡>‿‿<｡ ）");
    }

    public static Movie updateChoice(Integer selection, Movie movie, MovieService movieService) {
        switch (selection) {
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
                updateMovie(movieService);
        }
        return movie;
    }

    public static void deleteMovie(MovieService movieService) {
        Integer id = Console.getIntegerInput("Enter Id of Movie to Delete: ");
        if (movieService.delete(id)) {
            Console.println("%s movie has been deleted o(╥﹏╥)", "The");
        } else
            Console.println("Couldn't Delete Movie. Try Again~!");
    }
}
