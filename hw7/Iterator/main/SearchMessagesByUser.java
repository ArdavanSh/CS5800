import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class SearchMessagesByUser implements Iterator<Message> {
    private List<Message> messages;
    private User userToSearchWith;
    private int currentIndex = 0;
    private Message nextMessage = null;

    public SearchMessagesByUser(List<Message> messages, User userToSearchWith) {
        // Create a copy of messages to assume immutability during iteration
        this.messages = new ArrayList<>(messages);
        this.userToSearchWith = userToSearchWith;
        advanceToNext();
    }

    private void advanceToNext() {
        nextMessage = null;
        while (currentIndex < messages.size()) {
            Message message = messages.get(currentIndex++);
            if (message.getSender().equals(userToSearchWith) || message.getRecipients().contains(userToSearchWith)) {
                nextMessage = message;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextMessage != null;
    }

    @Override
    public Message next() {
        if (nextMessage == null) {
            throw new NoSuchElementException();
        }
        Message returnMessage = nextMessage;
        advanceToNext();
        return returnMessage;
    }
}
