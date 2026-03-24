import java.util.*;
import java.time.LocalDate;
import java.io.*;
import java.time.LocalDateTime;

// Done
class Studylog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;
    
    public StudyLog(LocalDate a, String b, double c, String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;

    }

    public LocalDate getDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }

    @Override
    public String toString()
    {
        return Date+ " | "+Subject+" | "+Duration+ " | "+Description;
    }

}
// DONE
class StudyTracker
{
    public ArrayList <StudyLog>Database = new ArrayList<StudyLog>();

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("---------------------------------------------");
        System.out.println("------Enter Valid Details of your Study------");
        System.out.println("----------------------------------------------");

        LocalDate Dateobj = LocalDate.now();

        System.out.println("Please Enter the Name of Subject like C/C++/Java/Python");
        String sub = sobj.nextLine();

        System.out.println("Enter the time period of your study in hours");
        double dur = sobj.nextDouble();
        sobj.nextLine();

        System.out.println("Please provide the decription of your study");
        String desc = sobj.nextLine();

        StudyLog studyobj = new StudyLog(Dateobj, sub, dur, desc);

        Database.add(studyobj);

        System.out.println("Study logs gets stored successfully");
        System.out.println("------------------------------------");
    }

    public void DisplayLog()
    {
        System.out.println("--------------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("-------------------Nothing to Display---------------");
            System.out.println("--------------------------------------------------");
            return;
        }

        System.out.println("------Log report of Marvellous Study Tracker-------");
        System.out.println("--------------------------------------------------");

         for(StudyLog s : Database)
         {
            System.out.println(s);
         }

        System.out.println("--------------------------------------------------");


    }

    public void ExportCSV()
    {
        if(Database.isEmpty())
        {
            System.out.println("-------------------Nothing to Display---------------");
            System.out.println("--------------------------------------------------");
            System.out.println("-------------------Nothing to Display---------------");
            return;
        
    }

    String Filename = "MarvellousStudyTracker.csv";

    try(FileWriter fwobj = new FileWriter(Filename))
    {
        fwobj.write("Date,Subject,Duration,Description\n");

        for(Studying s : Database)
        {
            fwobj.write(s.getDate()+","+s.getSubject().replace(","," ")+","+s.getDuration()+","+s.getDescription().replace(","," "+"\n"));
        }

        System.out.println("Data get Exported in CSV : "+Filename);
    }
    catch(Exception eobj)
    {
        System.out.println("Exception occured in CSV handling");
    }
}
    public void SummaryByDate()
    {
        System.out.println("-------------------------------------------------------");
         if(Database.isEmpty())
         {
            System.out.println("-----Nothing to display as database is Empty-----------");
            System.out.println("-------------------------------------------------------");

             return;
         }

         System.out.println("---------Summary by date from Study Tracker-------------");
          System.out.println("-------------------------------------------------------");

          TreeMap <LocalDate, Double>tobj = new TreeMap<LocalDate, Double>();

            LocalDate lobj = null;
            double d = 0.0, old = 0.0;

          for(StudyLog sobj : Database)
          {
            lobj = sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj,d+old);
            }
            else
            {
                tobj.put(lobj,d);
            }
          }

          // Display he details as per date
          for(LocalDate l : tobj.keySet())
          {
            System.out.println("Date : "+l+"Total study duration : "+tobj.get(l));
            
          }
           System.out.println("-------------------------------------------------------");

    }
    public void SummaryBySubject()
    {
         System.out.println("-------------------------------------------------------");
         if(Database.isEmpty())
         {
            System.out.println("Nothing to display as database is Empty");
            System.out.println("-------------------------------------------------------");

             return;
         }

         System.out.println("Summary by subject from Study Tracker");
          System.out.println("-------------------------------------------------------");

          TreeMap <String, Double>tobj = new TreeMap<String, Double>();

            String s = null;
            double d = 0.0, old = 0.0;

          for(StudyLog sobj : Database)
          {
            s = sobj.getsubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);
                tobj.put(s,d+old);
            }
            else
            {
                tobj.put(s,d);
            }
          }

          // Display he details as per subject
          for(String str : tobj.keySet())
          {
            System.out.println("Subject : "+str+"Total study duration : "+tobj.get(str));
            
          }
           System.out.println("-------------------------------------------------------");
    }
}
class program902
{
    public static void main(String A[])
    {
       Scanner sobj = new Scanner(System.in);
       StudyTracker stobj = new StudyTracker();

       System.out.println("-------------------------------------------------------");
       System.out.println("---------Welcome to Marvellous Study Tracker------------");
       System.out.println("--------------------------------------------------------");

       int iChoice = 0;

       do
       {
            System.out.println("Please select the appropriate option")
            System.out.println("1 : Insert new study log");
            System.out.println("2 : View all study log");
            System.out.println("3 : Summary of study log by date");
            System.out.println("4 : Summary of study log by Subject");
            System.out.println("5 : Exit the application");

            iChoice = sobj.nextInt();

            switch(iChoice)
            {

                case1:
                stobj.InsertLo();
                break:

                case2:
                stobj.DisplayLog();
                break;

                case3:
                stobj.ExportCSV();
                break;

                case4:
                Stobj.SummaryByDate();
                break;

                // Summary of study log by subject
                case5:
                stobj.SummaryBysubject();
                break;

                // Exit the application
                case6:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("------Thankyou for using Marvellous Study Tracker Application------");
                System.out.println("-------------------------------------------------------------------");

                default:
                    System.out.println("Please enter valid option");
                    break;

            }
       }
    }
}