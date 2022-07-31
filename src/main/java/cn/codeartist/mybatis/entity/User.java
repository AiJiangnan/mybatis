package cn.codeartist.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * 用户实体
 *
 * @author 艾江南
 * @date 2022/5/16
 */
@Data
public class User {

    private Long id;
    private String name;
    private String username;
    private String password;
    private Integer status;

    private UserExt extend;
    private List<Address> addresses;
}
