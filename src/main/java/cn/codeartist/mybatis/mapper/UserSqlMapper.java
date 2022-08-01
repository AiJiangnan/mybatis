package cn.codeartist.mybatis.mapper;

import cn.codeartist.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户接口
 *
 * @author 艾江南
 * @date 2022/5/16
 */
public interface UserSqlMapper {

    List<User> selectByUsername(@Param("username") String username);

    List<User> selectByStatus(@Param("status") Integer status, @Param("username") String username);

    void updateById(User user);

    List<User> selectInIdList(@Param("idList") List<Long> idList);

    @Select("<script>" +
            "SELECT * FROM t_user" +
            "<where>" +
            "   <if test='status != null'>AND status = #{status}</if>" +
            "   <if test='username != null'>AND username = #{username}</if>" +
            "</where>" +
            "</script>")
    List<User> selectByUser(User user);
}
