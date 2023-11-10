package com.croptalk.app.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
  @Value("${mongodb+srv://matheusfstaveira:qwerty123456@croptalkbd.zwhq7p8.mongodb.net/?retryWrites=true&w=majority}")
  private String mongoUri;

  @Value("${CropTalkBd}")
  private String databaseName;

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create(mongoUri);
  }

  @Bean
  public MongoTemplate mongoTemplate() {
    return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoClient(), databaseName));
  }
}