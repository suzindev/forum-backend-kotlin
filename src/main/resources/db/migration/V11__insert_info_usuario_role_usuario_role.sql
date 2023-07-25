INSERT INTO usuario(nome, email, password) VALUES('admin', 'admin@email.com', '$2a$12$BIlAKxw3Etg78JqnvYQOkOfgCNVPzSiHzRYkaE8an2H8kmUxf5yfW');
INSERT INTO role(nome) VALUES ('ADMIN');
INSERT INTO usuario_role(usuario_id, role_id) VALUES(2,2);