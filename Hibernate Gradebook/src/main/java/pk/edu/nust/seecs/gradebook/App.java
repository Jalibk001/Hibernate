package pk.edu.nust.seecs.gradebook;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.dao.GradeDao;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.entity.Clo; 
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Grade;
import pk.edu.nust.seecs.gradebook.entity.Student;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        
        
        System.out.println("Press 1 for Content");
        System.out.println("Press 2 for Course");
        System.out.println("Press 3 for Student");
        System.out.println("Press 4 for Teacher");
        System.out.println("Press 5 for CLO");
        System.out.println("Press 6 for Grade");
        System.out.println("Your Choice: ");
        Scanner sc=new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
            {
                System.out.println("To Add Content press 1");
                System.out.println("To Delete Content press 2");
                System.out.println("To Retrieve Content press 3");
                System.out.print("Your Choice: ");
                int ch=sc.nextInt();
                ContentDao CD=new ContentDao();
                Content CT=new Content();
                if(ch==1)
                {
                    
                    System.out.print("Enter Title: ");
                    String title= sc.nextLine();
                    System.out.print("Enter Description: ");
                    String Desc= sc.nextLine();
                    CT.setDescription(Desc);
                    System.out.print("Enter Start Time: ");
                    String ST= sc.nextLine();
                    
                    System.out.print("Enter End Time: ");
                    String ET= sc.nextLine();
                    Date StT=(Date)formatter.parse(ST);
                    Date EdT=(Date)formatter.parse(ET);
                    CT.setEndtime(EdT);
                    CT.setStarttime(StT);
                    CT.setDescription(Desc);
                    CT.setTitle(title);
                    CD.addContent(CT);
                    CD.updateContent(CT);
                }
            if(ch==2)
            {
                System.out.print("Enter ID: ");
                    int ID= sc.nextInt();
                    CD.deleteContent(ID);
            }
            if(ch==3)
            {
                System.out.print("Press 1 to search by ID or press 2 to print All ");
                int myc=sc.nextInt();
                if(myc==1)
                {
                    System.out.println("Enter ID: ");
                    int ID=sc.nextInt();
                    System.out.println(CD.getContentById(ID));
                }
                if(myc==2)
                {
                    for (Content itr: CD.getAllContents())
                    {
                        System.out.println(itr);
                    }
                }
            }
        }
            break;
            case 2:
            {
                Course C=new Course();
                    CourseDao CD=new CourseDao();
                System.out.println("To Add course press 1\nTo Delete Course Press 2\nTo Print press 3\nYour Choice:");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    
                    System.out.println("Enter Class Title: ");
                    String title=sc.nextLine();
                    
                    System.out.println("Enter Starting time: ");
                    String st=sc.nextLine();
                    Date StT=(Date)formatter.parse(st);
                    System.out.println("Enter Ending time: ");
                    String et=sc.nextLine();
                    Date ET=(Date)formatter.parse(et);
                    System.out.println("Enter Credit hours: ");
                    int CH=sc.nextInt();
                    C.setCreditHours(CH);
                    C.setEndsOn(ET);
                    C.setStartsOn(StT);
                    C.setClasstitle(title);
                    CD.addCourse(C);
                    CD.updateCourse(C);
                    
                }
                if(ch==2)
                {
                    System.out.println("Enter Course ID:");
                    int id=sc.nextInt();
                    CD.deleteCourse(id);
                }
                if(ch==3)
                {
                    System.out.println("To Search by ID press 1 or To print all press 2");
                    int myc=sc.nextInt();
                    if(myc==1)
                    {
                        System.out.println("Enter ID: ");
                        int id=sc.nextInt();
                        System.out.println(CD.getCourseById(id));
                    }
                    if(myc==2)
                    {
                        for(Course itr:CD.getAllCourses())
                            System.out.println(itr);
                    }
                }
            }
            break;
            case 3:
            {
                Student s=new Student();
                StudentDao sd=new StudentDao();
                System.out.println("To Add Student Data press 1\nTo Delete Student press 2\nTo Retrieve Data press 3\nYour Choice:");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    System.out.println("Enter Student Name: ");
                    String name=sc.nextLine();
                    s.setName(name);
                    sd.addStudent(s);
                    sd.updateStudent(s);
                }
                if(ch==2)
                {
                    System.out.println("Enter Student ID: ");
                    int id=sc.nextInt();
                    sd.deleteStudent(id);
                }
                if(ch==3)
                {
                    System.out.println("To search by ID press 1 or to retrieve all press 2");
                    int id=sc.nextInt();
                    if(id==1){
                    System.out.println(sd.getStudentById(id));}
                    if(id==2)
                    {
                        for (Student itr:sd.getAllStudents())
                        {
                            System.out.println(itr);
                        }
                    }
                }
            }
            break;
            case 4:
            {
                Teacher t=new Teacher();
                TeacherDao td=new TeacherDao();
                System.out.println("To add a teacher press 1\nTo Delete a teacher press 2\nTo search for teacher press 3");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    System.out.print("Enter Teacher Name: ");
                    String name=sc.nextLine();
                    t.setName(name);
                    td.addTeacher(t);
                    td.updateTeacher(t);
                } 
                if(ch==2)
                {
                    System.out.println("Enter Teacher ID: ");
                    int id=sc.nextInt();
                    td.deleteTeacher(id);
                }
                if(ch==3)
                {
                    System.out.println("To search by ID press 1 or to print all press 2");
                    int myc=sc.nextInt();
                    if(myc==1)
                    {
                        System.out.println("Enter Teacher ID:");
                        int id=sc.nextInt();
                        System.out.println(td.getTeacherById(id));
                    }
                    if(myc==2)
                    {
                        for(Teacher itd:td.getAllTeachers())
                        {
                            System.out.print(itd);
                        }
                    }
                }
            }
            break;
            case 5:
            {
                Clo c=new Clo();
                CloDao cd=new CloDao();
                System.out.println("To Add CLO press 1\nTo Delete CLO press 2\nTo print CLO press 3:");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    System.out.println("Enter Name: ");
                    String name=sc.nextLine();
                    c.setName(name);
                    System.out.println("Enter Description: ");
                    String desc=sc.nextLine();
                    c.setDescription(desc);
                    System.out.println("Enter BT Level: ");
                    String BT=sc.nextLine();
                    c.setBtLevel(BT);
                    System.out.println("Enter PLO: ");
                    String plo=sc.nextLine();
                    c.setPlo(plo);
                    cd.addClo(c);
                    cd.updateClo(c);
                }
                if(ch==2)
                {
                    System.out.println("Enter CLO ID: ");
                    int ID=sc.nextInt();
                    cd.deleteClo(ID);
                }
                if(ch==3)
                {
                    System.out.println("To search by ID press 1 or to print all press 2");
                    int myc=sc.nextInt();
                    if(myc==1)
                    {
                        System.out.println("Enter ID: ");
                        int id=sc.nextInt();
                        System.out.println(cd.getCloById(id));
                    }
                    if(myc==2)
                    {
                        for(Clo itr:cd.getAllClos())
                        {
                            System.out.println(itr);
                        }
                    }
                }
            }
            case 6:
            {
                Grade g=new Grade();
                GradeDao gd=new GradeDao();
                System.out.println("To Add grades press 1\nTo delete Grades press 2\nTo View grades press 3\n");
                int ch=sc.nextInt();
                if(ch==1)
                {
                    System.out.println("Enter Name: ");
                    String name=sc.nextLine();
                    g.setName(name);
                    System.out.println("Enter Score: ");
                    int score=sc.nextInt();
                    g.setScore(score);
                    gd.addGrade(g);
                    gd.updateGrade(g);
                }
                if(ch==2)
                {
                    System.out.println("Enter ID: ");
                    int ID=sc.nextInt();
                    gd.deleteGrade(ID);
                }
                if(ch==3)
                {
                    System.out.println("To Search by ID press 1 and to print all press 2");
                    int myc=sc.nextInt();
                    if(myc==1)
                    {
                        System.out.println("Enter ID: ");
                        int ID=sc.nextInt();
                        System.out.println(gd.getGradeById(ID));
                    }
                    if(myc==2)
                    {
                        for(Grade itr:gd.getAllGrades())
                        {
                            System.out.println(itr);
                        }
                    }
                }
            }
        }
    }
}