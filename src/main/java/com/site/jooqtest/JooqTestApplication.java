package com.site.jooqtest;

import com.site.jooqtest.model.tables.Producers;
import com.site.jooqtest.model.tables.records.ProducersRecord;
import com.site.jooqtest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JooqTestApplication implements CommandLineRunner {

  @Autowired
  ProductService productService;

  public static void main(String[] args) {
    SpringApplication.run(JooqTestApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    Producers producer = Producers.PRODUCERS;
    ProducersRecord producersRecord = new ProducersRecord();
    producersRecord.setName("1prod");
    productService.insertProducer(producer, producersRecord);
    productService.getProducerByName("");
  }
}
