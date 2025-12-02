package org.generation.classes;

public class Course
{
    public String name;

    public int credits;

    public String professorName;

    public Course( String name, int credits, String professorName )
    {
        this.name = name;
        this.credits = credits;
        this.professorName = professorName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
    
    public String getName() {
        return name;
    }

    public String getProfessorName() {
        return professorName;
    }
}
