import java.util.*;

class ChatHistory {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getLastSentMessage(User sender) {
        for (int i = messages.size() - 1; i >= 0; i--) {
            if (messages.get(i).getSender().equals(sender)) {
                return messages.get(i);
            }
        }
        return null;
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
}

