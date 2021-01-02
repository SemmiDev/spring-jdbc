# scheme

~~~~
CREATE TABLE IF NOT EXISTS student ( 
    student_id UUID PRIMARY KEY NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    gender VARCHAR(6) NOT NULL
        CHECK (
            gender = 'MALE'   OR
            gender = 'male'   OR
            gender = 'FEMALE' OR
            gender = 'female'
        )
);
~~~~

~~~~
CREATE TABLE IF NOT EXISTS course (
    course_id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    department VARCHAR(255),
    teacher_name VARCHAR(100)
);
~~~~

~~~~
CREATE TABLE IF NOT EXISTS student_course (
    student_id UUID NOT NULL REFERENCES student (student_id),
    course_id UUID NOT NULL REFERENCES course (course_id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    grade INTEGER CHECK (grade >= 0 AND grade <= 100),
    UNIQUE (student_id, course_id)
);
~~~~

~~~~
ALTER TABLE course ALTER department SET NOT NULL;
CREATE TYPE gender AS ENUM ('MALE', 'FEMALE');
ALTER TABLE student ALTER COLUMN gender TYPE gender USING (gender::gender)
ALTER TABLE student DROP CONSTRAINT IF EXISTS student_gender_check;
~~~~

~~~~
insert into student (student_id, first_name, last_name, email, gender) values ('e7e40436-b931-441d-85e0-d86b6039fdfa', 'Sammi', 'Aldhi Yanto', 'Sammi@photobucket.com', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('13ba8584-99f5-4e7a-87b8-c2d16b39ce49', 'Aditya', 'Andika Putra', 'Aditya@examiner.com', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('a75c1b78-0802-4888-8e8c-f8e76e34b617', 'Abdul', 'Rauf', 'Abdul@imgur.com', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('020bb0e0-7681-4eae-90f5-1218b649e917', 'Dandi', 'Arnanda', 'Dandi@state.gov', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('5ea017f7-b4f7-4bbd-800f-940253380b15', 'Aditya', 'Fauzan Nul Haq', 'Adityaa@eventbrite.com', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('953b52d8-a089-48a4-bbf8-e21008c72f0e', 'Gus', 'Noor', 'Gus@ebay.co.uk', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('7492d4b0-1217-48af-9757-9611a9d4af55', 'Adidtiya', 'Putra Chaniago', 'Adidtiya@guardian.co.uk', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('bc5bc1a9-1da7-4b1f-931a-4f5c3f7dc992', 'Chiko', 'Narasaki', 'Chiko@uiuc.edu', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('6c20ac51-23d0-4d46-bd50-82dab6611e66', 'Muhammad', 'Kurniawan', 'Muhammad@europa.eu', 'FEMALE');
insert into student (student_id, first_name, last_name, email, gender) values ('eb8c6b33-8a73-4482-90d4-6f89e800b947', 'Sappe', 'Saputra', 'Sappe@goo.ne.jp', 'FEMALE');
insert into student (student_id, first_name, last_name, email, gender) values ('ce82e722-1310-4d00-9f17-2bb0d45719f0', 'M', 'Riski', 'M@chron.com', 'FEMALE');
insert into student (student_id, first_name, last_name, email, gender) values ('d40668fa-432e-4649-88cc-871fa46a0396', 'Hitcha', 'Natanael', 'Hitcha@salon.com', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('5f5d877e-0649-4ec8-9991-793dfc068f75', 'Naufal', 'Abdurrahman', 'Naufal@wisc.edu', 'MALE');
insert into student (student_id, first_name, last_name, email, gender) values ('fbdebde6-58c7-41e3-b51b-343e032b3b3b', 'Seteven', 'S', 'Seteven@rakuten.co.jp', 'MALE');
~~~~

~~~~
INSERT INTO course (course_id,name,description,department,teacher_name)
VALUES (
    '7321b9a6-29f7-49e0-9330-6d079c792608',
    'LEARN JAVA FROM ZERO TO HERO',
    'No Available desc',
    'Programming',
    'Sammidev'
);
~~~~

~~~~
INSERT INTO course (course_id,name,description,department,teacher_name)
VALUES (
    '7321b9a6-29f7-49e0-9330-6d079c792609',
    'LEARN SPRING FROM ZERO TO HERO',
    'No Available desc',
    'Programming',
    'Sammidev'
);
~~~~

~~~~
INSERT INTO course (course_id,name,description,department,teacher_name)
VALUES (
    '7321b9a6-29f7-49e0-9330-6d079c792610',
    'LEARN KOTLIN FROM ZERO TO HERO',
    'No Available desc',
    'Programming',
    'Sammidev'
);
~~~~

~~~~
INSERT INTO student_course (student_id,course_id,start_date,end_date,grade)
VALUES (
    'e7e40436-b931-441d-85e0-d86b6039fdfa',
    '7321b9a6-29f7-49e0-9330-6d079c792608',
    (NOW() - INTERVAL '1 YEAR')::DATE,
    NOW()::DATE,
    90
);
~~~~

~~~~
INSERT INTO student_course (student_id,course_id,start_date,end_date,grade)
VALUES (
    'e7e40436-b931-441d-85e0-d86b6039fdfa',
    '7321b9a6-29f7-49e0-9330-6d079c792609',
    (NOW() - INTERVAL '1 YEAR')::DATE,
    NOW()::DATE,
    80
);
~~~~

~~~~
INSERT INTO student_course (student_id,course_id,start_date,end_date,grade)
VALUES (
    'e7e40436-b931-441d-85e0-d86b6039fdfa',
    '7321b9a6-29f7-49e0-9330-6d079c792610',
    (NOW() - INTERVAL '1 YEAR')::DATE,
    NOW()::DATE,
    100
);
~~~~


# API Spec 

## Create Student

Request :
- Method : POST
- Endpoint : `api/v1/students`
- Body :

```json 
{
    "firstName": "Sammi",
    "lastName": "Ganteng",
    "email": "sammialdhiyanto@gmail.com",
    "gender": "MALE"
}

```

Response :

```json 
{
    "code" : "200",
    "status" : "ok"
```
}

## Get All Students

Request :
- Method : GET
- Endpoint : `api/v1/students`

Response :

```json 
[
    {
        "studentId": "e7e40436-b931-441d-85e0-d86b6039fdfa",
        "firstName": "Sammi",
        "lastName": "Aldhi Yanto",
        "email": "Sammi@photobucket.com",
        "gender": "MALE"
    },
    {
        "studentId": "13ba8584-99f5-4e7a-87b8-c2d16b39ce49",
        "firstName": "Aditya",
        "lastName": "Andika Putra",
        "email": "Aditya@examiner.com",
        "gender": "MALE"
    },
    {
        "studentId": "a75c1b78-0802-4888-8e8c-f8e76e34b617",
        "firstName": "Abdul",
        "lastName": "Rauf",
        "email": "Abdul@imgur.com",
        "gender": "MALE"
    },
    {
        "studentId": "020bb0e0-7681-4eae-90f5-1218b649e917",
        "firstName": "Dandi",
        "lastName": "Arnanda",
        "email": "Dandi@state.gov",
        "gender": "MALE"
    },
    {
        "studentId": "5ea017f7-b4f7-4bbd-800f-940253380b15",
        "firstName": "Aditya",
        "lastName": "Fauzan Nul Haq",
        "email": "Adityaa@eventbrite.com",
        "gender": "MALE"
    },
    {
        "studentId": "953b52d8-a089-48a4-bbf8-e21008c72f0e",
        "firstName": "Gus",
        "lastName": "Noor",
        "email": "Gus@ebay.co.uk",
        "gender": "MALE"
    },
    {
        "studentId": "7492d4b0-1217-48af-9757-9611a9d4af55",
        "firstName": "Adidtiya",
        "lastName": "Putra Chaniago",
        "email": "Adidtiya@guardian.co.uk",
        "gender": "MALE"
    },
    {
        "studentId": "bc5bc1a9-1da7-4b1f-931a-4f5c3f7dc992",
        "firstName": "Chiko",
        "lastName": "Narasaki",
        "email": "Chiko@uiuc.edu",
        "gender": "MALE"
    },
    {
        "studentId": "6c20ac51-23d0-4d46-bd50-82dab6611e66",
        "firstName": "Muhammad",
        "lastName": "Kurniawan",
        "email": "Muhammad@europa.eu",
        "gender": "FEMALE"
    },
    {
        "studentId": "eb8c6b33-8a73-4482-90d4-6f89e800b947",
        "firstName": "Sappe",
        "lastName": "Saputra",
        "email": "Sappe@goo.ne.jp",
        "gender": "FEMALE"
    },
    {
        "studentId": "ce82e722-1310-4d00-9f17-2bb0d45719f0",
        "firstName": "M",
        "lastName": "Riski",
        "email": "M@chron.com",
        "gender": "FEMALE"
    },
    {
        "studentId": "d40668fa-432e-4649-88cc-871fa46a0396",
        "firstName": "Hitcha",
        "lastName": "Natanael",
        "email": "Hitcha@salon.com",
        "gender": "MALE"
    },
    {
        "studentId": "5f5d877e-0649-4ec8-9991-793dfc068f75",
        "firstName": "Naufal",
        "lastName": "Abdurrahman",
        "email": "Naufal@wisc.edu",
        "gender": "MALE"
    },
    {
        "studentId": "fbdebde6-58c7-41e3-b51b-343e032b3b3b",
        "firstName": "Seteven",
        "lastName": "S",
        "email": "Seteven@rakuten.co.jp",
        "gender": "MALE"
    },
    {
        "studentId": "69877b84-a2d9-4660-8240-874606dd9166",
        "firstName": "sammi",
        "lastName": "aldhi ganteng",
        "email": "sammidev4ganteng@gmail.com",
        "gender": "MALE"
    }
]
```

## Get All Courses for Student
Request :
- Method : GET
- Endpoint : `api/v1/students/{studentId}/courses`
- Sample : `api/v1/students/e7e40436-b931-441d-85e0-d86b6039fdfa/courses`
- Body :
```json
[
    {
        "studentId": "e7e40436-b931-441d-85e0-d86b6039fdfa",
        "courseId": "7321b9a6-29f7-49e0-9330-6d079c792608",
        "name": "LEARN JAVA FROM ZERO TO HERO",
        "description": "No Available desc",
        "department": "Programming",
        "teacherName": "Sammidev",
        "startDate": "2020-01-02",
        "endDate": "2021-01-02",
        "grade": 90
    },
    {
        "studentId": "e7e40436-b931-441d-85e0-d86b6039fdfa",
        "courseId": "7321b9a6-29f7-49e0-9330-6d079c792609",
        "name": "LEARN SPRING FROM ZERO TO HERO",
        "description": "No Available desc",
        "department": "Programming",
        "teacherName": "Sammidev",
        "startDate": "2020-01-02",
        "endDate": "2021-01-02",
        "grade": 80
    },
    {
        "studentId": "e7e40436-b931-441d-85e0-d86b6039fdfa",
        "courseId": "7321b9a6-29f7-49e0-9330-6d079c792610",
        "name": "LEARN KOTLIN FROM ZERO TO HERO",
        "description": "No Available desc",
        "department": "Programming",
        "teacherName": "Sammidev",
        "startDate": "2020-01-02",
        "endDate": "2021-01-02",
        "grade": 100
    }
] 
```

## Update Student

Request :
- Method : PUT
- Endpoint : `api/v1/students/13ba8584-99f5-4e7a-87b8-c2d16b39ce49`
- Body :

```json 
{
    "firstName": "adiddddd",
    "lastName": "chaniagoo",
    "email": "addidcg@gmail.com",
    "gender": "FEMALE"
}
```

## Delete Student

Request :
- Method : DELETE
- Endpoint : `api/v1/students/13ba8584-99f5-4e7a-87b8-c2d16b39ce49`