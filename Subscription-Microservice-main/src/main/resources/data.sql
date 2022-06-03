INSERT INTO tbl_subscription (id, name, description, limit_postulations, duration) VALUES(1, 'Silver', 'Plan Silver', '5', '1');
INSERT INTO tbl_subscription (id, name, description, limit_postulations, duration) VALUES(2, 'Gold', 'Plan Gold', '7', '2');
INSERT INTO tbl_subscription (id, name, description, limit_postulations, duration) VALUES(3, 'Diamond', 'Plan Diamond', '10', '3');

INSERT INTO tbl_employer (id, first_name, last_name, dni, email, password, number_phone) VALUES (1, 'Djalma', 'Dioses', '9534231', 'dioses1302@gmil.com', 'djalma', '990679542');
INSERT INTO tbl_employer (id, first_name, last_name, dni, email, password, number_phone) VALUES (2, 'Diego', 'Gonzales', '2402423', 'diego13242@gmil.com', 'diego', '953432423');
INSERT INTO tbl_employer (id, first_name, last_name, dni, email, password, number_phone) VALUES (3, 'Pedro', 'Lopez', '0423423', 'plopez241@gmil.com', 'plopez', '3524223423');

INSERT INTO tbl_postulant (id, first_name, last_name, document, number, email, password, birthday, civil_status) VALUES (1, 'Luis', 'Castillo', '9534232', '990534235', 'luisc1302@gmil.com', 'pluis', '2001-11-1', 'Soltero');

INSERT INTO tbl_postulant_subscription(id, employer_id, subscription_id, date) VALUES (1, 1, 1, '2001-11-1');
INSERT INTO tbl_postulant_subscription(id, employer_id, subscription_id, date) VALUES (2, 1, 3, '2010-11-2');
INSERT INTO tbl_postulant_subscription(id, employer_id, subscription_id, date) VALUES (3, 1, 3, '2019-11-2');

INSERT INTO tbl_employer_subscription(id, employer_id, subscription_id, date) VALUES (1, 1, 1, '2001-11-1');
INSERT INTO tbl_employer_subscription(id, employer_id, subscription_id, date) VALUES (2, 1, 3, '2010-11-2');
INSERT INTO tbl_employer_subscription(id, employer_id, subscription_id, date) VALUES (3, 1, 3, '2019-11-2');

