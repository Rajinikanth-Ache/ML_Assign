package com.bhavna.springjpa.config;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan({ "com.bhavna.springjpa" })
@EnableJpaRepositories(basePackages = "com.bhavna.springjpa.repository")
public class JpaConfig {
	
	 @Autowired
	    private Environment environment;
	 
	 public JpaConfig() {
		 super();
	 }

	    
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean.setPackagesToScan(new String[] { "com.bhavna.springjpa.entity" });

	        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	        entityManagerFactoryBean.setJpaProperties(hibernateProperties());

	        return entityManagerFactoryBean;
	    }
	    
	    final Properties hibernateProperties() {
	        final Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
	        hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
	        hibernateProperties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
	        
	        return hibernateProperties;
	    }

	    
	    @Bean
	    public DataSource dataSource() {
	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getProperty("jdbc.url"));
	        dataSource.setUsername(environment.getProperty("jdbc.username"));
	        dataSource.setPassword(environment.getProperty("jdbc.password"));
	        return dataSource;
	    }

	   
	    @Bean
	    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	        final JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }
	    
	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }
	  

}
