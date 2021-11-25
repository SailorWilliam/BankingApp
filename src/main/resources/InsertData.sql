INSERT INTO test_db.manager (name, surname, middlename, email, phone_number, username, password)
VALUES
	('Иван', 'Тарасенко', 'Алексеевич', 'ivan@mail.ru', '988-987-56-89', 'ivan', 'ivan'),
	('Ирина', 'Кубанина', 'Владимировна', 'irina@mail.ru', '965-874-55-68', 'irina', 'irina'),
	('Егор', 'Попов', 'Сергеевич', 'egor@mail.ru', '914-714-56-36', 'egor', 'egor');

INSERT INTO test_db.role VALUES(1, "ROLE_USER");
INSERT INTO test_db.role VALUES(2, "ROLE_ADMIN");

INSERT INTO test_db.user VALUES ('1', true, '25', '0', '0', 'admin', 'admin', 'admin', '$2a$10$86jn1A0qj.QPGZ9AY2Rkz.sLAxEXy0DAQRufX28aqfT0GGbGXzT4.', 'admin', '0', 'admin', 'admin', '1');

INSERT INTO test_db.user_roles VALUES (1, 2);