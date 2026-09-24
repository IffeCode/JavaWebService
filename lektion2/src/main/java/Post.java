import com.fasterxml.jackson.annotation.JsonInclude;

public class Post {

    private int userID;
    private String title;
    private String body;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int id;


    public Post() {
        this.userID = 0;
        this.title = "";
        this.body = "";
        this.id = 0;
    }
    public Post(int userID, String title, String body, int id) {
        this.userID = userID;
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Post [" +
                "userID=" + userID +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                ']';
    }
}
