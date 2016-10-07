package br.com.DBPlataformaVideo;

import org.flywaydb.core.Flyway;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Flyway flyway = new Flyway();
    	flyway.setDataSource("jdbc:postgresql://localhost:5432/db_plataformavideos", "postgres", "postgres");
        flyway.migrate();
    }
}
