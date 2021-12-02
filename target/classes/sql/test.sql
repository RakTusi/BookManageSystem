INSERT INTO booksysdb.book (id, book_info_id, register_time, registrant, state, borrow_info_id) VALUES (1, 1, '2021-12-01 00:00:00', 1, 1, 1);
INSERT INTO booksysdb.book (id, book_info_id, register_time, registrant, state, borrow_info_id) VALUES (2, 1, '2021-12-01 00:00:00', 1, 0, null);
INSERT INTO booksysdb.book (id, book_info_id, register_time, registrant, state, borrow_info_id) VALUES (3, 1, '2021-12-01 00:00:00', 1, 0, null);
INSERT INTO booksysdb.book (id, book_info_id, register_time, registrant, state, borrow_info_id) VALUES (4, 2, '2021-12-01 00:00:00', 1, 0, null);
INSERT INTO booksysdb.book (id, book_info_id, register_time, registrant, state, borrow_info_id) VALUES (5, 2, '2021-12-01 00:00:00', 1, 0, null);
INSERT INTO booksysdb.book (id, book_info_id, register_time, registrant, state, borrow_info_id) VALUES (6, 1, '2021-12-01 01:54:26', 1, 3, null);

INSERT INTO booksysdb.book_info (id, title, author, profile, category, edition, press, publish_date, storage, price, deposit, picture) VALUES (1, 'Java核心技术', '昊斯特曼 (Horstmann Cay S.),Gary Cornell', 'Java教材书，内含大量Java技术的使用教学。', '科学技术', '8', '电子工业出版社', '2011-07-01', 10, 99, 50, null);
INSERT INTO booksysdb.book_info (id, title, author, profile, category, edition, press, publish_date, storage, price, deposit, picture) VALUES (2, 'JAVA核心技术(清华版)', '白文荣、王晓燕', '清华大学出版的Java教材书。', '科学技术', '1', '清华大学出版社', '2018-01-01', 10, 50, 30, null);

INSERT INTO booksysdb.borrow_info (id, book_info_id, book_id, user_id, create_time, state, handler, handle_time, return_time, is_renewed, days) VALUES (1, 1, 1, 2, '2021-12-01 01:32:10', 1, 1, '2021-12-01 01:33:04', null, 0, 15);

INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (1, 'admin', '$2a$10$onl.iSlUTSdiUkalxdbq7.nY7wOUDQYKDqhpsdV2zW2hlRsTNnNvq', '2021-11-20 03:09:13', 1, '邓浩健', '2000-05-17', 0, '15089664540', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (2, 'user1', '$2a$10$onl.iSlUTSdiUkalxdbq7.nY7wOUDQYKDqhpsdV2zW2hlRsTNnNvq', '2021-11-27 18:05:34', 0, '张三', '1999-11-27', 0, '12345678910', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (3, 'user2', '$2a$10$onl.iSlUTSdiUkalxdbq7.nY7wOUDQYKDqhpsdV2zW2hlRsTNnNvq', null, 0, '李四', '2021-11-05', 0, '11111111111', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (7, 'user3', '1231231213', null, 0, '小红', '2021-11-11', 0, '123123213123', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (8, 'user5', '$2a$10$Zyxc2qSAxC9LpjCPXU33Y.dmrxVZxmG./IBkgPdfzp.Nzy.0BoTUa', '2021-11-28 20:56:54', 0, 'aaaa', '2021-11-28', 1, '123213123', 0, 80, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (10, 'user123', '$2a$10$tUF4./NdYS.dQVzRp/QADuetWE1VQzWYb1Gt82ueQz8wyEmndviB.', '2021-11-28 23:38:15', 0, 'adsadad', '2021-11-28', 1, '1312323231', 0, 90, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (12, 'user1212', '$2a$10$df6lq0WkulkkI3dC25LLPutSgO0XMyaA6UMhVmftsMpWDc40YZNwu', '2021-11-28 23:40:49', 0, 'asdsddda', '2021-11-28', 0, '123123', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (13, 'u123', '$2a$10$TMrBm0tqepUMwBEYQQpaPOAbQQNwYlM9IvahWHbqOYYWG9dCQGIKu', '2021-11-28 23:41:23', 0, 'adsasd', '2021-11-28', 0, '123456', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (14, 'user12', '$2a$10$3ZmiInyeho5BdV/cfdCHqei9TzCPJsiksT4CjWaCpQV5GrTX6Liba', '2021-11-28 23:41:49', 0, 'qwe', '2021-11-28', 0, '123', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (15, 'user321', '$2a$10$bdSzOSwdXppdQm50K5LHy.1ULz9C0x.LUBwQn/qhRJC/LvaQdO4cm', '2021-11-28 23:42:44', 0, 'asddsa', '2021-11-28', 0, '123', 1, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (16, 'abc', '$2a$10$NnSxxDH6Q0b.U9WtRyazI.RN53q4k63CXbCjQM6b9L17OxDB6AGFi', '2021-11-28 23:43:06', 0, 'abc', '2021-11-28', 0, '123', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (17, 'abcd', '$2a$10$XROZJ4WuJa/yfwTfWefZ7eH9ZJBjrwv/XyBDtU4AZ1q.1QYegn0PG', '2021-11-28 23:43:28', 0, 'qweewq', '2021-11-28', 0, '123', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (18, 'userabc', '$2a$10$Bt42ezPMfHJIdO7sC9IAleUldN9WuLhv10pqYzQRMbGTe6BxFnlum', '2021-11-28 23:44:05', 0, 'userabc', '2021-11-28', 0, '123', 0, 100, 0);
INSERT INTO booksysdb.user (id, username, password, register_time, status, name, birthdate, gender, phone, balance, credit, state) VALUES (19, 'hello', '$2a$10$CiSO.29kBs21oitpEu1zYu0maU/JImV/Gb.xT7YcSOzq13rz/Z04m', '2021-11-29 00:22:50', 0, 'abcdefg', '2021-11-29', 1, '1234', 0, 100, 0);