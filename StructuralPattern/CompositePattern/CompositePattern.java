import java.util.*;
interface MovieDirectory {
	public void movie();
}

class Movie implements MovieDirectory {
	String movieName;

	Movie(String name) {
		this.movieName = name;
	}

	public void movie() {
		System.out.println("movie: " + movieName);
	}
}

class Genre implements MovieDirectory {
	List<MovieDirectory> directories;
	String genreName;

	Genre(String genreName) {
		this.genreName = genreName;
		directories = new ArrayList<>();
	}
	
	public void addMovie(MovieDirectory directory) {
		directories.add(directory);
	}

	public List<MovieDirectory> getDirectories() {
		return directories;
	}

	public void movie() {
		System.out.println("genre: " + genreName);
		for(MovieDirectory directory : directories) {
			directory.movie();
		}
	}

}
public class CompositePattern {
	public static void main(String[] args) {
		Genre baseDirectory = new Genre("Movies Genre");

		Genre horror = new Genre("Horror");
		Genre comedyHorror = new Genre("Comedy Horror");

		MovieDirectory anabelle = new Movie("Anabelle");
		MovieDirectory stree = new Movie("Stree");

		Genre action = new Genre("Action");
		MovieDirectory race = new Movie("Race");

		baseDirectory.addMovie(horror);
		baseDirectory.addMovie(action);
		action.addMovie(race);
		horror.addMovie(comedyHorror);
		horror.addMovie(anabelle);
		comedyHorror.addMovie(stree);

		baseDirectory.movie();

	}
}