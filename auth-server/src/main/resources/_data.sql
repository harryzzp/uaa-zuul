INSERT INTO sys_authority VALUES ('2', 'wyf', NOW(), null, NOW(), '查看demo', 'query-demo');



INSERT INTO sys_role VALUES ('3', 'wyf', NOW(), null, NOW(), '管理员', 'ROLE_ADMIN');
INSERT INTO sys_role VALUES ('4', 'wyf', NOW(), null, NOW(), '普通用户', 'ROLE_USER');


INSERT INTO sys_role_authorities VALUES ('3', '2');




INSERT INTO sys_user VALUES ('5', 'wyf', NOW(), null, NOW(), null, null, null, null, '$2a$10$XOVs4Z1YtPKqKwQVywG9j.xLAqXYRQLGZMGMrZDNbtl6pUC0Weteq', 'admin');
INSERT INTO sys_user VALUES ('6', 'wyf', NOW(), null, NOW(), null, null, null, null, '$2a$10$WjApX3bMw1KfzckGCCOB.eXRNY61ZcwsqpNzc2yiHtjsqnS3LmXAS', 'wyf');


BEGIN;
INSERT INTO sys_user_roles VALUES ('5', '3');
INSERT INTO sys_user_roles VALUES ('6', '4');

