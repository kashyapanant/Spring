package config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoDataSourceConfig extends AbstractMongoClientConfiguration {


    @Override
    public String getDatabaseName() {
        return "bagginsdb";
    }

   @Override
    public MongoClient mongoClient(){
       ConnectionString connectionString = new ConnectionString
               ("mongodb+srv://mongoUser:mongoPassword@cluster0.r9png.mongodb.net/bagginsdb" +
                       "?retryWrites=true&w=majority");
       MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
               .applyConnectionString(connectionString)
               .build();
       return MongoClients.create(mongoClientSettings);
   }

   @Override
    public Collection<String> getMappingBasePackages(){
        return Collections.singleton("com.infinity.co");
   }

}
