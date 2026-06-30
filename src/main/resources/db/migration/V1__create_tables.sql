CREATE TABLE IF NOT EXISTS servers (
    id bigserial PRIMARY KEY,
    name varchar(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS server_mods (
    id bigserial PRIMARY KEY,
    name varchar(60) NOT NULL,
    permissions jsonb NOT NULL
);

CREATE TABLE IF NOT EXISTS permissions (
    id bigserial PRIMARY KEY,
    name varchar(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS command_types (
    id bigserial PRIMARY KEY,
    name varchar(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS commands (
    id bigserial PRIMARY KEY,
    name varchar(60) NOT NULL,
    server_id bigint NOT NULL,
    command_type_id bigint NOT NULL,
    FOREIGN KEY (server_id) REFERENCES servers (id) ON DELETE CASCADE,
    FOREIGN KEY (command_type_id) REFERENCES command_types (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS command_responses (
    id bigserial PRIMARY KEY,
    command_id bigint NOT NULL,
    text text NOT NULL,
    FOREIGN KEY (command_id) REFERENCES commands (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS command_events (
    command_id bigint PRIMARY KEY,
    on_repeat boolean NOT NULL,
    repeat_interval_seconds int,
    FOREIGN KEY (command_id) REFERENCES commands (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS embed (
    id bigserial PRIMARY KEY,
    type VARCHAR(60),
    header varchar(60),
    content varchar(120),
    footer varchar(120),
    image_url varchar(500),
    command_id bigint NOT NULL UNIQUE,
    FOREIGN KEY (command_id) REFERENCES commands (id) ON DELETE CASCADE
);

