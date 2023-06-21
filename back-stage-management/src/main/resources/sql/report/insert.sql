-- 以下是插入 content_category 表的测试数据
INSERT INTO zhipian_shop.zhipian_report (report_content, img_url, user_id, book_id, library_id, gmt_create)
VALUES ('举报内容1', '/path/to/image1.jpg', 1, 1, 1, NOW()),
       ('举报内容2', '/path/to/image2.jpg', 2, 1, 2, NOW()),
       ('举报内容3', '/path/to/image3.jpg', 3, 2, 3, NOW()),
       ('举报内容4', '/path/to/image4.jpg', 4, 2, 4, NOW()),
       ('举报内容5', '/path/to/image5.jpg', 5, 3, 5, NOW()),
       ('举报内容6', '/path/to/image6.jpg', 6, 3, 6, NOW()),
       ('举报内容7', '/path/to/image7.jpg', 7, 4, 7, NOW()),
       ('举报内容8', '/path/to/image8.jpg', 8, 4, 8, NOW()),
       ('举报内容9', '/path/to/image9.jpg', 9, 5, 9, NOW()),
       ('举报内容10', '/path/to/image10.jpg', 10, 5, 10, NOW());