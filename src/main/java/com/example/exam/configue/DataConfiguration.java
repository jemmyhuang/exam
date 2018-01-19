//package com.example.exam.configue;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.core.env.Environment;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//
//@Configuration
//@EnableTransactionManagement
//public class DataConfiguration implements EnvironmentAware {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(DataConfiguration.class);
//
//    private RelaxedPropertyResolver propertyResolver;
//
//    @Bean(name = "dataSource")
//    @Primary
//    public DataSource dataSource() {
//        DruidDataSource datasource = new DruidDataSource();
//
//        datasource.setDriverClassName(propertyResolver.getProperty("driverClass"));
//        datasource.setUrl(propertyResolver.getProperty("url"));
//        datasource.setUsername(propertyResolver.getProperty("username"));
//        datasource.setPassword(propertyResolver.getProperty("password"));
//        //其它配置
//        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initialSize")));
//        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("minIdle")));
//        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("maxActive")));
//        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("maxWait")));
//        datasource.setTimeBetweenEvictionRunsMillis(Long.valueOf(propertyResolver.getProperty("timeBetweenEvictionRunsMillis")));
//        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("minEvictableIdleTimeMillis")));
//        datasource.setValidationQuery(propertyResolver.getProperty("validationQuery"));
//        datasource.setTestWhileIdle(Boolean.valueOf(propertyResolver.getProperty("testWhileIdle")));
//        datasource.setTestOnBorrow(Boolean.valueOf(propertyResolver.getProperty("testOnBorrow")));
//        datasource.setTestOnReturn(Boolean.valueOf(propertyResolver.getProperty("testOnReturn")));
//        datasource.setPoolPreparedStatements(Boolean.valueOf(propertyResolver.getProperty("poolPreparedStatements")));
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(propertyResolver.getProperty("maxPoolPreparedStatementPerConnectionSize")));
//        try {
//            datasource.setFilters(propertyResolver.getProperty("filters"));
//        } catch (SQLException e) {
//            LOGGER.error("druid configuration initialization filter", e);
//        }
//        return datasource;
//    }
//
//
//    @Bean
//    public ResourceBundleMessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("config.message");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        this.propertyResolver = new RelaxedPropertyResolver(environment,"jdbc.datasource.");
//    }
//}