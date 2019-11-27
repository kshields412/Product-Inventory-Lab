package utils;

import services.MovieService;
import services.SneakerService;

public class SetUp {
    private SneakerService sneakerService = new SneakerService();
    private MovieService movieService = new MovieService();
    
    public void init() {
        Console.println("Welcome! ˭̡̞(◞⁎˃ᆺ˂)◞*✰");
        Integer selection = Console.getIntegerInput("1 - Movies!\n" + "2 - Shoes!\n" + "3 - Exit!\n\n" + "Please make a selection.");
        getSelection(selection);
    }

    public void getSelection(Integer selection) {
        switch (selection) {
            case 1:
                MovieMainUtils.selectMovie(movieService);
                break;
            case 2:
                SneakerMainUtils.selectSneaker(sneakerService);
                break;
            case 3:
                System.exit(0);
            default:
                init();
        }
        init();
    }
}
