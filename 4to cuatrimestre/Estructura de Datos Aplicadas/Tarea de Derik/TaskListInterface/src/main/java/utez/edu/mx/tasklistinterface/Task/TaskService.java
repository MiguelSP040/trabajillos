package utez.edu.mx.tasklistinterface.Task;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> taskList = new LinkedList<>();

    // Agregar tarea
    public void addTask(String taskName, String description, String date) {
        taskList.add(new Task(taskName, description, date, true));
        System.out.println("Tarea añadida: " + taskName);
    }

    // Consultar todas las tareas
    public List<Task> getAllTasks() {
        return taskList;
    }

    // Eliminar tarea por nombre
    public boolean deleteTask(String taskName) {
        return taskList.removeIf(task -> task.getTaskName().equalsIgnoreCase(taskName));
    }

    // Cambiar estado de una tarea
    public boolean changeTaskStatus(String taskName) {
        for (Task task : taskList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                task.setPending(!task.isPending());
                return true;
            }
        }
        return false;
    }

    // Limpiar lista de tareas
    public void clearTasks() {
        taskList.clear();
    }

    // Contar tareas pendientes
    public long countPendingTasks() {
        return taskList.stream().filter(Task::isPending).count();
    }

    // Verificar si una tarea está en la lista y su estado
    public Task checkTask(String taskName) {
        System.out.println("Lista actual de tareas:");
        for (Task task : taskList) {
            System.out.println(task.getTaskName());
        }

        return taskList.stream()
                .filter(task -> task.getTaskName().equalsIgnoreCase(taskName))
                .findFirst()
                .orElse(null);
    }

    // Guardar el archivo con las tareas
    public void saveFile() {
        File file = new File("Tareas.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Task task : taskList) {
                writer.write(task.toString());
                writer.newLine();
                writer.newLine();
            }
            System.out.println("Archivo generado con éxito en: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un problema: " + e.getMessage());
        }
    }

}
