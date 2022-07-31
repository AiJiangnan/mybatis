CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '真实姓名',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态：0：删除，1：有效',
  PRIMARY KEY (`id`)
) COMMENT '用户表';

INSERT INTO t_user (name,username,password) VALUES ('张三','ZhangSan','000000');
INSERT INTO t_user (name,username,password) VALUES ('李四','LiSi','111111');
INSERT INTO t_user (name,username,password) VALUES ('王五','WangWu','222222');
INSERT INTO t_user (name,username,password) VALUES ('赵六','ZhaoLiu','333333');

CREATE TABLE `t_user_ext` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `phone` varchar(50) NOT NULL COMMENT '真实姓名',
  `email` varchar(20) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) COMMENT '用户扩展表';

INSERT INTO t_user_ext (user_id,phone,email) VALUES (1,'13700001111','test1@test.com');
INSERT INTO t_user_ext (user_id,phone,email) VALUES (2,'13700001112','test2@test.com');
INSERT INTO t_user_ext (user_id,phone,email) VALUES (3,'13700001113','test3@test.com');
INSERT INTO t_user_ext (user_id,phone,email) VALUES (4,'13700001114','test4@test.com');

CREATE TABLE `t_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `address` varchar(50) NOT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`)
) COMMENT '用户地址表';

INSERT INTO t_address (user_id,address) VALUES (1,'北京');
INSERT INTO t_address (user_id,address) VALUES (1,'天津');
INSERT INTO t_address (user_id,address) VALUES (1,'上海');
INSERT INTO t_address (user_id,address) VALUES (1,'湖南');