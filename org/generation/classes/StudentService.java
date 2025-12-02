package org.generation.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class StudentService
{
    private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }
    
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void enrollStudents(String courseName, String studentID)
            throws CourseNotFoundException, StudentNotFoundException {

        if (!courseList.containsKey(courseName)) {
            throw new CourseNotFoundException();
        }

        if (!students.containsKey(studentID)) {
            throw new StudentNotFoundException();
        }

        Course course = courseList.get(courseName);

        coursesEnrolledByStudents
                .computeIfAbsent(studentID, k -> new ArrayList<>())
                .add(course);
    }
    
    public void unEnrollStudents(String courseName, String studentID)
            throws CourseNotFoundException, StudentNotFoundException {

        if (!courseList.containsKey(courseName)) {
            throw new CourseNotFoundException();
        }

        if (!students.containsKey(studentID)) {
            throw new StudentNotFoundException();
        }

        if (coursesEnrolledByStudents.containsKey(studentID)) {
            Course course = courseList.get(courseName);
            coursesEnrolledByStudents.get(studentID).remove(course);
        }
    }
    
    public void showAllCourses() {
        for (Course course : courseList.values()) {
            System.out.println(course.getName() + " - Profesor: " + course.getProfessorName());
        }
    }

    public void showEnrolledStudents(String studentId) {

        if (!coursesEnrolledByStudents.containsKey(studentId)) {
            System.out.println("No hay cursos inscritos para este estudiante");
            return;
        }

        for (Course course : coursesEnrolledByStudents.get(studentId)) {
            System.out.println(course.getName());
        }
    }
}
