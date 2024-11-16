import java.util.*;

class ChatServer {
    private Map<String, User> users = new HashMap<>();
    private Map<User, Set<User>> blockedUsers = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getName(), user);
        blockedUsers.putIfAbsent(user, new HashSet<>());
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
        blockedUsers.remove(user);
    }

    public void sendMessage(Message message) {
        List<User> recipients = message.getRecipients();
        for (User recipient : recipients) {
            if (users.containsKey(recipient.getName())) {
                Set<User> blockedByRecipient = blockedUsers.get(recipient);
                if (blockedByRecipient != null && blockedByRecipient.contains(message.getSender())) {
                    // Message is blocked by recipient
                    continue;
                }
                recipient.receiveMessage(message);
            }
        }
    }

    public void blockUser(User blocker, User blockee) {
        blockedUsers.get(blocker).add(blockee);
    }

    public void unblockUser(User blocker, User blockee) {
        blockedUsers.get(blocker).remove(blockee);
    }

    public void undoMessage(User sender, Message message) {
        // Remove the message from the sender's chat history
        sender.getChatHistory().removeMessage(message);

        // Notify recipients to remove the message from their chat history
        List<User> recipients = message.getRecipients();
        for (User recipient : recipients) {
            recipient.removeMessageFromHistory(message);
        }
    }
}

