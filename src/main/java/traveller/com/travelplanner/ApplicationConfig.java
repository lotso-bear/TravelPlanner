package traveller.com.travelplanner;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableWebMvc
public class ApplicationConfig {

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("traveller.com.travelplanner.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        String RDS_INSTANCE = "travel-planner.cu5gi9o5hjot.us-east-2.rds.amazonaws.com";
        String USERNAME = "admin";
        String PASSWORD = "12345678";
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + RDS_INSTANCE + ":3306/travelplanner?createDatabaseIfNotExist=true&serverTimezone=UTC");
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }

}
