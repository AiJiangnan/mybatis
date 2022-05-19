package cn.codeartist.mybatis.curd;

import cn.codeartist.mybatis.entity.User;
import cn.codeartist.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 增删改查
 *
 * @author 艾江南
 * @date 2022/5/18
 */
public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> users = userMapper.selectList();
            users.forEach(System.out::println);

            System.out.println();

            // insert
            User user = new User();
            user.setName("码匠");
            user.setUsername("CodeArtist");
            user.setPassword("444444");
            user.setExtend("扩展信息");
            userMapper.insert(user);

            users = userMapper.selectList();
            users.forEach(System.out::println);

            System.out.println();

            // update
            user = new User();
            user.setId(5L);
            user.setPassword("555555");
            user.setExtend("修改后的扩展信息");
            userMapper.updateById(user);

            users = userMapper.selectList();
            users.forEach(System.out::println);

            System.out.println();

            // delete
            userMapper.deleteById(5L);

            users = userMapper.selectList();
            users.forEach(System.out::println);

        } finally {
            inputStream.close();
        }
    }
}
