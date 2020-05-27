package org.example;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.entity.City;
import org.example.mapper.CityMapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Optional;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJdbcRepositories
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner test1(ApplicationContext ctx, CityMapper cityMapper){
        return (args) -> {

            Object dataAccessStrategy = ctx.getBean("dataAccessStrategyBean");
            System.out.println("dataAccessStrategy" + dataAccessStrategy);

            System.out.println("运行成功");
            Optional<City> byId = cityMapper.findById("1");
            System.out.println(byId.get());

            boolean b = cityMapper.existsById("1");
            System.out.println("指定ID是否存在："+ b);
        };
    }

}
