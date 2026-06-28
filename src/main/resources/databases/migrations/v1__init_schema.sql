CREATE DATABASE ibaraki_db;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS embed;
DROP TABLE IF EXISTS command_events;
DROP TABLE IF EXISTS command_responses;
DROP TABLE IF EXISTS commands;
DROP TABLE IF EXISTS command_types;
DROP TABLE IF EXISTS permissions;
DROP TABLE IF EXISTS server_mods;
DROP TABLE IF EXISTS servers;

SET FOREIGN_KEY_CHECKS = 1;
    
CREATE TABLE users (
    id BB
)

CREATE TABLE servers (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL
)

CREATE TABLE server_mods(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    permissions JSONB NOT NULL
)

CREATE TABLE permissions(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(15) NOT NULL
)

CREATE TABLE commands(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    server_id BIGINT NOT NULL,
    command_type_id BIGINT NOT NULL,
    FOREIGN KEY (server_id) REFERENCES servers(id) ON DELETE CASCADE
    FOREIGN KEY (command_type_id) REFERENCES command_types(id) ON DELETE CASCADE
)

CREATE TABLE command_types(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL
)

CREATE TABLE command_responses(
    id BIGSERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    FOREIGN KEY (command_id) REFERENCES commands(id) ON DELETE CASCADE
)

CREATE TABLE command_events(
    command_id BIGSERIAL PRIMARY KEY,
    on_repeat BOOLEAN NOT NULL,
    repeat_interval_seconds INT,
    FOREIGN KEY (command_id) REFERENCES commands(id) ON DELETE CASCADE
)

CREATE TABLE embed(
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(60),
    header VARCHAR(60),
    content VARCHAR(120),
    footer VARCHAR(120),
    image_url VARCHAR(500),
    command_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (command_id) REFERENCES commands(id) ON DELETE CASCADE
)

