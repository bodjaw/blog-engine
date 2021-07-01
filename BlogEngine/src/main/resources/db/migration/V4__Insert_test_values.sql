INSERT users(is_moderator, reg_time, name, email, password, code)
VALUES
(0, '2021-06-03 14:00:45', 'Ilmir', 'ilmir@gmail.com', 'ilmir', 'ilmir'),
(1, '2021-05-12 21:10:52', 'Igor', 'igor@gmail.com', 'igor', 'igor');

INSERT tags(name) VALUES ('News');

INSERT posts(is_active, user_id, time, title, text, view_count)
VALUES (1, 1, '2021-06-11 09:03:24', 'SpringBoot + Flyway','Flyway — это инструмент для контроля версии базы данных.', 15);

INSERT post_comments(post_id, user_id, tag_id, time, text)
VALUES (1, 2, 1, '2021-06-12 12:04:36', 'Класс!');

