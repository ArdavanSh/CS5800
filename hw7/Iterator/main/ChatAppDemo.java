import java.util.*;

public class ChatAppDemo {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);
        User charlie = new User("Charlie", chatServer);

        // Alice sends a message to Bob and Charlie
        List<User> recipients = Arrays.asList(bob, charlie);
        alice.sendMessage("Hello Bob and Charlie!", recipients);

        // Bob sends a message to Alice
        bob.sendMessage("Hi Alice!", Collections.singletonList(alice));

        // Charlie sends a message to Alice and Bob
        charlie.sendMessage("Hey everyone!", Arrays.asList(alice, bob));

        // Bob block Charlie
        bob.blockUser(charlie);

        // Charlie sends another message to Bob
        charlie.sendMessage("Bob, can you see this?", Collections.singletonList(bob));

        // Bob shouldn't receive the message from Charlie
        // check Bob's chat history
        System.out.println("\nBob's chat history:");
        bob.viewChatHistory();

        // Alice undoes her last message
        alice.undoLastMessage();

        // check Alice's, Bob's, and Charlie's chat histories
        System.out.println("\nAlice's chat history:");
        alice.viewChatHistory();

        System.out.println("\nBob's chat history after Alice undid her message:");
        bob.viewChatHistory();

        System.out.println("\nCharlie's chat history after Alice undid her message:");
        charlie.viewChatHistory();

        // Using the iterator to iterate over messages involving Bob
        System.out.println("\nAlice iterating over messages involving Bob:");
        Iterator<Message> iterator = alice.iterator(bob);
        while (iterator.hasNext()) {
            Message message = iterator.next();
            System.out.println("[" + message.getTimestamp() + "] " + message.getSender().getName()
                    + " to " + getRecipientNames(message) + ": " + message.getContent());
        }
    }

    private static String getRecipientNames(Message message) {
        List<String> names = new ArrayList<>();
        for (User user : message.getRecipients()) {
            names.add(user.getName());
        }
        return String.join(", ", names);
    }
}


