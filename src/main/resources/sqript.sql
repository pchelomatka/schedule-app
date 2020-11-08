create table if not exists faculty
(
    id serial not null
        constraint faculty_pk
            primary key,
    name varchar(255) not null
);

alter table faculty owner to postgres;

create table if not exists speciality
(
    id serial not null
        constraint specialty_pk
            primary key,
    name varchar(255) not null,
    faculty_id integer not null
        constraint specialty_faculty_id_fk
            references faculty
);

alter table speciality owner to postgres;

create table if not exists student_group
(
    id serial not null
        constraint group_pk
            primary key,
    name varchar(255) not null,
    speciality_id integer not null
        constraint group_speciality_id_fk
            references speciality,
    course integer
);

alter table student_group owner to postgres;

create table if not exists student
(
    id serial not null
        constraint user_pk
            primary key,
    name varchar(255) not null,
    surname varchar(255) not null,
    patronymic varchar(255) not null,
    student_group_id integer not null
        constraint student_student_group_id_fk
            references student_group
);

alter table student owner to postgres;

create table if not exists student_subject
(
    id serial not null
        constraint " subject_pk"
            primary key,
    name varchar(255) not null,
    classroom varchar(255)
);

alter table student_subject owner to postgres;

create table if not exists lecturer
(
    id serial not null
        constraint lecturer_pk
            primary key,
    name varchar(255) not null,
    student_subject_id integer
        constraint lecturer_student_subject_id_fk
            references student_subject
);

alter table lecturer owner to postgres;

create table if not exists schedule
(
    id serial not null
        constraint scedule_pk
            primary key,
    student_group_id integer
        constraint schedule_student_group_id_fk
            references student_group,
    student_subject_id integer
        constraint schedule_student_subject_id_fk
            references student_subject,
    week integer,
    day_of_week varchar(255),
    number_of_pair integer
);

alter table schedule owner to postgres;

create table if not exists auth
(
    id serial not null
        constraint auth_pk
            primary key,
    login integer
        constraint auth_student_id_fk
            references student,
    password varchar(255),
    authorized boolean
);

alter table auth owner to postgres;

