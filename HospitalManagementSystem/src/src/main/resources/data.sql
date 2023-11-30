INSERT INTO nurses (id, first_name, last_name,username, password,age,date_of_birth,
                    phone_number, full_address, professional_number, speciality,
                    education)
VALUES (1, 'Tobi', 'Ivanova', 'Tobito','12345', 28, '1999-08-11',
        '123458','Sofia','125','nurse','master degree');


INSERT INTO roles (id, role )

VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO nurses_roles(nurse_id, role_id)
VALUES (1, 1)