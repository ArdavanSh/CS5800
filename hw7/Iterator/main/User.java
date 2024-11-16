import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class User implements IterableByUser {
    private String name;
    private ChatServer chatServer;
    private ChatHistory chatHistory;
    private Stack<MessageMemento> mementos;

    public User(String name, ChatServer chatServer) {
        this.name = name;
        this.chatServer = chatServer;
        this.chatHistory = new ChatHistory();
        this.mementos = new Stack<>();
        chatServer.registerUser(this);
    }

    public String getName() {
        return name;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public void sendMessage(String content, List<User> recipients) {
        Message message = new Message(this, recipients, content);
        chatHistory.addMessage(message);

        MessageMemento memento = new MessageMemento(content, message.getTimestamp());
        mementos.push(memento);

        chatServer.sendMessage(message);
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessage(message);
        System.out.println(this.name + " received a message from " + message.getSender().getName() + ": " + message.getContent());
    }

    public void removeMessageFromHistory(Message message) {
        chatHistory.removeMessage(message);
        System.out.println(this.name + " had a message removed from " + message.getSender().getName());
    }

    public void undoLastMessage() {
        if (!mementos.isEmpty()) {
            Message lastMessage = chatHistory.getLastSentMessage(this);
            if (lastMessage != null) {
                chatServer.undoMessage(this, lastMessage);
                mementos.pop();
                System.out.println(this.name + " has undone the last message.");
            } else {
                System.out.println(this.name + " has no messages to undo.");
            }
        } else {
            System.out.println(this.name + " has no messages to undo.");
        }
    }

    public void blockUser(User user) {
        chatServer.blockUser(this, user);
        System.out.println(this.name + " has blocked " + user.getName());
    }

    public void unblockUser(User user) {
        chatServer.unblockUser(this, user);
        System.out.println(this.name + " has unblocked " + user.getName());
    }

    public void viewChatHistory() {
        System.out.println("Chat history for " + this.name + ":");
        for (Message message : chatHistory.getMessages()) {
            System.out.println("[" + message.getTimestamp() + "] " + message.getSender().getName() + ": " + message.getContent());
        }
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}

