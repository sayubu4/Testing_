// MovieListApp.java

// Main class for the Movie List Application
public class MovieListApp {
    private CustomArrayList movies; // List to store movies

    // Constructor initializes the CustomArrayList for movies
    public MovieListApp() {
        movies = new CustomArrayList();
    }

    // Method to add a movie to the list
    public void addMovie(String title, int releaseYear, double rating) {
        Movie movie = new Movie(title, releaseYear, rating); // Create a new Movie object
        movies.add(movie); // Add the movie to the list
    }

    // Method to display all movies in the list
    public void displayMovies() {
        movies.display(); // Call the display method of CustomArrayList
    }

    // Method to calculate the average rating of all movies in the list
    public double calculateAverageRating() {
        if (movies.isEmpty()) { // Check if the list is empty
            return 0; // Return 0 if no movies are present
        }
        double sum = 0; // Variable to hold the sum of ratings
        for (int i = 0; i < movies.size(); i++) { // Iterate through the list
            Movie movie = (Movie) movies.get(i); // Get each movie
            sum += movie.getRating(); // Add the rating to the sum
        }
        return sum / movies.size(); // Calculate and return the average rating
    }

    // Method to remove a movie from the list by title
    public boolean removeMovieByTitle(String title) {
        for (int i = 0; i < movies.size(); i++) { // Iterate through the list
            Movie movie = (Movie) movies.get(i); // Get each movie
            if (movie.getTitle().equals(title)) { // Check if the title matches
                movies.remove(i); // Remove the movie if the title matches
                return true; // Return true indicating the movie was removed
            }
        }
        return false; // Return false if no movie with the given title was found
    }

    // Inner class representing a Movie
    static class Movie {
        private String title; // Title of the movie
        private int releaseYear; // Release year of the movie
        private double rating; // Rating of the movie

        // Constructor to initialize a Movie object
        public Movie(String title, int releaseYear, double rating) {
            this.title = title;
            this.releaseYear = releaseYear;
            this.rating = rating;
        }

        // Getter method for the title
        public String getTitle() {
            return title;
        }

        // Getter method for the release year
        public int getReleaseYear() {
            return releaseYear;
        }

        // Getter method for the rating
        public double getRating() {
            return rating;
        }

        // Override toString method to provide a string representation of the movie
        @Override
        public String toString() {
            return "Movie{" +
                    "title='" + title + '\'' +
                    ", releaseYear=" + releaseYear +
                    ", rating=" + rating +
                    '}';
        }
    }

    // Main method to test the MovieListApp functionality
    public static void main(String[] args) {
        MovieListApp app = new MovieListApp(); // Create an instance of MovieListApp
        app.addMovie("Inception", 2010, 8.8); // Add a movie to the list
        app.addMovie("The Matrix", 1999, 8.7); // Add another movie to the list
        app.addMovie("Interstellar", 2014, 8.6); // Add another movie to the list

       // System.out.println("Movies in the list:");


        //app.displayMovies(); // Display all movies

      //  System.out.println("Average Rating: " + app.calculateAverageRating()); // Calculate and display average rating

        app.removeMovieByTitle("The Matrix"); // Remove a movie by title
       System.out.println("Movies after removal:");
        app.displayMovies(); // Display movies after removal
    }
}
