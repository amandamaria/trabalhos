package dbletralivre;

import org.flywaydb.core.Flyway;

public class DBLetraLivreMigration {
	public void execute(String userDB, String passwordDB) {
		Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:postgresql://localhost:5432/dbletralivre", userDB, passwordDB);
	    flyway.migrate();
	}
}
