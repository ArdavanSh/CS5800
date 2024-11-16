import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ChatAppIteratorTest {

    @Test
    public void testIteratorWithMessagesInvolvingUser() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        alice.sendMessage("Hi Bob!", Collections.singletonList(bob));
        alice.sendMessage("How are you?", Collections.singletonList(bob));

        User charlie = new User("Charlie", chatServer);
        alice.sendMessage("Hello Charlie!", Collections.singletonList(charlie));

        Iterator<Message> iterator = alice.iterator(bob);

        List<Message> messagesInvolvingBob = new ArrayList<>();
        while (iterator.hasNext()) {
            messagesInvolvingBob.add(iterator.next());
        }

        assertEquals(2, messagesInvolvingBob.size());

        assertEquals("Hi Bob!", messagesInvolvingBob.get(0).getContent());
        assertEquals("How are you?", messagesInvolvingBob.get(1).getContent());
    }

    @Test
    public void testIteratorWithNoMessagesInvolvingUser() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User charlie = new User("Charlie", chatServer);

        alice.sendMessage("Hello Charlie!", Collections.singletonList(charlie));
        alice.sendMessage("Are you coming today?", Collections.singletonList(charlie));

        User bob = new User("Bob", chatServer);
        Iterator<Message> iterator = alice.iterator(bob);

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorAfterUndoingMessage() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        alice.sendMessage("First message to Bob.", Collections.singletonList(bob));
        alice.sendMessage("Second message to Bob.", Collections.singletonList(bob));

        alice.undoLastMessage();

        Iterator<Message> iterator = alice.iterator(bob);

        List<Message> messagesInvolvingBob = new ArrayList<>();
        while (iterator.hasNext()) {
            messagesInvolvingBob.add(iterator.next());
        }

        assertEquals(1, messagesInvolvingBob.size());

        assertEquals("First message to Bob.", messagesInvolvingBob.get(0).getContent());
    }

    @Test
    public void testIteratorAfterBlockingUser() {
        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        alice.sendMessage("Hello Bob!", Collections.singletonList(bob));

        bob.blockUser(alice);

        alice.sendMessage("Are you there?", Collections.singletonList(bob));

        Iterator<Message> iterator = bob.iterator(alice);

        List<Message> messagesInvolvingAlice = new ArrayList<>();
        while (iterator.hasNext()) {
            messagesInvolvingAlice.add(iterator.next());
        }

        assertEquals(1, messagesInvolvingAlice.size());
        assertEquals("Hello Bob!", messagesInvolvingAlice.get(0).getContent());
    }

    @Test
    public void testIteratorWithNoMessagesAtAll() {

        ChatServer chatServer = new ChatServer();
        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        Iterator<Message> iterator = alice.iterator(bob);

        assertFalse(iterator.hasNext());
    }
}
