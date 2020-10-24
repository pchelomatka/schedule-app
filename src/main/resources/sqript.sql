create table faculty
(
    id   serial       not null
        constraint faculty_pk
            primary key,
    name varchar(255) not null
);

alter table faculty
    owner to postgres;

create table specialty
(
    id         serial       not null
        constraint specialty_pk
            primary key,
    name       varchar(255) not null,
    faculty_id integer      not null
        constraint specialty_faculty_id_fk
            references faculty
);

alter table specialty
    owner to postgres;

create table student_group
(
    id           serial       not null
        constraint group_pk
            primary key,
    name         varchar(255) not null,
    specialty_id integer      not null
        constraint group_specialty_id_fk
            references specialty
);

alter table student_group
    owner to postgres;

create table student
(
    id               serial       not null
        constraint user_pk
            primary key,
    name             varchar(255) not null,
    surname          varchar(255) not null,
    patronymic       varchar(255) not null,
    student_group_id integer      not null
        constraint student_student_group_id_fk
            references student_group
);

alter table student
    owner to postgres;

create table student_subject
(
    id               serial       not null
        constraint " subject_pk"
            primary key,
    name             varchar(255) not null,
    student_group_id integer      not null
        constraint student_subject_student_group_id_fk
            references student_group,
    classroom        varchar(255) not null,
    week             integer      not null,
    day_of_week      varchar(255) not null
);

alter table student_subject
    owner to postgres;

create table lecturer
(
    id                 serial       not null
        constraint lecturer_pk
            primary key,
    name               varchar(255) not null,
    student_subject_id integer      not null
        constraint lecturer_student_subject_id_fk
            references student_subject
);

alter table lecturer
    owner to postgres;

create table auth
(
    id         serial       not null,
    login      varchar(255) not null,
    password   varchar(255) not null,
    student_id integer
        constraint auth_student_id_fk
            references student
);

alter table auth
    owner to postgres;

