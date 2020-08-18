package com.commend.diplomarbeit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
 //@SwaggerEnable2
public class DiplomarbeitApplication {

    // private static final Logger log = LoggerFactory.getLogger(DiplomarbeitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DiplomarbeitApplication.class, args);
    }

   /* @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE rooms IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE rooms(" +
                "number SERIAL, id SERIAL, patientid SERIAL, fn VARCHAR(255), ln VARCHAR(255), content VARCHAR(255))");

        jdbcTemplate.batchUpdate("INSERT INTO rooms(number, id, patientid, fn, ln, content) VALUES (?,?,?,?,?,?)");
    }*/

}
