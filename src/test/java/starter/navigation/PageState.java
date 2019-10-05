package starter.navigation;

public class PageState {
    private String url;
    private String title;
    private boolean available;

    PageState(String url, String title, boolean available) {
        this.url = url;
        this.title = title;
        this.available = available;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }
}
