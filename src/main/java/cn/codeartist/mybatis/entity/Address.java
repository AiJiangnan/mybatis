package cn.codeartist.mybatis.entity;

import lombok.Data;

/**
 * 用户地址实体
 *
 * @author 艾江南
 * @date 2022/5/16
 */
@Data
public class Address {

    private Long id;
    private Long userId;
    private String address;
}
