package com.Main.ConfigDataBase;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.Main.RepositoryForMultiDBconfig",  // DB1 repositories
        entityManagerFactoryRef = "entityManagerFactoryDB1",
        transactionManagerRef = "transactionManagerDB1"
)
public class DB1Config {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder1() {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        return new EntityManagerFactoryBuilder(vendorAdapter, new HashMap<>(), null);
    }

    @Bean(name = "BeanDB1")
    public DataSource source1() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/beanDB1");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean(name = "entityManagerFactoryDB1")
    public LocalContainerEntityManagerFactoryBean emf1(
            @Qualifier("BeanDB1") DataSource ds,
            @Qualifier("entityManagerFactoryBuilder1") EntityManagerFactoryBuilder builder) {
        return builder.dataSource(ds)
                .packages("com.Main.EntitysDB1")
                .persistenceUnit("Main").build();
    }

    @Bean(name = "transactionManagerDB1")
    public PlatformTransactionManager tm1(
            @Qualifier("entityManagerFactoryDB1") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
