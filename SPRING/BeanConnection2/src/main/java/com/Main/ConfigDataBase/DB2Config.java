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
        basePackages = "com.Main.RepositoryForMultiDBconfig2", // DB2 repositories
        entityManagerFactoryRef = "entityManagerFactoryDB2",
        transactionManagerRef = "transactionManagerDB2"
)
public class DB2Config {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder2() {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        return new EntityManagerFactoryBuilder(vendorAdapter, new HashMap<>(), null);
    }

    @Bean(name = "BeanDB2")
    public DataSource source2() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/beanDB2");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean(name = "entityManagerFactoryDB2")
    public LocalContainerEntityManagerFactoryBean emf2(
            @Qualifier("BeanDB2") DataSource ds,
            @Qualifier("entityManagerFactoryBuilder2") EntityManagerFactoryBuilder builder) {
        return builder.dataSource(ds)
                .packages("com.Main.EntitysDB2")
                .persistenceUnit("Main").build();
    }

    @Bean(name = "transactionManagerDB2")
    public PlatformTransactionManager tm2(
            @Qualifier("entityManagerFactoryDB2") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
