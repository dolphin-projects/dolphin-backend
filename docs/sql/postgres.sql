
CREATE TABLE IF NOT EXISTS sys_core_dictionary (
    id                  VARCHAR(50)                 NOT NULL,
    name                VARCHAR(500)                NOT NULL,
    code                VARCHAR(200)                NOT NULL,
    type                VARCHAR(50)                 NOT NULL,
    description         TEXT,
    create_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    update_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_core_dictionary IS '字典表';
COMMENT ON COLUMN sys_core_dictionary.id IS '主键';
COMMENT ON COLUMN sys_core_dictionary.name IS '字典名称';
COMMENT ON COLUMN sys_core_dictionary.code IS '字典代码';
COMMENT ON COLUMN sys_core_dictionary.type IS '字典类型: enum-枚举、tree-树型';
COMMENT ON COLUMN sys_core_dictionary.description IS '描述';
COMMENT ON COLUMN sys_core_dictionary.create_time IS '创建时间';
COMMENT ON COLUMN sys_core_dictionary.update_time IS '修改时间';

CREATE TABLE IF NOT EXISTS sys_core_dictionary_item (
    id                  VARCHAR(50)                 NOT NULL,
    master_id           VARCHAR(50)                 NOT NULL,
    parent_id           VARCHAR(50),
    name                VARCHAR(500)                NOT NULL,
    code                VARCHAR(200)                NOT NULL,
    sort                INTEGER                     NOT NULL DEFAULT 0,
    description         TEXT,
    create_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    update_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_core_dictionary_item IS '字典项表';
COMMENT ON COLUMN sys_core_dictionary_item.id IS '主键';
COMMENT ON COLUMN sys_core_dictionary_item.master_id IS '主表主键';
COMMENT ON COLUMN sys_core_dictionary_item.parent_id IS '父节点主键，如果为空则表示当前节点是根节点';
COMMENT ON COLUMN sys_core_dictionary_item.name IS '字典项名称';
COMMENT ON COLUMN sys_core_dictionary_item.code IS '字典项代码';
COMMENT ON COLUMN sys_core_dictionary_item.sort IS '字典项排序，升序排列，默认0';
COMMENT ON COLUMN sys_core_dictionary_item.description IS '描述';
COMMENT ON COLUMN sys_core_dictionary_item.create_time IS '创建时间';
COMMENT ON COLUMN sys_core_dictionary_item.update_time IS '修改时间';

INSERT INTO sys_core_dictionary(id, name, code, type)
VALUES ('019b833d-7bd0-7ead-8227-5af8e18a912e', '通用-是否', 'common.yesno', 'enum'),
       ('019b833d-7bd2-7521-83c6-7e0d4b48c942', '通用-启用', 'common.enabled', 'enum'),
       ('019ac45a-124d-7fe6-9a03-b9b9c54aacd0', '表-字典-类型', 'table.sys_core_dictionary.type', 'enum'),
       ('019af983-e2bb-7bfc-bf7d-61b8e503845a', '表-序列-类型', 'table.sys_core_sequence.type', 'enum');

INSERT INTO sys_core_dictionary_item(id, master_id, name, code, sort)
VALUES ('019b8341-f2d7-7ab6-8b3b-52ff9759fb55', '019b833d-7bd0-7ead-8227-5af8e18a912e', '是', '1', 0), -- 通用-是否
       ('019b8341-f2d9-7ad9-b768-d84cc93bca6a', '019b833d-7bd0-7ead-8227-5af8e18a912e', '否', '0', 1),
       ('019b8341-f2d9-77fe-9e9e-68a61ebb9919', '019b833d-7bd2-7521-83c6-7e0d4b48c942', '启用', '1', 1), -- 通用-启用
       ('019b8341-f2d9-7d31-844b-898d49f65556', '019b833d-7bd2-7521-83c6-7e0d4b48c942', '禁用', '0', 1),
       ('019ac45c-e548-7bf5-845f-702bc75ba8a4', '019ac45a-124d-7fe6-9a03-b9b9c54aacd0', '枚举', 'enum', 0), -- 表-字典-类型
       ('019ac45f-6a73-7dad-8334-1961f75ffc7d', '019ac45a-124d-7fe6-9a03-b9b9c54aacd0', '树型', 'tree', 1),
       ('019af986-af9f-7902-9f96-0dafce926f25', '019af983-e2bb-7bfc-bf7d-61b8e503845a', '全局', 'global', 0), -- 表-序列-类型
       ('019af986-eeed-7511-ada5-a2918d38d2c2', '019af983-e2bb-7bfc-bf7d-61b8e503845a', '年度', 'year', 1),
       ('019af987-15e0-70df-af9c-da7847f9f7dc', '019af983-e2bb-7bfc-bf7d-61b8e503845a', '季度', 'quarter', 2),
       ('019af987-59e5-7068-8969-c42cc6ba2b26', '019af983-e2bb-7bfc-bf7d-61b8e503845a', '月度', 'month', 3),
       ('019af987-82b1-7983-9a0e-0d2c3d3e0ea8', '019af983-e2bb-7bfc-bf7d-61b8e503845a', '日度', 'day', 4);

CREATE TABLE IF NOT EXISTS sys_core_sequence (
    id                  VARCHAR(50)                 NOT NULL,
    name                VARCHAR(500)                NOT NULL,
    code                VARCHAR(200)                NOT NULL,
    type                VARCHAR(50)                 NOT NULL,
    min_value           BIGINT                      NOT NULL DEFAULT 0,
    inc_value           BIGINT                      NOT NULL DEFAULT 1,
    description         TEXT,
    create_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    update_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_core_sequence IS '序列表';
COMMENT ON COLUMN sys_core_sequence.id IS '主键';
COMMENT ON COLUMN sys_core_sequence.name IS '序列名称';
COMMENT ON COLUMN sys_core_sequence.code IS '序列代码';
COMMENT ON COLUMN sys_core_sequence.type IS '序列类型';
COMMENT ON COLUMN sys_core_sequence.min_value IS '序列最小值';
COMMENT ON COLUMN sys_core_sequence.inc_value IS '序列递增值';
COMMENT ON COLUMN sys_core_sequence.description IS '描述';
COMMENT ON COLUMN sys_core_sequence.create_time IS '创建时间';
COMMENT ON COLUMN sys_core_sequence.update_time IS '修改时间';

CREATE TABLE IF NOT EXISTS sys_core_sequence_item (
    id                  VARCHAR(50)                 NOT NULL,
    master_id           VARCHAR(50)                 NOT NULL,
    value               BIGINT                      NOT NULL,
    year                INTEGER,
    quarter             INTEGER,
    month               INTEGER,
    day                 INTEGER,
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_core_sequence_item IS '序列项表';
COMMENT ON COLUMN sys_core_sequence_item.id IS '主键';
COMMENT ON COLUMN sys_core_sequence_item.master_id IS '主表主键';
COMMENT ON COLUMN sys_core_sequence_item.value IS '序列项值';
COMMENT ON COLUMN sys_core_sequence_item.year IS '序列项年度';
COMMENT ON COLUMN sys_core_sequence_item.quarter IS '序列项季度';
COMMENT ON COLUMN sys_core_sequence_item.month IS '序列项月度';
COMMENT ON COLUMN sys_core_sequence_item.day IS '序列项日度';

CREATE TABLE IF NOT EXISTS sys_rbac_region (
    id                  VARCHAR(50)                 NOT NULL,
    parent_id           VARCHAR(50),
    name                VARCHAR(500)                NOT NULL,
    code                VARCHAR(200)                NOT NULL,
    ext_code            VARCHAR(200),
    sort                INTEGER                     NOT NULL DEFAULT 0,
    description         TEXT,
    create_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    update_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_rbac_region IS '区划项';
COMMENT ON COLUMN sys_rbac_region.id IS '主键';
COMMENT ON COLUMN sys_rbac_region.parent_id IS '父节点主键，如果为空则表示当前节点是根节点';
COMMENT ON COLUMN sys_rbac_region.name IS '区划名称';
COMMENT ON COLUMN sys_rbac_region.code IS '区划代码';
COMMENT ON COLUMN sys_rbac_region.ext_code IS '区划扩展代码';
COMMENT ON COLUMN sys_rbac_region.sort IS '区划排序，升序排列，默认0';
COMMENT ON COLUMN sys_rbac_region.description IS '描述';
COMMENT ON COLUMN sys_rbac_region.create_time IS '创建时间';
COMMENT ON COLUMN sys_rbac_region.update_time IS '修改时间';

CREATE TABLE IF NOT EXISTS sys_rbac_department (
    id                  VARCHAR(50)                 NOT NULL,
    region_id           VARCHAR(50),
    parent_id           VARCHAR(50),
    name                VARCHAR(500)                NOT NULL,
    code                VARCHAR(200)                NOT NULL,
    sort                INTEGER                     NOT NULL DEFAULT 0,
    description         TEXT,
    create_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    update_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_rbac_department IS '部门表';
COMMENT ON COLUMN sys_rbac_department.id IS '主键';
COMMENT ON COLUMN sys_rbac_department.region_id IS '区划ID';
COMMENT ON COLUMN sys_rbac_department.parent_id IS '上级部门ID';
COMMENT ON COLUMN sys_rbac_department.name IS '部门名称';
COMMENT ON COLUMN sys_rbac_department.code IS '部门代码';
COMMENT ON COLUMN sys_rbac_department.sort IS '部门排序';
COMMENT ON COLUMN sys_rbac_department.description IS '描述';
COMMENT ON COLUMN sys_rbac_department.create_time IS '创建时间';
COMMENT ON COLUMN sys_rbac_department.update_time IS '修改时间';

INSERT INTO sys_rbac_department(id, name, code, sort)
    VALUES ('019ac468-16b9-7abc-8f2d-7a8d59034969', '系统管理部', 'DEPT00001', 0);

CREATE TABLE IF NOT EXISTS sys_rbac_role (
    id                  VARCHAR(50)                 NOT NULL,
    name                VARCHAR(500)                NOT NULL,
    code                VARCHAR(200)                NOT NULL,
    sort                INTEGER                     NOT NULL DEFAULT 0,
    description         TEXT,
    create_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    update_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_rbac_role IS '角色表';
COMMENT ON COLUMN sys_rbac_role.id IS '主键';
COMMENT ON COLUMN sys_rbac_role.name IS '角色名称';
COMMENT ON COLUMN sys_rbac_role.code IS '角色代码';
COMMENT ON COLUMN sys_rbac_role.sort IS '角色排序';
COMMENT ON COLUMN sys_rbac_role.description IS '描述';
COMMENT ON COLUMN sys_rbac_role.create_time IS '创建时间';
COMMENT ON COLUMN sys_rbac_role.update_time IS '修改时间';

INSERT INTO sys_rbac_role
    VALUES ('019ac46a-bf32-7183-a119-45d09f982a31', '系统管理员', 'ROLE00001', 0);

CREATE TABLE IF NOT EXISTS sys_rbac_user (
    id                  VARCHAR(50)                 NOT NULL,
    username            VARCHAR(500)                NOT NULL,
    nickname            VARCHAR(500),
    password            VARCHAR(200)                NOT NULL,
    enabled             VARCHAR(2)                  NOT NULL DEFAULT '1',
    description         TEXT,
    create_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    update_time         TIMESTAMP                 NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);
COMMENT ON TABLE sys_rbac_user IS '用户表';
COMMENT ON COLUMN sys_rbac_user.id IS '主键';
COMMENT ON COLUMN sys_rbac_user.username IS '用户名称';
COMMENT ON COLUMN sys_rbac_user.nickname IS '用户昵称';
COMMENT ON COLUMN sys_rbac_user.password IS '用户密码';
COMMENT ON COLUMN sys_rbac_user.enabled IS '是否启用，见字典：通用-启用';
COMMENT ON COLUMN sys_rbac_user.description IS '描述';
COMMENT ON COLUMN sys_rbac_user.create_time IS '创建时间';
COMMENT ON COLUMN sys_rbac_user.update_time IS '修改时间';

-- 用户：admin/123456
INSERT INTO sys_rbac_user
VALUES ('019ac46c-5a72-7af2-932b-bf0a31741e98', 'admin', '管理员', '$2a$10$5XwMwhPjHEL8XPsR1bgfQuBnOtCC5u3Y/CdD3MbTFMUiEFcazlYMq', '1');

CREATE TABLE IF NOT EXISTS sys_rbac_user_department (
    user_id                  VARCHAR(50)                 NOT NULL,
    department_id            VARCHAR(50)                 NOT NULL,
    PRIMARY KEY (user_id, department_id)
);
COMMENT ON TABLE sys_rbac_user_department IS '用户部门表';
COMMENT ON COLUMN sys_rbac_user_department.user_id IS '用户ID';
COMMENT ON COLUMN sys_rbac_user_department.department_id IS '部门ID';

INSERT INTO sys_rbac_user_department
VALUES ('019ac46c-5a72-7af2-932b-bf0a31741e98', '019ac468-16b9-7abc-8f2d-7a8d59034969');

CREATE TABLE IF NOT EXISTS sys_rbac_user_role (
    user_id                  VARCHAR(50)                 NOT NULL,
    role_id                  VARCHAR(50)                 NOT NULL,
    PRIMARY KEY (user_id, role_id)
);
COMMENT ON TABLE sys_rbac_user_role IS '用户部门表';
COMMENT ON COLUMN sys_rbac_user_role.user_id IS '用户ID';
COMMENT ON COLUMN sys_rbac_user_role.role_id IS '角色ID';

INSERT INTO sys_rbac_user_role
VALUES ('019ac46c-5a72-7af2-932b-bf0a31741e98', '019ac46a-bf32-7183-a119-45d09f982a31');
