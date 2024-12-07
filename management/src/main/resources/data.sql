insert into COURSE(id,title, credits) values
    ('DEV1', 'Developpement 1', 10),
    ('DEV2', 'Developpement 2', 8),
    ('DEV3', 'Developpement 3', 6),
    ('DEV4', 'Developpement 4', 4),
    ('DEV5', 'Developpement 5', 2),
    ('DEV6', 'Developpement 6', 1);

insert into STUDENT(Number, Name, Gender, Section) values
    (58554, 'ilias filali', 'MALE', 'DEVELOPPEMENT'),
    (60000, 'youssef rajoul', 'FEMALE', 'DEVELOPPEMENT'),
    (50000, 'oussama ouballa', 'MALE', 'RESEAU'),
    (58600, 'tareq ahmad', 'MALE', 'INDUSTRIELLE');

insert into  STUDENT_COURSES(STUDENTS_NUMBER, COURSES_ID) values
    (58554, 'DEV1'),
    (58554, 'DEV2'),
    (58554, 'DEV3'),
    (60000, 'DEV1'),
    (60000, 'DEV2'),
    (60000, 'DEV3'),
    (58600, 'DEV1'),
    (58600, 'DEV2'),
    (58600, 'DEV3'),
    (50000, 'DEV1'),
    (50000, 'DEV2'),
    (50000, 'DEV3');


