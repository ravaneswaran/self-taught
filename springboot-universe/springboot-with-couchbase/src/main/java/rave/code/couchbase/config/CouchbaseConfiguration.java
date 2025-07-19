package rave.code.couchbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;


@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Value("${spring.couchbase.bootstrap-hosts:localhost}'")
    private String host;

    @Value("${spring.couchbase.bucket.user:Administrator}")
    private String username;

    @Value("${spring.couchbase.bucket.password:password}")
    private String password;

    @Value("${spring.couchbase.bucket.name:user-bucket}")
    private String bucketName;

    @Override
    public String getConnectionString() {
        return "couchbase://localhost";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return "user-bucket";
    }

}
