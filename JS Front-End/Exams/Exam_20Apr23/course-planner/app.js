function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/tasks/';
    
    const coursesList = document.getElementById('list');
    const courseNameInput = document.getElementById('course-name');
    const typeInput = document.getElementById('course-type');
    const descriptionElement = document.getElementById('description');
    const teacherNameInput = document.getElementById('teacher-name');
    
    const loadButton = document.getElementById('load-course');
    const addButton = document.getElementById('add-course');
    const editButton = document.getElementById('edit-course');
    
    loadButton.addEventListener('click', loadRecords);
    addButton.addEventListener('click', addCourseToDatabase);
    editButton.addEventListener('click', editCourseInDatabase);
    
    async function fetchRecords() {
        const response = await fetch(baseURL);
        const result = await response.json();
        
        return result;
    }
    
    async function loadRecords() {
        coursesList.innerHTML = '';
        const result = await fetchRecords();
        const courses = Object.values(result);
        
        const coursesElements = courses.map(course => createCourseElement(course));
        coursesElements.forEach(c => coursesList.appendChild(c));
    }
    
    async function addCourseToDatabase() {
        const courseName = courseNameInput.value;
        const type = typeInput.value;
        const description = descriptionElement.value;
        const teacherName = teacherNameInput.value;
        
        //title, type, description, teacher
        const course = {
            title: courseName,
            type,
            description,
            teacher: teacherName,
        };
        
        await fetch(baseURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(course),
        });
        
        clearInputs();
        
        await loadRecords();
        
        
    }
    
    async function editCourseInDatabase() {
        const currentId = courseNameInput.getAttribute('course-id');
        
        const courseName = courseNameInput.value;
        const type = typeInput.value;
        const description = descriptionElement.value;
        const teacherName = teacherNameInput.value;
        
        //title, type, description, teacher
        const modifiedCourse = {
            title: courseName,
            type,
            description,
            teacher: teacherName,
            _id: currentId,
        };
        
        const url = baseURL + currentId;
        
        await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(modifiedCourse),
        });
        
        await loadRecords();
        
        editButton.disabled = true;
        addButton.disabled = false;
    }
    
    function createCourseElement(course) {
        // <!-- <div class="container">
        //   <h2>JS Back-End</h2>
        //   <h3>John Brown</h3>
        //   <h3>Long</h3>
        //   <h4>JS Back-end responsible for managing the interchange of data between the server
        //       and the users</h4>
        //   <button class="edit-btn">Edit Course</button>
        //   <button class="finish-btn">Finish Course</button>
        // </div> -->
        
        const mainDiv = document.createElement('div');
        mainDiv.classList.add('container');
        
        mainDiv.innerHTML = `
            <h2>${course.title}</h2>
            <h3>${course.teacher}</h3>
            <h3>${course.type}</h3>
            <h4>${course.description}</h4>
        `;
        
        const changeButton = document.createElement('button');
        changeButton.classList.add('edit-btn');
        changeButton.textContent = 'Edit Course';
        changeButton.addEventListener('click', () => editCourse(course, mainDiv));
        mainDiv.appendChild(changeButton);
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('finish-btn');
        deleteButton.textContent = 'Finish Course';
        deleteButton.addEventListener('click', () => deleteCourseFromDatabase(course._id));
        mainDiv.appendChild(deleteButton);
        
        
        return mainDiv;
    }
    
    function editCourse(course, divElement) {
        divElement.remove();
        
        const courseName = course.title;
        const type = course.type;
        const description = course.description;
        const teacherName = course.teacher;
        
        courseNameInput.setAttribute('course-id', course._id);
        
        courseNameInput.value = courseName;
        typeInput.value = type;
        descriptionElement.value = description;
        teacherNameInput.value = teacherName;
        
        addButton.disabled = true;
        editButton.disabled = false;
    }
    
    async function deleteCourseFromDatabase(id) {
        const url = baseURL + id;
        
        await fetch(url, {
            method: 'DELETE',
        });
        
        await loadRecords();
    }
    
    function clearInputs() {
        courseNameInput.value = '';
        typeInput.value = '';
        descriptionElement.value = '';
        teacherNameInput.value = '';
    }
    
}

attachEvents();
