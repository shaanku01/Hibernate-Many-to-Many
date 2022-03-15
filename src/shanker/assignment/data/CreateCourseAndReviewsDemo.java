package shanker.assignment.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String args[]){
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create Session
        Session session = factory.getCurrentSession();

        try{
            //Start the transaction
            session.beginTransaction();

            //create a course
            // create reviews and add them to course
            //save the course

            Course tempCourse = new Course("Maths");


            session.save(tempCourse);




            Student stu1 = new Student("Shanker","Sai","shankersai.gr@zemosolabs.com");
            Student stu2 = new Student("Vineet" , "G", "vineet.g@zemosolabs.com");


            tempCourse.add(stu1);
            tempCourse.add(stu2);





            //save the students::
            session.save(stu1);
            session.save(stu2);







            //commit the transaction:
            session.getTransaction().commit();


        }finally {

            session.close();
            factory.close();
        }


    }
}
