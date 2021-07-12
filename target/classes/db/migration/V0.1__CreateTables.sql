set foreign_key_checks=0;

CREATE TABLE characteres (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    resourceURI VARCHAR(200),

    modified TIMESTAMP NULL DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL

);

CREATE TABLE list_content(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    available INT(10) UNSIGNED,
    returned INT(10) UNSIGNED,
    collectionURI VARCHAR(200),
    list_type_id BIGINT UNSIGNED NOT NULL,
    charactere_id BIGINT UNSIGNED NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,

    CONSTRAINT FK_list_type_id FOREIGN KEY (list_type_id) REFERENCES list_type(id),
    CONSTRAINT FK_charactere_id FOREIGN KEY (charactere_id) REFERENCES characteres(id)
);


CREATE TABLE item(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    resourceURI VARCHAR(200),
    name VARCHAR(100),
    item_type_id BIGINT UNSIGNED NOT NULL,
    list_content_id BIGINT UNSIGNED NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,

    CONSTRAINT FK_item_type_id FOREIGN KEY (item_type_id) REFERENCES item_type(id),
    CONSTRAINT FK_list_content_id FOREIGN KEY (list_content_id) REFERENCES list_content(id)
);

CREATE TABLE list_type(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE item_type(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) UNIQUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE url(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type  VARCHAR(100),
    url  VARCHAR(200),
    characteres_id BIGINT UNSIGNED NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,

    CONSTRAINT FKcharacteres_id FOREIGN KEY (characteres_id) REFERENCES characteres(id)
);

CREATE TABLE thumbnail(
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    path VARCHAR(200),
    extension VARCHAR(10),

    characteres_id BIGINT UNSIGNED NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);




set foreign_key_checks=1;