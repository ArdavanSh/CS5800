public class Main {
    public static void main(String[] args) {
//        First Driver Code
//        Instructor instructor = new Instructor("Nima", "Davarpanah", "3-2636");
//        Textbook textbook = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
//        Course course = new Course("Software Engineering", instructor, textbook);
//        course.printCourseDetails();

//        Second Driver code
//        Create two instructor objects
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");
        Instructor instructor2 = new Instructor("John", "Doe", "2-1234");

//        Create two textbook objects
        Textbook textbook1 = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Textbook textbook2 = new Textbook("Effective Java", "Joshua Bloch", "Addison-Wesley");

//        Create a course object
        Course course = new Course("Software Engineering", instructor1, instructor2, textbook1, textbook2);

//        Print the course details
        course.printCourseDetails();

    }
}