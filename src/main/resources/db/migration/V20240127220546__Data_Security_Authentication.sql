insert into s_roles(id, name)
values ('Ch79ShX11PSeViQp5tTcUxBDTijrrM', 'ADMIN');

-- password: admin768896
insert into s_users(id, active, password, username, id_role)
values ('BOkSsCJoKU1LemUiwjBdoQ9sa29uJB', true, '$2a$12$C19TTaHC64ToDv3kTQsx0emPIjyZlooMLDrknkUzK3HHaqFvULtJO', 'admin', 'Ch79ShX11PSeViQp5tTcUxBDTijrrM');

insert into s_permissions(id, permission_label, permission_value)
values ('P001', 'PRODUCT_READ', 'PRODUCT::READ'),
       ('P002', 'PRODUCT_WRITE', 'PRODUCT::WRITE'),
       ('P003', 'EMPLOYE_READ', 'EMPLOYE::READ'),
       ('P004', 'EMPLOYE_WRITE', 'EMPLOYE::WRITE');

insert into s_roles_permissions(id_role, id_permission)
values ('Ch79ShX11PSeViQp5tTcUxBDTijrrM', 'P001'),
       ('Ch79ShX11PSeViQp5tTcUxBDTijrrM', 'P002'),
       ('Ch79ShX11PSeViQp5tTcUxBDTijrrM', 'P003'),
       ('Ch79ShX11PSeViQp5tTcUxBDTijrrM', 'P004');