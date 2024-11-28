import java.util.ArrayList;
import java.util.List;

class NewsAgency {
    private final List<String> headlines = new ArrayList<>();
    private final List<String> content = new ArrayList<>();
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getName() + " has subscribed!");
    }

    public void removeSubscriber(String name) {
        subscribers.removeIf(subscriber -> subscriber.getName().equals(name));
        System.out.println(name + " has unsubscribed.");
    }

    public List<String> getHeadlines() {
        return headlines;
    }

    public void setHeadlines(List<String> newHeadlines) {
        headlines.clear();
        headlines.addAll(newHeadlines);
    }

    public void publishHeadline(String headline) {
        headlines.add(headline);
        notifySubscribers(headline);
    }

    public void publishContent(String newsContent) {
        content.add(newsContent);
    }


    public List<String> getContent() {
        return content;
    }


    public void setContent(List<String> newContent) {
        content.clear();
        content.addAll(newContent);
    }


    public List<Subscriber> getSubscribers() {
        return subscribers;
    }


    public void setSubscribers(List<Subscriber> newSubscribers) {
        subscribers.clear();
        subscribers.addAll(newSubscribers);
    }

    private void notifySubscribers(String headline) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveUpdate(headline);
        }
    }
}
