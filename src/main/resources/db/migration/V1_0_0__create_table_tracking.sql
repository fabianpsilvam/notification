CREATE TABLE IF NOT EXISTS tracking (
	id serial PRIMARY KEY,
	type varchar(50) NOT NULL,
	user_id varchar(100),
	params varchar(2000) NOT NULL
);

CREATE INDEX tracking_id_index ON tracking(id);
CREATE INDEX tracking_user_index ON tracking("user_id");