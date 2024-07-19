function solve(input) {
    /* "{course name}: {capacity}" – add the course with that capacity. If the course exists,
    add the capacity to the existing one
    "{username}[{credits count}] with email {email} joins {course name}" – add the student if
    the course exists (each student can be in multiple courses)
    and if there are places left (count of students are less than the capacity) */

    const courses = [];

    for (const line of input) {

        if (line.includes(':')) {
            const [courseName, capacity] = line.split(': ');

            const currentCourse = courses.find((course) => course.name === courseName);

            if (currentCourse) {
                currentCourse.capacity += Number(capacity);
            } else {
                const course = {
                    name: courseName,
                    capacity: Number(capacity),
                    students: [],
                };

                courses.push(course);
            }
        } else {
            const pattern = /^(.+)\[(\d+)\] with email (\S+) joins (.+)$/;
            const match = line.match(pattern);

            if (match) {
                const [_, username, creditsCount, email, courseName] = match;

                const currentCourse = courses.find((course) => course.name === courseName);

                if (currentCourse && currentCourse.capacity > 0) {
                    const student = {
                        username,
                        creditsCount: Number(creditsCount),
                        email,
                    };
    
                    currentCourse.students.push(student);
                    currentCourse.capacity = currentCourse.capacity - 1;
                }
            }
        }
    }

    /*"{course one}: {places left} places left
    --- {credits}: {username one}, {email one} */


    courses
    .sort((firstCourse, secondCourse) => secondCourse.students.length - firstCourse.students.length)
    .forEach(course => {
        console.log(`${course.name}: ${course.capacity} places left`);
        const sortedStudents = course.students.sort((firstStudent, secondStudent) => secondStudent.creditsCount - firstStudent.creditsCount);

        for (const student of sortedStudents) {
            console.log(`--- ${student.creditsCount}: ${student.username}, ${student.email}`);
        }
    })
}

solve(['JavaBasics: 2', 'user1[25] with email user1@user.com joins C#Basics', 'C#Advanced: 3', 'JSCore: 4', 'user2[30] with email user2@user.com joins C#Basics', 'user13[50] with email user13@user.com joins JSCore', 'user1[25] with email user1@user.com joins JSCore', 'user8[18] with email user8@user.com joins C#Advanced', 'user6[85] with email user6@user.com joins JSCore', 'JSCore: 2', 'user11[3] with email user11@user.com joins JavaBasics', 'user45[105] with email user45@user.com joins JSCore', 'user007[20] with email user007@user.com joins JSCore', 'user700[29] with email user700@user.com joins JSCore', 'user900[88] with email user900@user.com joins JSCore']);
