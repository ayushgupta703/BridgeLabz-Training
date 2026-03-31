package streamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Movie {
    private String name;
    private double rating;
    private int releaseYear;
    private String genre;

    public Movie(String name, double rating, int releaseYear, String genre) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return name + " (" + releaseYear + ") - Rating: " + rating;
    }
}


public class TrendingMovies {
	public static void main(String[] args) {
		List<Movie> movies = List.of(
				new Movie("Interstellar", 8.6, 2014, "Sci-Fi"),
				new Movie("The Dark Knight", 9.0, 2008, "Action"),
                new Movie("Oppenheimer", 8.9, 2023, "Biography"),
                new Movie("Dune: Part Two", 8.7, 2024, "Sci-Fi"),
                new Movie("Avengers: Endgame", 8.4, 2019, "Superhero"),
                new Movie("Joker", 8.5, 2019, "Drama"),
                new Movie("Tenet", 7.8, 2020, "Sci-Fi"),
                new Movie("Spider-Man: No Way Home", 8.3, 2021, "Superhero"),
                new Movie("The Batman", 7.9, 2022, "Action")
		);
		
		List<Movie> top5Movies = movies.stream()
				.filter(movie->movie.getReleaseYear() >= 2019)
				.sorted(Comparator.comparing(Movie::getRating).reversed()
						.thenComparing(Movie::getReleaseYear).reversed())
				.limit(5)
				.collect(Collectors.toList());
		top5Movies.forEach(System.out::println);
	}
}
