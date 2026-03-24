import java.util.*;
import java.time.LocalDate;
import java.io.*;

// Study Log Class
class StudyLog
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
        return Date + " | " + Subject + " | " + Duration + " hrs | " + Description;
    }
}

// Study Tracker Class
class StudyTracker
{
    public ArrayList<StudyLog> Database = new ArrayList<>();

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("\n--- Enter Study Details ---");

        LocalDate Dateobj = LocalDate.now();

        System.out.print("Enter Subject: ");
        String sub = sobj.nextLine();

        System.out.print("Enter Duration (hours): ");
        double dur = sobj.nextDouble();
        sobj.nextLine();

        System.out.print("Enter Description: ");
        String desc = sobj.nextLine();

        StudyLog studyobj = new StudyLog(Dateobj, sub, dur, desc);
        Database.add(studyobj);

        System.out.println("✔ Study log stored successfully\n");
    }

    public void DisplayLog()
    {
        if(Database.isEmpty())
        {
            System.out.println("No data to display\n");
            return;
        }

        System.out.println("\n--- Study Logs ---");

        for(StudyLog s : Database)
        {
            System.out.println(s);
        }
        System.out.println();
    }

    public void ExportCSV()
    {
        if(Database.isEmpty())
        {
            System.out.println("No data to export\n");
            return;
        }

        String Filename = "StudyTracker.csv";

        try(FileWriter fw = new FileWriter(Filename))
        {
            fw.write("Date,Subject,Duration,Description\n");

            for(StudyLog s : Database)
            {
                fw.write(s.getDate() + "," +
                        s.getSubject().replace(",", " ") + "," +
                        s.getDuration() + "," +
                        s.getDescription().replace(",", " ") + "\n");
            }

            System.out.println("✔ Data exported to " + Filename);
        }
        catch(Exception e)
        {
            System.out.println("Error in CSV export");
        }
    }

    public void SummaryByDate()
    {
        if(Database.isEmpty())
        {
            System.out.println("No data available\n");
            return;
        }

        TreeMap<LocalDate, Double> map = new TreeMap<>();

        for(StudyLog s : Database)
        {
            map.put(s.getDate(),
                    map.getOrDefault(s.getDate(), 0.0) + s.getDuration());
        }

        System.out.println("\n--- Summary By Date ---");

        for(LocalDate d : map.keySet())
        {
            System.out.println(d + " → " + map.get(d) + " hrs");
        }
        System.out.println();
    }

    public void SummaryBySubject()
    {
        if(Database.isEmpty())
        {
            System.out.println("No data available\n");
            return;
        }

        TreeMap<String, Double> map = new TreeMap<>();

        for(StudyLog s : Database)
        {
            map.put(s.getSubject(),
                    map.getOrDefault(s.getSubject(), 0.0) + s.getDuration());
        }

        System.out.println("\n--- Summary By Subject ---");

        for(String sub : map.keySet())
        {
            System.out.println(sub + " → " + map.get(sub) + " hrs");
        }
        System.out.println();
    }
}

// Main Class
class Program902
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        StudyTracker stobj = new StudyTracker();

        int choice;

        do
        {
            System.out.println("------ Study Tracker ------");
            System.out.println("1. Insert Log");
            System.out.println("2. View Logs");
            System.out.println("3. Export CSV");
            System.out.println("4. Summary by Date");
            System.out.println("5. Summary by Subject");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sobj.nextInt();

            switch(choice)
            {
                case 1:
                    stobj.InsertLog();
                    break;

                case 2:
                    stobj.DisplayLog();
                    break;

                case 3:
                    stobj.ExportCSV();
                    break;

                case 4:
                    stobj.SummaryByDate();
                    break;

                case 5:
                    stobj.SummaryBySubject();
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while(choice != 0);
    }
}
