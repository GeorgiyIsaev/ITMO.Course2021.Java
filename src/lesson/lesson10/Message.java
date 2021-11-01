package lesson.lesson10;


import java.util.Comparator;

public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
class MessageContentComparator implements Comparator<Message> {

    @Override
    public int compare(Message message1, Message message2) {
        // здесь мы должны определить, как эти два аргумента будут сравниваться
       // return 0;


        int firstLength = message1.getContent().length();
        int secondLength = message2.getContent().length();
        return Integer.compare(firstLength, secondLength);
    }
}


