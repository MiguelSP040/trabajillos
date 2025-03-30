const apiUrl = 'http://localhost:8080/api/tasks';

let tasks = [];
let selectedTask = null;

// Función para cargar las tareas en la tabla
const loadTable = async () => {
    let tbody = document.getElementById("tbody");
    let content = '';

    try {
        let response = await fetch(`${apiUrl}`);

        if (response.ok) {
            tasks = await response.json(); //Parsear la respuesta como un JSON

            // Iterar sobre las tareas recibidas
            // Crear el contenido de la tabla
            tasks.forEach((item, index) => {
                // Determinar el color del badge
                const status = item.pending ? `<h5><span class="badge text-bg-warning shadow-sm">Pendiente</span></h5>` : 
                                            `<h5><span class="badge text-bg-success shadow-sm">Completada</span></h5>`;

                content += `<tr class="align-middle">
                                <th scope="row" class="text-center">${index + 1}</th>
                                <td>${item.taskName}</td>
                                <td>${item.description}</td>
                                <td class="text-center">${item.date}</td>
                                <td class="text-center">${status}</td>
                                <td class="text-center">
                                    <button class="btn btn-outline-primary" onclick="confirmChangeStatus(${index})">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-arrow-repeat" viewBox="0 0 16 16">
                                            <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41m-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9"/>
                                            <path fill-rule="evenodd" d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5 5 0 0 0 8 3M3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9z"/>
                                        </svg>
                                    </button>
                                    <button class="btn btn-outline-danger" onclick="confirmDelete(${index})">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                        </svg>
                                    </button>
                                </td>
                            </tr>`;
            });

            tbody.innerHTML = content; // Actualiza el contenido de la tabla

            await countPendingTasks();
        } else {
            console.error('Error al cargar las tareas:', response.statusText);
        }
    } catch (error) {
        console.error('Error al hacer la solicitud:', error);
    }
};

// Llama a la función para cargar las tareas al iniciar
(async () => { 
    await loadTable();
})();

// Guardar una nueva tarea
const saveTask = async () => {
    let taskName = document.getElementById("taskName").value;
    let description = document.getElementById("description").value;
    let date = document.getElementById("date").value;

    if (taskName === '' || description === '' || date === '') {
        showEmptyAlert('Campos vacíos', 'Por favor, completa todos los campos.', () => {});
        return;
    }

    const existingTasks = document.querySelectorAll('#tbody tr');
    for (const row of existingTasks) {
        const existingTaskName = row.cells[1].textContent;
        if (existingTaskName === taskName) {
            changeError('Ya existe una tarea con ese nombre, ¡prueba con otro diferente!');
            return;
        }
    }

    let newTask = { taskName, description, date, pending: true };

    try {
        // Realiza la solicitud POST al servidor para guardar la tarea
        let response = await fetch(`${apiUrl}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newTask),
        });

        if (response.ok) {
            // Si la tarea se guardó correctamente, recarga la lista de tareas desde el servidor
            tasks.push(newTask);
            document.getElementById("saveForm").reset();
            loadTable();
            changeSuccess('Tarea guardada correctamente.');
        } else {
            console.error('Error al guardar la tarea:', response.statusText);
            changeError('No se pudo guardar la tarea.');
        }
    } catch (error) {
        console.error('Error al hacer la solicitud:', error);
        changeError('Error en la solicitud al servidor.');
    }
};

// Confirmar cambio de estado
const confirmChangeStatus = async (index) => {
    let taskName = tasks[index].taskName;

    showSweetAlert('Cambiar estado', '¿Estás seguro de cambiar el estado de la tarea?', async () => {
        try {
            let response = await fetch(`${apiUrl}/status/${taskName}`, {
                method: 'PUT',
            });

            if (response.ok) {
                tasks[index].pending = !tasks[index].pending;
                loadTable();
                changeSuccess('Estado de la tarea cambiado correctamente.');
            } else {
                console.error('Error al cambiar el estado:', response.statusText);
                changeError('No se pudo cambiar el estado de la tarea.');
            }
        } catch (error) {
            console.error('Error al hacer la solicitud:', error);
            changeError('Error en la solicitud al servidor.');
        }
    });
};

// Confirmar eliminación de tarea
const confirmDelete = async (index) => {
    let taskName = tasks[index].taskName;

    showSweetAlert('Eliminar tarea', `¿Estás seguro de eliminar la tarea "${taskName}"?`, async () => {
        try {
            let response = await fetch(`${apiUrl}/delete/${taskName}`, {
                method: 'DELETE',
            });
            if (response.ok) {
                tasks.splice(index, 1);
                loadTable();
                changeSuccess('Tarea eliminada correctamente.');
            } else if (response.status === 404) {
                console.error('No se encontró la tarea', response.statusText);
                changeError('La tarea no se encontró.');
            } else {
                console.error('Error al eliminar la tarea:', response.statusText);
                changeError('No se pudo eliminar la tarea.');
            }
        } catch (error) {
            console.error('Error al hacer la solicitud', error);
            changeError('Error en la solicitud al servidor.');
        }
    });
};

// Limpiar tareas
const clearTasks = async () => {
    showSweetAlert('Limpiar tareas', '¿Estás seguro de que quieres limpiar todas las tareas?', async () => {
        try {
            let response = await fetch(`${apiUrl}/clear`, {
                method: 'DELETE',
            });

            if (response.ok) {
                tasks = [];
                loadTable();
                changeSuccess('Todas las tareas han sido limpiadas.');
            } else {
                console.error('Error al limpiar las tareas:', response.statusText);
                changeError('No se pudo limpiar las tareas.');
            }
        } catch (error) {
            console.error('Error al hacer la solicitud:', error);
            changeError('Error en la solicitud al servidor.');
        }
    });
};

// Buscar tarea
const searchTask = async () => {
    let taskInput = document.querySelector("input[type='search']");
    let taskName = taskInput.value;
    let searchResult = document.getElementById("searchResult");

    if (taskName.trim() === '') {
        searchResult.textContent = "Por favor, ingrese un nombre de tarea.";
        return;
    }

    // Mostrar el nombre de la tarea en la consola
    console.log("Buscando tarea:", taskName);

    // Realiza la solicitud al backend
    try {
        let response = await fetch(`${apiUrl}/search?taskName=${taskName.trim()}`);
        if (response.status === 200) {
            let resultText = await response.text();
            searchResult.textContent = `Tarea encontrada: ${resultText}`;
        } else if (response.status === 404) {
            let resultText = await response.text();
            searchResult.textContent = resultText;
        } else {
            searchResult.textContent = "Ocurrió un error inesperado.";
        }
    } catch (error) {
        searchResult.textContent = "Ocurrió un error al buscar la tarea.";
    } finally {
        // Limpiar el input de búsqueda
        taskInput.value = '';
    }
};

// Función para contar tareas pendientes
const countPendingTasks = async () => {
    try {
        let response = await fetch(`${apiUrl}/pending/count`);
        if (response.ok) {
            let count = await response.text(); // Se espera un número
            document.getElementById("taskCounter").textContent = `Tareas pendientes: ${count}`;
        } else {
            console.error('Error al contar las tareas pendientes:', response.statusText);
            document.getElementById("taskCounter").textContent = 'Error al contar tareas';
        }
    } catch (error) {
        console.error('Error al hacer la solicitud', error);
        document.getElementById("TaskCounter").textContent = 'Error en la solicitud';
    }
};

// Función para descargar tareas
const downloadTasks = async () => {
    try {
        let response = await fetch(`${apiUrl}/download`);

        if (response.ok) {
            const blob = await response.blob();
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
            a.href = url;
            a.download = 'Tareas.txt';  // Nombre del archivo descargado
            document.body.appendChild(a);
            a.click();
            a.remove();
            changeSuccess('Archivo de tareas descargado correctamente.');
        } else {
            console.error("Error: No se pudo descargar el archivo.");
            changeError('No se pudo descargar el archivo.');
        }
    } catch (error) {
        console.error("Error al intentar descargar el archivo:", error);
        changeError('Error en la solicitud de descarga.');
    }
};

// SweetAlerts
// Función para mostrar SweetAlert de confirmación
const showSweetAlert = (title, text, onConfirm) => {
    Swal.fire({
        title: title,
        text: text,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Aceptar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            onConfirm();
        }
    });
};

const showEmptyAlert = (title, text, onConfirm) => {
    Swal.fire({
        title: title,
        text: text,
        icon: 'warning',
        confirmButtonText: 'Aceptar',
    }).then((result) => {
        if (result.isConfirmed) {
            onConfirm();
        }
    });
};

// Función para mostrar alerta de éxito
function changeSuccess(message) {
    Swal.fire({
        toast: true,
        position: 'top-start',
        iconColor: 'white',
        icon: 'success',
        title: '¡Hecho!',
        text: message,
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        customClass: {
            popup: 'no-select-popup colored-toast success' // Clase para el toast de éxito
        }
    });
}

// Función para mostrar alerta de error
function changeError(message) {
    Swal.fire({
        toast: true,
        position: 'top-start',
        iconColor: 'white',
        icon: 'error',
        title: '¡Error!',
        text: message,
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        customClass: {
            popup: 'no-select-popup colored-toast error' // Clase para el toast de error
        }
    });
}
