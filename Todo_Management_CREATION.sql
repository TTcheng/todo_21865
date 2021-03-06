-- 数据库生成脚本
-- 表空间
CREATE BIGFILE TABLESPACE dbsp_todo
  DATAFILE 'D:\ORACLEXE\APP\ORACLE\ORADATA\XE\dbsp_todo.dat'
  SIZE 200 M
  AUTOEXTEND ON NEXT 20 M MAXSIZE 500 M;
CREATE TEMPORARY TABLESPACE dbsp_todo_tmp
  TEMPFILE 'D:\ORACLEXE\APP\ORACLE\ORADATA\XE\dbsp_todo_tmp.dbf'
  SIZE 200 M
  AUTOEXTEND ON NEXT 20 M MAXSIZE 500 M;
-- 用户
CREATE USER todo_mgr IDENTIFIED BY hand DEFAULT TABLESPACE dbsp_todo TEMPORARY TABLESPACE dbsp_todo_tmp QUOTA UNLIMITED ON dbsp_todo;
-- 用户授权
-- GRANT SYSOPER TO TODO_MGR;
GRANT create session TO todo_mgr;
GRANT create table TO todo_mgr;
GRANT create view TO todo_mgr;
GRANT create any trigger TO todo_mgr;
GRANT create any procedure TO todo_mgr;
GRANT create sequence TO todo_mgr;
GRANT create synonym TO todo_mgr;
grant read, write on directory DATA_PUMP_DIR to todo_mgr;
grant select on V_$session to todo_mgr;
grant select on V_$sesstat to todo_mgr;
grant select on V_$statname to todo_mgr;

-- 切换到新用户
alter session set current_schema = TODO_MGR;
-- 建表
-- 用户表
CREATE TABLE CUX_USERS
(
  USER_ID          NUMBER PRIMARY KEY,
  USER_NAME        VARCHAR2(250)        NOT NULL,
  PASSWORD         VARCHAR2(30)         NOT NULL,
  SEX              VARCHAR2(1),
  AGE              NUMBER CHECK (AGE BETWEEN 1 AND 200),
  PHONE_NUMBER     VARCHAR2(30),
  CREATION_DATE    DATE DEFAULT SYSDATE NOT NULL,
  LAST_UPDATE_DATE DATE,
  COMMENTS         VARCHAR2(2000)
);
COMMENT ON TABLE CUX_USERS IS '用户信息表';
COMMENT ON COLUMN CUX_USERS.USER_ID IS '用户ID 主键';
COMMENT ON COLUMN CUX_USERS.USER_NAME IS '用户名称';
COMMENT ON COLUMN CUX_USERS.PASSWORD IS '用户密码';
COMMENT ON COLUMN CUX_USERS.SEX IS '性别M-Male/F-Female';
COMMENT ON COLUMN CUX_USERS.AGE IS '年龄 范围1-200';
COMMENT ON COLUMN CUX_USERS.PHONE_NUMBER IS '电话';
COMMENT ON COLUMN CUX_USERS.CREATION_DATE IS '创建时间';
COMMENT ON COLUMN CUX_USERS.LAST_UPDATE_DATE IS '更新时间';
COMMENT ON COLUMN CUX_USERS.COMMENTS IS '备注';

-- 待办事项表
CREATE TABLE CUX_TODO_ITEMS
(
  TODO_ITEM_ID      NUMBER PRIMARY KEY,
  USER_ID           NUMBER REFERENCES CUX_USERS (USER_ID),
  TODO_ITEM_TITLE   VARCHAR2(250)                NOT NULL,
  TODO_TIEM_CONTENT VARCHAR2(2000),
  PRIORITY          VARCHAR2(10) DEFAULT 'LOW'   NOT NULL CHECK ( PRIORITY IN ('LOW', 'HIGH', 'MEDIUM')),
  CREATION_DATE     DATE         DEFAULT SYSDATE NOT NULL,
  LAST_UPDATE_DATE  DATE,
  COMMENTS          VARCHAR2(2000)
);

COMMENT ON TABLE CUX_TODO_ITEMS IS '待办事项表';
COMMENT ON COLUMN CUX_TODO_ITEMS.TODO_ITEM_ID IS '待办事项ID';
COMMENT ON COLUMN CUX_TODO_ITEMS.USER_ID IS '所属用户ID';
COMMENT ON COLUMN CUX_TODO_ITEMS.TODO_ITEM_TITLE IS '待办事项标题';
COMMENT ON COLUMN CUX_TODO_ITEMS.TODO_TIEM_CONTENT IS '待办事项内容';
COMMENT ON COLUMN CUX_TODO_ITEMS.PRIORITY IS '优先级 LOW/HIGH/MEDIUM';
COMMENT ON COLUMN CUX_TODO_ITEMS.CREATION_DATE IS '创建时间';
COMMENT ON COLUMN CUX_TODO_ITEMS.LAST_UPDATE_DATE IS '更新时间';
COMMENT ON COLUMN CUX_TODO_ITEMS.COMMENTS IS '备注';

-- 创建序列
create sequence SEQ_CUX_ITEM_ID  --Sequence实例名
minvalue 1                                --最小值，可以设置为0
maxvalue 2147483647                       --最大值
start with 1                              --从1开始计数
increment by 1                            --每次加几个
cache 20;

create sequence SEQ_CUX_USER_ID  --Sequence实例名
minvalue 1                                --最小值，可以设置为0
maxvalue 2147483647                       --最大值
start with 1                              --从1开始计数
increment by 1                            --每次加几个
cache 20;

-- 导入数据
INSERT INTO CUX_TODO_ITEMS VALUES(1001,1001,'开会','出项目方案','HIGH',CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ,'很重要');
INSERT INTO CUX_TODO_ITEMS VALUES(1002,1001,'健身','塑造完美体型','LOW',CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP ,'');






