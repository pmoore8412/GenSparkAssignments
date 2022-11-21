public class Movie {

    private String title;
    private String studio;
    private String rating;

    //constructors
    public Movie() {}

    public Movie(String title, String studio, String rating) {

        this.title = title;
        this.studio = studio;
        this.rating = rating;

    }

    public Movie(String title, String studio) {

        this.title = title;
        this.studio = studio;
        this.rating = "PG";

    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getStudio() {
        return studio;
    }

    public String getRating() {
        return rating;
    }

    //setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Movie[] getPG(Movie [] movies) {

        int length = movies.length;
        Movie [] moviesPG = new Movie[length];

        for(int i = 0; i < length; i++) {

            if(movies[i].rating.equals("PG"))
                moviesPG[i] = movies[i];

        }

        return moviesPG;
    }

}
