import java.util.Scanner;

class User 
{
    private String username;
    private String password;
    private String profile;

    public User(String username, String password, String profile) 
    {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getProfile() 
    {
        return profile;
    }

    public void setProfile(String profile) 
    {
        this.profile = profile;
    }

    public void updateProfile(String newProfile) 
    {
        this.profile = newProfile;
        System.out.println("Profile updated successfully!");
    }

    public void changePassword(String newPassword) 
    {
        this.password = newPassword;
        System.out.println("Password changed successfully!");
    }
}

class MCQ 
{
    private String question;
    private String[] options;
    private int correctOption;

    public MCQ(String question, String[] options, int correctOption) 
    {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() 
    {
        return question;
    }

    public String[] getOptions() 
    {
        return options;
    }

    public boolean isCorrect(int selectedOption) 
    {
        return selectedOption == correctOption;
    }
}

class Timer implements Runnable 
{
    private int seconds;
    private Thread thread;
    private boolean running = true;

    public Timer(int seconds) 
    {
        this.seconds = seconds;
    }

    public void start() 
    {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() 
    {
        running = false;
    }

    @Override
    public void run() 
    {
        while (seconds > 0 && running) 
        {
            try 
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            seconds--;
        }
        if (running) 
        {
            System.out.println("Time's up!");
            System.out.println("Logging out...");
        }
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        
        User user = new User("user123", "password123", "Default profile");

        if (!username.equals(user.getUsername()) || !password.equals(user.getPassword())) 
        {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        System.out.println("Login successful!");

        System.out.print("Do you want to update profile? (yes/no): ");
        String updateProfileChoice = scanner.nextLine();
        if (updateProfileChoice.equalsIgnoreCase("yes")) 
        {
            System.out.print("Enter new profile: ");
            String newProfile = scanner.nextLine();
            user.updateProfile(newProfile);
        }

        System.out.print("Do you want to change password? (yes/no): ");
        String changePasswordChoice = scanner.nextLine();
        if (changePasswordChoice.equalsIgnoreCase("yes")) 
        {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.changePassword(newPassword);
        }

        Timer timer = new Timer(30); 
        timer.start();

        MCQ[] mcqs = new MCQ[3];
        mcqs[0] = new MCQ("Who has the strongest bite in the animal kingdom?", new String[]{"Lion", "Hyena", "Crocodile", "Shark"}, 2); 
        mcqs[1] = new MCQ("What is the national animal of India?", new String[]{"Rhino", "Tiger", "Lion", "Elephant"}, 1); 
        mcqs[2] = new MCQ("Which is the largest ocean?", new String[]{"Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"}, 0); 

        int score = 0;
        for (MCQ mcq : mcqs) 
        {
            System.out.println(mcq.getQuestion());
            for (int i = 0; i < mcq.getOptions().length; i++) 
            {
                System.out.println((i + 1) + ". " + mcq.getOptions()[i]);
            }

            System.out.print("Enter your answer (1-4): ");
            int selectedOption = scanner.nextInt();

            if (mcq.isCorrect(selectedOption - 1)) 
            {
                System.out.println("Correct answer!");
                score += 10; 
            } 
            else 
            {
                System.out.println("Incorrect answer!");
            }
        }

        System.out.println("Your score: " + score);

        System.out.println("Session ended. Logging out...");
    }
}
