import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main Application Class
public class App {
    public static void main(String[] args) {
        boolean exit = false;
        NewsAgency newsAgency = new NewsAgency();
        Subscriber dan = new Subscriber("Dan");
        newsAgency.addSubscriber(dan);

        newsAgency.publishHeadline("Historic Eclipse Visible Tonight!");
        newsAgency.publishContent("A rare solar eclipse will be visible tonight across most of the northern hemisphere.");

        Scanner input = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nWelcome to the News Subscription System!");
            System.out.println("[1] Subscriber Menu\n[2] Admin Menu\n[0] Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    manageSubscribers(newsAgency);
                    break;
                case 2:
                    manageNews(newsAgency);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageSubscribers(NewsAgency newsAgency) {
        Scanner input = new Scanner(System.in);
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("\nSubscriber Menu");
            System.out.println("[1] Register\n[2] View News\n[3] Unsubscribe\n[0] Back");
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 0:
                    backToMenu = true;
                    break;
                case 1:
                    System.out.print("Enter your name to register: ");
                    String name = input.nextLine();
                    Subscriber newSubscriber = new Subscriber(name);
                    newsAgency.addSubscriber(newSubscriber);
                    System.out.println(name + " has been successfully registered!");
                    break;
                case 2:
                    System.out.println("\nLatest Headlines:");
                    List<String> headlines = newsAgency.getHeadlines();
                    for (int i = 0; i < headlines.size(); i++) {
                        System.out.println((i + 1) + ". " + headlines.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Enter your name to unsubscribe: ");
                    String unsubscribeName = input.nextLine();
                    newsAgency.removeSubscriber(unsubscribeName);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageNews(NewsAgency newsAgency) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nAdmin: Create New News");
        System.out.print("Enter headline: ");
        String headline = input.nextLine();
        System.out.print("Enter news content: ");
        String content = input.nextLine();

        newsAgency.publishHeadline(headline);
        newsAgency.publishContent(content);
        System.out.println("News published successfully!");
    }
}
