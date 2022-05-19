package cn.codeartist.mybatis.mapper;

import cn.codeartist.mybatis.entity.User;

import java.util.List;

/**
 * 用户接口
 *
 * @author 艾江南
 * @date 2022/5/16
 */
public interface UserMapper {

    User selectById(Long id);

    List<User> selectList();

    void insert(User user);

    void updateById(User user);

    void deleteById(Long id);
}
