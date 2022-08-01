package cn.codeartist.mybatis.sql;

import cn.codeartist.mybatis.entity.User;
import cn.codeartist.mybatis.mapper.UserSqlMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * 动态SQL
 *
 * @author 艾江南
 * @date 2022/8/1
 */
public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserSqlMapper userSqlMapper = sqlSession.getMapper(UserSqlMapper.class);
            List<User> users = userSqlMapper.selectByUsername(null);
            System.out.println(users);

            users = userSqlMapper.selectByUsername("ZhangSan");
            System.out.println(users);

            users = userSqlMapper.selectByStatus(0, "ZhangSan");
            System.out.println(users);

            users = userSqlMapper.selectByStatus(1, "ZhangSan");
            System.out.println(users);

            User user = new User();
            user.setId(1L);
            user.setStatus(0);
            userSqlMapper.updateById(user);

            users = userSqlMapper.selectInIdList(Collections.singletonList(1L));
            System.out.println(users);

            user = new User();
            user.setUsername("ZhangSan");
            users = userSqlMapper.selectByUser(user);
            System.out.println(users);

        } finally {
            inputStream.close();
        }
    }
}
