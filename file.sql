CREATE TABLE file (
    id INTEGER AUTO_INCREMENT COMMENT 'id',
    name VARCHAR(256) COMMENT '檔名',
    content BLOB COMMENT '內容',
    PRIMARY KEY (id)
);