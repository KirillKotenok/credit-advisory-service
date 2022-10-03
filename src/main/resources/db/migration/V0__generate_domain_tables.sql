CREATE TABLE IF NOT EXISTS advisors
(
    id         BIGSERIAL,
    first_name TEXT NOT NULL,
    last_name  TEXT NOT NULL,
    role       TEXT NOT NULL,
    created_at TIMESTAMP default now(),
    CONSTRAINT advisors_PK PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS applicants
(
    id         BIGSERIAL,
    first_name TEXT    NOT NULL,
    last_name  TEXT    NOT NULL,
    ssn        TEXT    NOT NULL,
    city       TEXT    NOT NULL,
    street     TEXT    NOT NULL,
    number     TEXT NOT NULL,
    zip        INTEGER NOT NULL,
    apt        INTEGER NOT NULL,
    CONSTRAINT applicants_PK PRIMARY KEY (id),
    CONSTRAINT applicants_ssn_AK UNIQUE (ssn)
);

CREATE TABLE IF NOT EXISTS applications
(
    id           BIGSERIAL,
    amount       DECIMAL NOT NULL,
    status       TEXT    NOT NULL,
    created_at   TIMESTAMP default now(),
    assigned_at  TIMESTAMP,
    resolved_at  TIMESTAMP,
    applicant_id BIGINT,
    advisor_id   BIGINT,
    CONSTRAINT applications_PK PRIMARY KEY (id),
    CONSTRAINT applications_applicants_FK FOREIGN KEY (applicant_id) REFERENCES applicants (id),
    CONSTRAINT applications_advisors_FK FOREIGN KEY (advisor_id) REFERENCES advisors (id)
);

CREATE TABLE IF NOT EXISTS system_users
(
    id       BIGSERIAL,
    email    TEXT NOT NULL,
    username TEXT NOT NULL,
    CONSTRAINT system_users_PK PRIMARY KEY (id),
    CONSTRAINT system_users_email_AK UNIQUE (email),
    CONSTRAINT system_users_username_AK UNIQUE (username)
);

create table applicant_phone_numbers
(
    applicant_id BIGINT,
    number TEXT NOT NULL,
    type TEXT NOT NULL,
    CONSTRAINT phone_number_applicants_FK FOREIGN KEY (applicant_id) REFERENCES applicants(id)
);