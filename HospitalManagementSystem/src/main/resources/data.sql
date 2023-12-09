
INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO nurses_roles (nurse_id, role_id)
values (1, 1);

delete from medical_records where id=2;