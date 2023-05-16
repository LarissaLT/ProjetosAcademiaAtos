INSERT INTO produto (codigo, nome, categoria, valor, quantidade)
VALUES
    (1001, 'Dom Casmurro', 'Romance', 39.99, 60),
    (1002, 'O Pequeno Príncipe', 'Infantil', 19.99, 100),
    (1003, 'Memórias Póstumas de Brás Cubas', 'Clássico', 29.99, 80),
    (1004, 'O Alquimista', 'Autoajuda', 24.99, 50),
    (1005, 'Harry Potter e a Pedra Filosofal', 'Fantasia', 34.99, 120),
    (1006, 'O Senhor dos Anéis: A Sociedade do Anel', 'Fantasia', 49.99, 70),
    (1007, '1984', 'Ficção Científica', 27.99, 90),
    (1008, 'A Culpa é das Estrelas', 'Romance', 32.99, 40)

    SELECT * FROM produto ORDER BY codigo ASC;