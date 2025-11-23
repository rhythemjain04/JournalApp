package net.engineeringdigest.journalApp;


import net.engineeringdigest.journalApp.Entity.JournalEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration.class,
        org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration.class
})

public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
    }


}