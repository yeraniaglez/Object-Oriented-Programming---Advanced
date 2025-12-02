package org.generation.classes;

public class Main {

    public static void main(String[] args) {

        //Crear el servicio (ESTO es lo que te falta)
        StudentService studentService = new StudentService();

        //Agregar estudiantes usando encapsulación
        studentService.addStudent(new Student("Carlos", "1030", 31));
        studentService.addStudent(new Student("Ian", "1020", 28));
        studentService.addStudent(new Student("Elise", "1050", 26));
        studentService.addStudent(new Student("Santiago", "1020", 33));

        //Probar inscribir a un alumno
        try {
            studentService.enrollStudents("Math", "1030");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}