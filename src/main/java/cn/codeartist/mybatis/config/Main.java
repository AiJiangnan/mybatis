package cn.codeartist.mybatis.config;

import cn.codeartist.mybatis.entity.User;
import cn.codeartist.mybatis.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import javax.sql.DataSource;

/**
 * 基于Java配置
 *
 * @author 艾江南
 * @date 2022/5/17
 */
public class Main {

    private static final String DATABASE_DRIVER = "org.h2.Driver";
    private static final String DATABASE_URL = "jdbc:h2:mem:default;MODE=MySQL;INIT=RUNSCRIPT FROM 'classpath:sql/init.sql'";

    public static void main(String[] args) {
        DataSource dataSource = new PooledDataSource(DATABASE_DRIVER, DATABASE_URL, "", "");
        Environment env = new Environment("dev", new ManagedTransactionFactory(), dataSource);

        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setEnvironment(env);
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectById(1L);
            System.out.println(user);
        }
    }
}