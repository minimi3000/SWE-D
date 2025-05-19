package controller;

import model.User;
import model.WebsiteSubscription;
import service.NotificationService;
import service.UpdateChecker;

import java.util.List;

public class WebsiteMonitor {
    private List<User> users;
    private NotificationService notifier = new NotificationService();
    private UpdateChecker checker = new UpdateChecker();

    public WebsiteMonitor(List<User> users) {
        this.users = users;
    }

    public void checkWebsites() {
        for (User user : users) {
            for (WebsiteSubscription sub : user.getSubscriptions()) {
                if (checker.hasUpdate(sub.getUrl())) {
                    notifier.sendNotification(user, sub, "Update detected on: " + sub.getUrl());
                }
            }
        }
    }
}
