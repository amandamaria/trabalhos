package dbletralivre;

import org.flywaydb.core.Flyway;
abstract class Main {
	 public static void main(String[] args) {
		Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:postgresql://localhost:5432/dbletralivre", "postgres", "postgres");
	    flyway.migrate();
	}
}
