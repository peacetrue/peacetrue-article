DROP TABLE IF EXISTS article3;
CREATE TABLE article3
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    type_id       bigint                            not null comment '类型. descriptiveType',
    type_code     varchar(32)                       not null comment '类型编码',
    cover         VARCHAR(255)                      NOT NULL COMMENT '封面',
    title         VARCHAR(32)                       NOT NULL COMMENT '标题',
    remark        VARCHAR(255)                      NOT NULL COMMENT '备注',
    serial_number bigint                            not null comment '序号',
    creator_id    BIGINT                            NOT NULL COMMENT '创建者主键',
    created_time  DATETIME                          NOT NULL COMMENT '创建时间',
    modifier_id   BIGINT                            NOT NULL COMMENT '修改者主键',
    modified_time DATETIME                          NOT NULL COMMENT '修改时间'
);
