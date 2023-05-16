
CREATE TABLE produto (
      id INT AUTO_INCREMENT PRIMARY KEY,
      random_id INT UNSIGNED,
      random_id_trigger INT UNSIGNED,
      UNIQUE (random_id),
      codigo     INT            NOT NULL UNIQUE,
      nome       VARCHAR(50)    NOT NULL,
      categoria  VARCHAR(50),
      valor      DECIMAL(10, 2) NOT NULL,
      quantidade INT            NOT NULL);

      DELIMITER //
      CREATE TRIGGER random_id_trigger BEFORE INSERT ON produto
      FOR EACH ROW
      BEGIN
        DECLARE random_value INT UNSIGNED;
        SET random_value = FLOOR(RAND() * 1000000);
        WHILE EXISTS(SELECT 1 FROM sua_tabela WHERE random_id = random_value) DO
          SET random_value = FLOOR(RAND() * 1000000);
        END WHILE;
        SET NEW.random_id = random_value;
      END //
      DELIMITER ;