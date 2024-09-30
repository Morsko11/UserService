
create table course (
                        id serial primary key ,
                        course_name varchar,
                        description varchar
);
create table groups (
                        id serial primary key ,
                        title varchar,
                        course_id int,
                        constraint fk_course_id foreign key (course_id) references course(id)
);
create table client (
                        id serial primary key ,
                        name varchar,
                        lastname varchar,
                        dob date,
                        group_id int,
                        constraint fk_groups_id foreign key (group_id) references groups(id)
);
CREATE table teacher (
                         id serial primary key ,
                         name varchar,
                         lastname varchar,
                         age int,
                         course_id int,
                         constraint fk_course_id foreign key (course_id) references  course(id)
);
create table group_teacher (
                               id serial primary key ,
                               group_id int,
                               teacher_id int,
                               constraint fk_group_id foreign key (group_id) references groups(id) ,
                               constraint fk_teacher_id foreign key (teacher_id) references  teacher(id)

);
