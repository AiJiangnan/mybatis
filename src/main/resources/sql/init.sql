CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '真实姓名',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `extend` varchar(500) DEFAULT NULL COMMENT '扩展信息',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态：0：删除，1：有效',
  PRIMARY KEY (`id`)
) COMMENT '用户表';

INSERT INTO t_user (name,username,password,extend) VALUES ('张三','ZhangSan','000000','扩展信息');
INSERT INTO t_user (name,username,password,extend) VALUES ('李四','LiSi','111111','扩展信息');
INSERT INTO t_user (name,username,password,extend) VALUES ('王五','WangWu','222222','扩展信息');
INSERT INTO t_user (name,username,password,extend) VALUES ('赵六','ZhaoLiu','333333','扩展信息');
