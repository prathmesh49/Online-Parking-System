package onlineParkingSystem.com.ops.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;


public class MongoDBConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory("mongodb+srv://root:root@cluster0.cb8c5x3.mongodb.net/temp"));
    }
}
