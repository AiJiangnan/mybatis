package cn.codeartist.mybatis.mapper;

import cn.codeartist.mybatis.entity.User;

/**
 * 用户接口
 *
 * @author 艾江南
 * @date 2022/5/16
 */
public interface UserExtMapper {

    User selectById(Long id);

    User selectExt(Long id);

    User selectAddresses(Long id);
}
