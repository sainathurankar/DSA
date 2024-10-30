package leetcode.medium;

import java.util.*;

//Google Interview Question
public class TopNTalkitive {
    public static void main(String[] args) {
        List<List<String>> topNUsers = getTopNTalkitiveUsers(4);
        System.out.println("Result: " + topNUsers);
    }

    private static List<List<String>> getTopNTalkitiveUsers(int N) {
        List<List<String>> messages = Helper.getMessages();
        System.out.println("Raw messages: " + messages);

        Map<String, Integer> userMessagesCount = new HashMap<>();
        messages.forEach(message -> {
            String user = message.get(0);
            int count = Integer.parseInt(message.get(1));
            userMessagesCount.put(user , userMessagesCount.getOrDefault(user, 0) + count);
        });

        System.out.println("Map: " + userMessagesCount);

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        userMessagesCount.entrySet().forEach(entry -> {
            queue.offer(entry);
        });
        List<List<String>> result = new ArrayList<>();
        for (int i=0; i<Math.min(queue.size(), N); i++) {
            if (!queue.isEmpty()) {
                Map.Entry<String, Integer> entry = queue.poll();
                result.add(Arrays.asList(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        return result;
    }
}


class Helper {

    public static List<List<String>> getMessages() {
        List<List<String>> messages = new ArrayList<>();
        List<String> users = Arrays.asList("sai", "john", "abhi", "kartik", "sainath");
        int numOfMessages = 10;
        users.forEach(user -> {
            Random random = new Random();
            for (int i=0; i<numOfMessages; i++) {
                List<String> userMessage = Arrays.asList(user, String.valueOf(random.nextInt(10)));
                messages.add(userMessage);
            }
        });
        return messages;
    }
}