import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ChatAppTest {

    @Test
    public void testSendMessage() {
        ChatServer chatServer = new ChatServer();

        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        alice.sendMessage("Hello Bob!", Collections.singletonList(bob));

        List<Message> bobMessages = bob.getChatHistory().getMessages();
        assertEquals(1, bobMessages.size());
        Message message = bobMessages.get(0);
        assertEquals("Hello Bob!", message.getContent());
        assertEquals(alice, message.getSender());
    }

    @Test
    public void testUndoLastMessage() {
        ChatServer chatServer = new ChatServer();

        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        alice.sendMessage("This message will be undone.", Collections.singletonList(bob));

        alice.undoLastMessage();

        List<Message> bobMessages = bob.getChatHistory().getMessages();
        assertTrue(bobMessages.isEmpty());

        List<Message> aliceMessages = alice.getChatHistory().getMessages();
        assertTrue(aliceMessages.isEmpty());
    }

    @Test
    public void testBlockUser() {
        ChatServer chatServer = new ChatServer();

        User bob = new User("Bob", chatServer);
        User charlie = new User("Charlie", chatServer);

        bob.blockUser(charlie);

        charlie.sendMessage("Are you there, Bob?", Collections.singletonList(bob));

        List<Message> bobMessages = bob.getChatHistory().getMessages();
        assertTrue(bobMessages.isEmpty());

        List<Message> charlieMessages = charlie.getChatHistory().getMessages();
        assertEquals(1, charlieMessages.size());
    }

    @Test
    public void testReceiveMessage() {
        ChatServer chatServer = new ChatServer();

        User bob = new User("Bob", chatServer);
        User alice = new User("Alice", chatServer);

        bob.sendMessage("Hi Alice!", Collections.singletonList(alice));

        List<Message> aliceMessages = alice.getChatHistory().getMessages();
        assertEquals(1, aliceMessages.size());
        Message message = aliceMessages.get(0);
        assertEquals("Hi Alice!", message.getContent());
        assertEquals(bob, message.getSender());
    }

    @Test
    public void testChatHistory() {
        ChatServer chatServer = new ChatServer();

        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);
        User charlie = new User("Charlie", chatServer);

        alice.sendMessage("Message to Bob.", Collections.singletonList(bob));
        alice.sendMessage("Message to Charlie.", Collections.singletonList(charlie));

        bob.sendMessage("Reply to Alice.", Collections.singletonList(alice));

        List<Message> aliceMessages = alice.getChatHistory().getMessages();
        assertEquals(3, aliceMessages.size()); // 2 sent, 1 received

        List<Message> bobMessages = bob.getChatHistory().getMessages();
        assertEquals(2, bobMessages.size()); // 1 received, 1 sent

        List<Message> charlieMessages = charlie.getChatHistory().getMessages();
        assertEquals(1, charlieMessages.size()); // 1 received
    }
}
