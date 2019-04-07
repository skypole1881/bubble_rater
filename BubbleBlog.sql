DROP TABLE IF EXISTS bubble_user;
DROP TABLE IF EXISTS bubble_blog;
DROP TABLE IF EXISTS bubble_rate;
DROP TABLE IF EXISTS bubble_comment;
DROP TABLE IF EXISTS bubble_link;
DROP TABLE IF EXISTS bubble_system;

CREATE TABLE bubble_user(
    `user_id`           int(11) NOT NULL COMMENT '主键',
    `user_name`         varchar(254) DEFAULT NULL COMMENT '帳號',
    `user_password`     varchar(254) DEFAULT NULL COMMENT '密碼',
    `user_email`        varchar(254) DEFAULT NULL COMMENT 'email',
    `admin`             boolean      DEFAULT NULL COMMENT '管理員',
    PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE bubble_blog(
    `blog_id`           int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `title`             varchar(254) DEFAULT NULL COMMENT 'title',
    `store_city`        varchar(254) DEFAULT NULL COMMENT '城市名稱',
    `store_district`    varchar(254) DEFAULT NULL COMMENT '區',
    `store_brand`       varchar(254) DEFAULT NULL COMMENT '店名',
    `store_address`     varchar(254) DEFAULT NULL COMMENT '地址',
    `content`           LONGTEXT     DEFAULT NULL COMMENT '內容',
    `content2`          LONGTEXT     DEFAULT NULL COMMENT '內容',
    `photo_link`        varchar(254) DEFAULT NULL COMMENT '圖片連結',
    `cold`              boolean      DEFAULT NULL COMMENT '冷熱',
    `publish`           boolean      DEFAULT NULL COMMENT '是否發布',
    `likes`              int(11) NOT NULL COMMENT '喜歡',
    `views`             int(11) NOT NULL COMMENT '瀏覽數',
    `version`           int(11) NOT NULL DEFAULT '0' COMMENT '版本',
    `created_dtm`       datetime NOT NULL COMMENT '创建时间',
    `last_modified_dtm` datetime DEFAULT NULL COMMENT '最近修改时间',
    `deleted`           tinyint(1) NOT NULL COMMENT '删除标识',

    PRIMARY KEY (blog_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE bubble_rate(
    `rate_id`           int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `sweetness`         float(11) DEFAULT NULL COMMENT '甜度',
    `bubble_elasticity` float(11) DEFAULT NULL COMMENT '珍珠彈性',
    `tea_concentration` float(11) DEFAULT NULL COMMENT '濃度',
    `godfeeling`        float(11) DEFAULT NULL COMMENT '小編分數',
    `version`           int(11) NOT NULL DEFAULT '0' COMMENT '版本',
    `created_dtm`       datetime NOT NULL COMMENT '创建时间',
    `last_modified_dtm` datetime DEFAULT NULL COMMENT '最近修改时间',
    `deleted`           tinyint(1) NOT NULL COMMENT '删除标识',
    PRIMARY KEY (rate_id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


CREATE TABLE bubble_comment(
    `comment_id`        int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`           int(11) NOT NULL COMMENT '主键',
    `content`           varchar(700) DEFAULT NULL COMMENT '內容',
    `version`           int(11) NOT NULL DEFAULT '0' COMMENT '版本',
    `created_dtm`       datetime NOT NULL COMMENT '创建时间',
    `last_modified_dtm` datetime DEFAULT NULL COMMENT '最近修改时间',
    `deleted`           tinyint(1) NOT NULL COMMENT '删除标识',
    PRIMARY KEY (comment_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE bubble_link(
    `link_id`           int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `link`              varchar(700) DEFAULT NULL COMMENT '連結',
    PRIMARY KEY (link_id)

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE bubble_system(
    `views`             int(11) NOT NULL COMMENT '總瀏覽數'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;



