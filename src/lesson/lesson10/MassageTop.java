package lesson.lesson10;

import java.time.LocalDate;
import java.util.Comparator;

public class MassageTop {

    private final String from;
    private final String content;
    private final LocalDate created;
    private int likes;

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreated() {
        return created;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public MassageTop(String from, String content, int likes, String created) {
        this.from = from;
        this.content = content;
        this.likes = likes;
        this.created = LocalDate.parse(created);
    }

    // getters and setters

    @Override
    public String toString() {
        return created.toString() + " " + from + " wrote: " +
                content + " (" + likes + ")";
    }
}

class MessageDateComparator implements Comparator<MassageTop> {

    @Override
    public int compare(MassageTop message1, MassageTop message2) {
        return message1.getCreated().compareTo(message2.getCreated());
    }
}

class MessageAuthorComparator implements Comparator<MassageTop> {

    @Override
    public int compare(MassageTop message1, MassageTop message2) {
        return message1.getFrom().compareTo(message2.getFrom());
    }
}

