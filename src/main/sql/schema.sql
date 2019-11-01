CREATE DATABASE ssmdemo;
USE ssmdemo;
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user(
                        id CHAR(32) NOT NULL,
                        user_name VARCHAR(32) DEFAULT NUll COMMENT "账户名",
                        password VARCHAR(32) DEFAULT NUll COMMENT "密码",
                        name VARCHAR(32) DEFAULT NUll COMMENT "用户名",
                        age int(10) DEFAULT NUll COMMENT "年龄",
                        sex int(2) DEFAULT NULL COMMENT "性别",
                        birthday date DEFAULT NULL COMMENT "用户生日",
                        created TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
                        updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "末次更新时间",
                        PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT="用户表";