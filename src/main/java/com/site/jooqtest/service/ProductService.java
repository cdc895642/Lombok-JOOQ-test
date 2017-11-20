package com.site.jooqtest.service;


import com.site.jooqtest.model.tables.Producers;
import com.site.jooqtest.model.tables.records.ProducersRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

  @Autowired
  private DSLContext dslContext;

  public void insertProducer(Producers producer, ProducersRecord record){
    dslContext.insertInto(producer).set(record).execute();
  }

  public Result<ProducersRecord> getProducerByName(String name){
    Result<ProducersRecord> records=dslContext.select()
        .from(Producers.PRODUCERS.as("p"))
//        .where(Producers.PRODUCERS.NAME.equal(name))
        .fetch().into(Producers.PRODUCERS);

    for (ProducersRecord record:records){
      System.out.println(record.getName());
    }
    return records;
  }
}
