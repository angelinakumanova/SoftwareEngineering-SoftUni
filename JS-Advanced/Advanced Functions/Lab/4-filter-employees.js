const parseData = data => JSON.parse(data);

const getFilterFn = criteria => {
    const [key, value] = criteria.split('-');
    
    return key === 'all' ? () => true : employee => employee[key] === value;
};

const formatEmployee = (employee, index) => 
    `${index}. ${employee.first_name} ${employee.last_name} - ${employee.email}`;

const filterEmployees = (data, criteria) => 
    parseData(data)
        .filter(getFilterFn(criteria))
        .map(formatEmployee)
        .join('\n');

console.log(filterEmployees(`[{
    "id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`, 
'gender-Female'));




