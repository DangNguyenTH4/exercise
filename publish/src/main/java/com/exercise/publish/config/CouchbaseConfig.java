package com.exercise.publish.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
  //    @Value(value = "${}")
  private String connectionString = "couchbase://127.0.0.1";
  //    @Value(value = "${}")
  private String userName = "admin";
  //    @Value(value = "${}")
  private String password = "admin1";
  //    @Value(value = "${}")
  private String bucketName = "data";


  @Override
  public String getConnectionString() {
    return connectionString;
  }

  @Override
  public String getUserName() {
    return userName;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getBucketName() {
    return bucketName;
  }
}
