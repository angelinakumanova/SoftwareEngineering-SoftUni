function solve(input) {
    //Student name: Joey, Grade: 9, Graduated with an average score: 4.90",
    const schoolRegister = [];
    
    const studentPattern = /Student name: ([^,]+), Grade: (\d+), Graduated with an average score: ([\d.]+)/;
    
    for (const line of input) {
        const match = line.match(studentPattern);
        
        if (match) {
            const studentName = match[1];
            const studentGrade = Number(match[2]) + 1;
            const averageScore = Number(match[3]);
            
            if (averageScore >= 3) {
                const student = {
                    studentName,
                    studentGrade,
                    averageScore,
                };
                
                schoolRegister.push(student);
            }  
        }
        
    }
    
    const groupedByGrade = {};
    
    for (const student of schoolRegister) {
        const grade = student.studentGrade;
        if (!groupedByGrade[grade]) {
            groupedByGrade[grade] = [];
        }
        groupedByGrade[grade].push(student);
    }
    
    for (const grade in groupedByGrade) {
        const studentsInGrade = groupedByGrade[grade];
        const studentNames = studentsInGrade.map(student => student.studentName).join(', ');
        const averageScore = (studentsInGrade.reduce((sum, student) => sum + student.averageScore, 0) / studentsInGrade.length).toFixed(2);
        
        console.log(`${grade} Grade`);
        console.log(`List of students: ${studentNames}`);
        console.log(`Average annual score from last year: ${averageScore}`);
        console.log('');
    }
}

solve([
    "Student name: Mark, Grade: 8, Graduated with an average score: 4.75",
    "Student name: Ethan, Grade: 9, Graduated with an average score: 5.66",
    "Student name: George, Grade: 8, Graduated with an average score: 2.83",
    "Student name: Steven, Grade: 10, Graduated with an average score: 4.20",
    "Student name: Joey, Grade: 9, Graduated with an average score: 4.90",
    "Student name: Angus, Grade: 11, Graduated with an average score: 2.90",
    "Student name: Bob, Grade: 11, Graduated with an average score: 5.15",
    "Student name: Daryl, Grade: 8, Graduated with an average score: 5.95",
    "Student name: Bill, Grade: 9, Graduated with an average score: 6.00",
    "Student name: Philip, Grade: 10, Graduated with an average score: 5.05",
    "Student name: Peter, Grade: 11, Graduated with an average score: 4.88",
    "Student name: Gavin, Grade: 10, Graduated with an average score: 4.00"
]);
