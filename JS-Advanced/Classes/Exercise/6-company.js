class Company {
    #departments = {};

    addEmployee(name, salary, position, department) {

        if (!name || !salary || salary < 0 || !position || !department) {
            throw Error('Invalid input!');
        }

        const employee = {
            name,
            salary,
            position
        };

        if (!this.#departments.hasOwnProperty(department)) {
            this.#departments[department] = [];
        }
        
        this.#departments[department].push(employee);
        
        return `New employee is hired. Name: ${name}. Position: ${position}`;
    }

    bestDepartment() {
        const bestDepartment = Object.entries(this.#departments)
        .map(([department, employees]) => {
            const totalSalary = employees.reduce((prevEmp, currentEmp) => prevEmp + currentEmp.salary, 0);
            const averageSalary = totalSalary / employees.length;
            return { department, averageSalary, employees };
        })
        .sort((firstDept, secondDept) => secondDept.averageSalary - firstDept.averageSalary)[0];

        const { department: departmentName, averageSalary, employees } = bestDepartment;
        
        const employeesToString = employees
        .sort((firstEmp, secondEmp) => {
            const diff = firstEmp.salary - secondEmp.salary;

            if (diff != 0) {
                return secondEmp.salary - firstEmp.salary;
            }

            return firstEmp.name.localeCompare(secondEmp.name);
        })
        .map(emp => {
            return `${emp.name} ${emp.salary} ${emp.position}`
        });

        const result = `Best Department is: ${departmentName}\n` +
        `Average salary: ${averageSalary.toFixed(2)}\n` +
        employeesToString.join('\n');

        return result;
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());
