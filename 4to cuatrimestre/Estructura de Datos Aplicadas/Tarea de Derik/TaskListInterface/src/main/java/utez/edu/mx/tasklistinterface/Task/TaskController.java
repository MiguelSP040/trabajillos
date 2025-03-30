package utez.edu.mx.tasklistinterface.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/checkInstance")
    public String checkInstance() {
        return "Instancia de TaskService: " + taskService.hashCode();
    }

    // Obtener todas las tareas
    @GetMapping("")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Agregar una tarea
    @PostMapping("")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        taskService.addTask(task.getTaskName(), task.getDescription(), task.getDate());
        return new ResponseEntity<>("Se ha añadido la tarea", HttpStatus.CREATED);
    }

    // Eliminar una tarea por nombre
    @DeleteMapping("/delete/{taskName}")
    public ResponseEntity<String> deleteTask(@PathVariable String taskName) {
        boolean isDeleted = taskService.deleteTask(taskName);
        if (isDeleted) {
            return new ResponseEntity<>("La tarea ha sido eliminada", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado la tarea", HttpStatus.NOT_FOUND);
        }
    }

    // Cambiar el estado de una tarea
    @PutMapping("/status/{taskName}")
    public ResponseEntity<String> changeTaskStatus(@PathVariable String taskName) {
        boolean statusChanged = taskService.changeTaskStatus(taskName);
        if (statusChanged) {
            return new ResponseEntity<>("El estado de la tarea se ha actualizado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se ha encontrado la tarea", HttpStatus.NOT_FOUND);
        }
    }

    // Limpiar la lista de tareas
    @DeleteMapping("/clear")
    public ResponseEntity<String> clearTasks() {
        taskService.clearTasks();
        return new ResponseEntity<>("Se ha limpiado la lista", HttpStatus.OK);
    }

    // Contar tareas pendientes
    @GetMapping("/pending/count")
    public ResponseEntity<Long> countPendingTasks() {
        long count = taskService.countPendingTasks();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // Verificar si una tarea está en la lista y obtener su estado
    @GetMapping("/check/{taskName}")
    public ResponseEntity<Task> checkTask(@PathVariable String taskName) {
        Task task = taskService.checkTask(taskName);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para buscar una tarea por su nombre
    @GetMapping("/search")
    public ResponseEntity<String> searchTask(@RequestParam String taskName) {
        Task task = taskService.checkTask(taskName.trim());

        if (task != null) {
            String message = "La tarea '" + task.getTaskName() + "' está en la lista y está " + (task.isPending() ?  "pendiente" : "completada");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            String message = "La tarea '" + taskName + "' no está en la lista.";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para descargar el archivo generado
    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        taskService.saveFile();

        File file = new File("Tareas.txt");

        if (!file.exists()) {
            // Loguea un mensaje para saber si el archivo no existe
            System.out.println("El archivo no se encontró.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Resource resource = new FileSystemResource(file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName())
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);
    }
}
