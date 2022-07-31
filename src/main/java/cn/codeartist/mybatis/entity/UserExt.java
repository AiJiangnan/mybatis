package cn.codeartist.mybatis.entity;

import lombok.Data;

/**
 * 用户扩展信息实体
 *
 * @author 艾江南
 * @date 2022/5/16
 */
@Data
public class UserExt {

    private Long id;
    private Long userId;
    private String phone;
    private String email;
}
