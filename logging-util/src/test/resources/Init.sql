DROP TABLE IF EXISTS `LOG_VALUES`;
CREATE TABLE IF NOT EXISTS `LOG_VALUES` (
    type int(11) NOT NULL,
    message varchar(200) NOT NULL
);