package shanker.assignment.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteACourseDemo {

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

            //get a student based on ID:

            int id = 11;
            Course tempCourse = session.get(Course.class,id);

            session.delete(tempCourse);













            //commit the transaction:
            session.getTransaction().commit();


        }finally {

            session.close();
            factory.close();
        }


    }
}
