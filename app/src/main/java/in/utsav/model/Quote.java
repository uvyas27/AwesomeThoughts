package in.utsav.model;

/**
 * Created by hp on 15-07-16.
 */
public class Quote {

    String titleText;
    String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    Quote(String titleText, String s2) {
        this.titleText = titleText;
        authorName = s2;
    }

}
