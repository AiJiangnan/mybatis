package cn.codeartist.mybatis.resultmap;

import cn.codeartist.mybatis.entity.User;
import cn.codeartist.mybatis.mapper.UserExtMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 结果映射
 *
 * @author 艾江南
 * @date 2022/7/31
 */
public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserExtMapper userExtMapper = sqlSession.getMapper(UserExtMapper.class);

            User user = userExtMapper.selectById(1L);
            System.out.println(user);

            user = userExtMapper.selectExt(1L);
            System.out.println(user);

            user = userExtMapper.selectAddresses(1L);
            System.out.println(user);

        } finally {
            inputStream.close();
        }
    }
}
