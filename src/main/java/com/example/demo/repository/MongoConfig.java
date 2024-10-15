// package com.example.demo.repository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.mongodb.core.MongoTemplate;
// import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

// import javax.annotation.PostConstruct;

// @Configuration
// public class MongoConfig {

//     @Autowired
//     private MongoTemplate mongoTemplate;

//     @PostConstruct
//     public void init() {
//         try {
//             // Attempt to fetch the database name to check connection
//             String dbName = mongoTemplate.getDb().getName();
//             System.out.println("Connected to MongoDB database: " + dbName);
//         } catch (Exception e) {
//             System.err.println("Failed to connect to MongoDB: " + e.getMessage());
//         }
//     }
// }

