package maksim_ya.listofemployees.conf;

import maksim_ya.listofemployees.dao.EmployeeDao;
import maksim_ya.listofemployees.dao.EmployeeDaoImpl;
import maksim_ya.listofemployees.service.EmployeeService;
import maksim_ya.listofemployees.service.EmployeeServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("maksim_ya.listofemployees")
public class Conf {


    /**
     * Initialize dataSource
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/listofemployees");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL,true );
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO,"update");
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean (){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setPackagesToScan("maksim_ya.listofemployees.model");
        return sessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager platformTransactionManager(SessionFactory sessionFactoryBean) {
        HibernateTransactionManager platformTransactionManager = new HibernateTransactionManager();
        platformTransactionManager.setSessionFactory(sessionFactoryBean);


        return platformTransactionManager;
    }

//    @Bean
//    public EmployeeDaoImpl employeeDao(){
//        return  employeeDao();
//    }
//    @Bean
//    public EmployeeServiceImpl employeeService(){
//        return  employeeService();
//    }
}
