package org.example;

import org.flywaydb.core.Flyway;

public class FlywayMigrations {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration")
                .dataSource("jdbc:h2:~/test", "", "")
                .load();
        flyway.migrate();
    }
}