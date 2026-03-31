abstract class CourseType {
    String courseName;

    CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName) {
        super(courseName);
    }
}

import java.util.ArrayList;
import java.util.List;

class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }

    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Math Exam"));
        examCourses.addCourse(new ExamCourse("Physics Exam"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Java Assignment"));
        assignmentCourses.addCourse(new AssignmentCourse("DBMS Assignment"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research"));
        researchCourses.addCourse(new ResearchCourse("Robotics Research"));

        System.out.println("Exam Courses:");
        displayCourses(examCourses.getCourses());

        System.out.println("\nAssignment Courses:");
        displayCourses(assignmentCourses.getCourses());

        System.out.println("\nResearch Courses:");
        displayCourses(researchCourses.getCourses());
    }
}