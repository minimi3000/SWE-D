package service;

import model.User;
import model.WebsiteSubscription;

public class NotificationService {
    public void sendNotification(User user, WebsiteSubscription subscription, String message) {
        System.out.println("\uD83D\uDD14 Notification for " + user.getName() +
                " via " + subscription.getChannel() +
                " at " + user.getContactInfo() + ": " + message);
    }
}