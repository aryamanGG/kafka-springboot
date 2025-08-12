package net.aryamanlearning.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class springbootproducerapplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(springbootproducerapplication.class, args);
    }
    @Autowired
    private  wikimediachangesproducer wikimediachangesproducer;

    @Override
    public void run(String... args) throws Exception {
      wikimediachangesproducer.sendMessage();
    }
}
