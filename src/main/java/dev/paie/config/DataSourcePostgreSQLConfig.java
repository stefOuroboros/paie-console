//package dev.paie.config;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//@EnableJpaRepositories("dev.paie.repository")
//public class DataSourcePostgreSQLConfig {
//	
//    @Bean // gestionnaire de transaction
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(emf);
//        return txManager;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/sirh-paie");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("Jpx39p");
//        return dataSource;
//    }
//    
//    // Bean indispensable pour faire du JPA
//    // Je dois faire du JPA pour faire du springDATA ??
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        // activer les logs SQL
//        vendorAdapter.setShowSql(true);
//    	
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//
//        factory.setJpaVendorAdapter(vendorAdapter);
//        // alternative au persistence.xml
//        factory.setPackagesToScan("dev.paie.entite");
//        factory.setDataSource(dataSource);
//        factory.afterPropertiesSet();
//
//        return factory;
//    }
//    
//
//    
//}