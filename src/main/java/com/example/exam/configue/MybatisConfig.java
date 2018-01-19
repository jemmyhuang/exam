//package com.example.exam.configue;
//
//import com.example.exam.MutiDataSourceConfig.DynamicDataSource;
//import com.github.pagehelper.PageHelper;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@AutoConfigureAfter({DynamicDataSource.class}) //
//@MapperScan(basePackages = {"com.example.exam.dao"}) //
//public class MybatisConfig implements EnvironmentAware {
//
////    @Autowired
////    DataSource dataSource;
//
//    private RelaxedPropertyResolver propertyResolver;
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean() {
//        try {
//            ResourcePatternResolver resourcePatternResolver;
//            resourcePatternResolver = new PathMatchingResourcePatternResolver();
//
//            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
////            bean.setDataSource(dataSource);
//            bean.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
//            bean.setMapperLocations(resourcePatternResolver.getResources(propertyResolver.getProperty("mapper-locations")));
//            bean.setConfigLocation(new DefaultResourceLoader().getResource(propertyResolver.getProperty("configLocation")));
//
//            return bean.getObject();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    /**
//     * Set the {@code Environment} that this object runs in.
//     *
//     * @param environment
//     */
//    @Override
//    public void setEnvironment(Environment environment) {
//        this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
//    }
//
//
//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        //添加配置，也可以指定文件路径
//        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
//        pageHelper.setProperties(p);
//        return pageHelper;
//    }
//
//
//}
