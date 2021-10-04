CREATE TABLE global_settings
(
    id    int          NOT NULL AUTO_INCREMENT,
    code  VARCHAR(255) NOT NULL,
    name  VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT global_settings(id, code, name, value)
VALUES (1, 'MULTIUSER_MODE', 'Многопользовательский режим', 'NO'),
       (2, 'POST_PREMODERATION', 'Премодерация постов', 'YES'),
       (3, 'STATISTICS_IS_PUBLIC', 'Показывать всем статистику блога', 'NO');