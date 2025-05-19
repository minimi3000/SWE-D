package model;

public class WebsiteSubscription {
    private String url;
    private int frequencyMinutes;
    private CommunicationChannel channel;

    public WebsiteSubscription(String url, int frequencyMinutes, CommunicationChannel channel) {
        this.url = url;
        this.frequencyMinutes = frequencyMinutes;
        this.channel = channel;
    }

    public String getUrl() {
        return url;
    }

    public int getFrequencyMinutes() {
        return frequencyMinutes;
    }

    public CommunicationChannel getChannel() {
        return channel;
    }

    public void setFrequencyMinutes(int frequencyMinutes) {
        this.frequencyMinutes = frequencyMinutes;
    }

    public void setChannel(CommunicationChannel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "URL: " + url + ", Frequency: " + frequencyMinutes + " minutes, Channel: " + channel;
    }
}