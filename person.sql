CREATE TABLE person (
    id INTEGER AUTO_INCREMENT COMMENT 'id',
    name VARCHAR(100) COMMENT '姓名',
    english_name VARCHAR(45) COMMENT '英文名',
    age INTEGER UNSIGNED COMMENT '年齡',
    sex VARCHAR(100) COMMENT '性別',
    birthday DATE COMMENT '出生日期',
    description TEXT COMMENT '備註',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP() COMMENT '建立時間',
    PRIMARY KEY (id)
);

INSERT INTO person ( name, english_name, age, sex, birthday, description ) 
VALUES ( '測試', 'Test', '25', '男', '1989-08-09', 'noInfo' );

INSERT INTO person ( name, english_name, age, sex, birthday, description ) 
VALUES ( '科特柯本', 'Kurt Cobain', '27', '男', '1967-02-20', 'Nirvana' );

INSERT INTO person ( name, english_name, age, sex, birthday, description ) 
VALUES ( '王菲', 'Faye', '31', '女', '1969-08-08', '獅子座' );

INSERT INTO person ( name, english_name, age, sex, birthday, description ) 
VALUES ( '艾薇兒', 'Avril Lavigne', '24', '女', '1984-09-27', '星座：天秤座' );

INSERT INTO person ( name, english_name, age, sex, birthday, description ) 
VALUES ( 'W. AXL ROSE', 'W. AXL ROSE', '45', '男', '1962-02-06', 'GNR' );

INSERT INTO person ( name, english_name, age, sex, birthday, description ) 
VALUES ( '柯蒂斯', 'Ian Curtis', '50', '男', '1956-07-15', 'Joy Division' );

INSERT INTO person ( name, english_name, age, sex, birthday, description ) 
VALUES ( '巴菲特', 'Warren Buffett', '78', '男', '1930-08-30', 'Stock' );

