package models;

public class Movie {
    private String title;
    private Integer runTime;
    private String genre;
    private Double ticketPrice;
    private Double openingWeekSales;


    public Movie(String title, String genre){
        this.title = title;
        this.genre = genre;
    }

    public Movie(String title, String genre, Integer runTime, Double ticketPrice, Double openingWeekSales){
        this.title = title;
        this.genre = genre;
        this.runTime = runTime;
        this.ticketPrice = ticketPrice;
        this.openingWeekSales = openingWeekSales;
    }

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

}
