package com.commend.diplomarbeit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DiplomarbeitApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DiplomarbeitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DiplomarbeitApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE rooms IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE rooms(" +
                "number SERIAL, id SERIAL, patientid SERIAL, fn VARCHAR(255), ln VARCHAR(255), content VARCHAR(255))");

        jdbcTemplate.batchUpdate("INSERT INTO rooms(number, id, patientid, fn, ln, content) VALUES (?,?,?,?,?,?)");
    }
}
