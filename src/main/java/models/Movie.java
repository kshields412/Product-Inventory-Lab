package models;

public class Movie {
    public Integer setId;
    private Integer id;
    private String title;
    private String genre;
    private Integer runTime;
    private Double ticketPrice;
    private Double openingWeekSales;


    public Movie(Integer id, String title, String genre){
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public Movie(Integer id, String title, String genre, Integer runTime, Double ticketPrice, Double openingWeekSales){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.runTime = runTime;
        this.ticketPrice = ticketPrice;
        this.openingWeekSales = openingWeekSales;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public String getGenre() { return genre; }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Double getOpeningWeekSales() {
        return openingWeekSales;
    }

    public void setOpeningWeekSales(Double openingWeekSales) {
        this.openingWeekSales = openingWeekSales;
    }

    public void setTitle(String title){ this.title = title; }

    public String getTitle(){
        return title;
    }

    public String toString() {
        return String.format("Id: %s | Title: %s | Genre: %s | Run Time: %s | Ticket Price: %s | Opening Weekend Sales: %s",
                getId(), getTitle(), getGenre(), getRunTime(), getTicketPrice(), getOpeningWeekSales());
    }

}
