INSERT INTO dom (id, naziv) VALUES
(1, 'Dom A'),
(2, 'Dom B'),
(3, 'Dom C');

INSERT INTO konkurs (id, grad, skolska_godina) VALUES
(1, 'Beograd', '2024/2025'),
(2, 'Novi Sad', '2024/2025');


INSERT INTO soba (id, broj_sobe, dom_id) VALUES
(1, '101', 1),
(2, '201', 2),
(3, '301', 3);


INSERT INTO student (id, username, password, ime, prezime, jmbg, godina_studiranja, osvojeni_bodovi, prosek, bodovi, kartica, soba_id) VALUES
(1, 'maja123', 'maja123', 'Marko', 'Marković', '1234567890123', 2, 120, 8.5, 150.0, 'BUDZET', 1),
(2, 'student2', 'password2', 'Ana', 'Anić', '9876543210123', 3, 90, 7.0, 100.0, 'BUDZET', 2);


INSERT INTO upravnik (id, username, password, ime, prezime, jmbg) VALUES
(1, 'admin', 'admin123', 'Admin', 'Adminović', '1111222233334');

