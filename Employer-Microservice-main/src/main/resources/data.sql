INSERT INTO tbl_sector (id, name, description) VALUES(1, 'Software', 'Desarrollo de Softeare');
INSERT INTO tbl_sector (id, name, description) VALUES(2, 'Marketing', 'Desarrollo de Marketing');
INSERT INTO tbl_sector (id, name, description) VALUES(3, 'Contabilidad', 'Desarrollo de Contabilidad');
INSERT INTO tbl_employer (id, first_name, last_name, number_phone, dni, email, password) VALUES (1, 'Djalma', 'Dioses', '999534343', '242324232', 'dioses1302@gmail.com', 'gadadas');
INSERT INTO tbl_company(id, name , description, country, city, district, direction, ruc, logo, employer_id, sector_id) values
    (1,'Software', 'Software Dev', 'Peru', 'Lima', 'Ventanilla', 'Calle 10','dsfsdsfsdsf', 'dsfsdsd', 1, 1);
INSERT INTO tbl_company(id, name , description, country, city, district, direction, ruc, logo, employer_id, sector_id) values
    (2,'Marketing', 'Web maRKETING', 'Peru', 'Callao', 'Callao', 'Calle 11','dsfsdsfsdsf', 'dsfsdsd', 1, 2);

