package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String contactInfo;
    private List<WebsiteSubscription> subscriptions = new ArrayList<>();

    public User(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<WebsiteSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(WebsiteSubscription subscription) {
        subscriptions.add(subscription);
    }

    public void removeSubscription(int index) {
        if (index >= 0 && index < subscriptions.size()) {
            subscriptions.remove(index);
        }
    }

    @Override
    public String toString() {
        return name + " (" + contactInfo + ")";
    }
}