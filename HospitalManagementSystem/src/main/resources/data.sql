
INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO nurses_roles (nurse_id, role_id)
values (3, 1);