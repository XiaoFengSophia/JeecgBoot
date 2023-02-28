-- 注意：该页面对应的前台目录为views/byxk文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2023021610126520470', NULL, '白云新科用户表', '/byxk/byxkUserList', 'byxk/ByxkUserList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2023-02-16 10:12:47', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021610126520471', '2023021610126520470', '添加白云新科用户表', NULL, NULL, 0, NULL, NULL, 2, 'byxk:byxk_user:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-16 10:12:47', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021610126520472', '2023021610126520470', '编辑白云新科用户表', NULL, NULL, 0, NULL, NULL, 2, 'byxk:byxk_user:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-16 10:12:47', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021610126520473', '2023021610126520470', '删除白云新科用户表', NULL, NULL, 0, NULL, NULL, 2, 'byxk:byxk_user:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-16 10:12:47', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021610126520474', '2023021610126520470', '批量删除白云新科用户表', NULL, NULL, 0, NULL, NULL, 2, 'byxk:byxk_user:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-16 10:12:47', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021610126520475', '2023021610126520470', '导出excel_白云新科用户表', NULL, NULL, 0, NULL, NULL, 2, 'byxk:byxk_user:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-16 10:12:47', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2023021610126520476', '2023021610126520470', '导入excel_白云新科用户表', NULL, NULL, 0, NULL, NULL, 2, 'byxk:byxk_user:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2023-02-16 10:12:47', NULL, NULL, 0, 0, '1', 0);