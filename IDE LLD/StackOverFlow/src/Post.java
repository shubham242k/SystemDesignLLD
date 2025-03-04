import java.util.ArrayList;
import java.util.List;

public abstract class Post {
    String id;
    User user;
    String content;
    List<Comment> commentList;
    List<Vote> votes;
    Post(User user, String content) {
        this.id = String.valueOf((System.currentTimeMillis() % Integer.MAX_VALUE));
        this.user = user;
        this.content = content;
        this.commentList = new ArrayList<>();
        this.votes = new ArrayList<>();
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public void addVote(User user, int val) {
        if(val == 1 || val == -1) {
            votes.removeIf(v -> v.getUser().equals(user));
            votes.add(new Vote(user, val));
            user.updateReputation(val * 3);
        }
    }

    public String getContent() {
        return content;
    }
    public User getAuthor() {
        return user;
    }
    public String getId() {
        return id;
    }

}
