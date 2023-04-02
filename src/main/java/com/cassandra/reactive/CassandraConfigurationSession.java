package com.cassandra.reactive;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.internal.core.metadata.DefaultEndPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.ReactiveSession;
import org.springframework.data.cassandra.core.cql.session.DefaultBridgedReactiveSession;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.net.InetSocketAddress;

@Configuration
@EnableReactiveCassandraRepositories("com.cassandra.reactive.repository")
public class CassandraConfigurationSession {

        @Bean
        public CqlSession cassandraCqlSession(){
            CqlSessionBuilder cqlSessionBuilder = new CqlSessionBuilder();
            cqlSessionBuilder.withKeyspace("cassandra_test");
            cqlSessionBuilder.addContactEndPoint(new DefaultEndPoint(new InetSocketAddress("127.0.01", 9042)));
            cqlSessionBuilder.withAuthCredentials("cassandra", "cassandra");
            cqlSessionBuilder.withLocalDatacenter("datacenter1");
            return cqlSessionBuilder.build();
        }

        @Bean
        public ReactiveSession reactiveCassandraSession(){
            return new DefaultBridgedReactiveSession(cassandraCqlSession());
        }
}
