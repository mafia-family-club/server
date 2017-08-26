package org.overmind.mfk.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.05.2017 18:00
 */
@EntityScan(basePackageClasses = {
    ServerApplication.class,
    Jsr310JpaConverters.class
})
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
