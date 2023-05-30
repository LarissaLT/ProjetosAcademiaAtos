CREATE TABLE `aluno`
(
    `id`           bigint NOT NULL AUTO_INCREMENT,
    `nome`         varchar(255) DEFAULT NULL,
    `curso_id`     bigint       DEFAULT NULL,
    `professor_id` bigint       DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY            `FKhd33lesnacp3tp8sx85r6ygbu` (`curso_id`),
    KEY            `FK9n961qy3j6n1pwei63xitusew` (`professor_id`),
    FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`),
    FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci