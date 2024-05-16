package part2;
import java.util.*;
public class part2_task4 {
        public static void main(String[] args) {
            Map<String, Integer> participants = new HashMap<>();

            // Simulate participants and their scores
            Random random = new Random();
            for (int i = 1; i <= 20; i++) {
                String participant = "Participant " + i;
                int score = random.nextInt(100) + 1; // Random score between 1 and 100
                participants.put(participant, score);
            }

            // Sort participants by score in descending order
            List<Map.Entry<String, Integer>> sortedParticipants = new ArrayList<>(participants.entrySet());
            sortedParticipants.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            // Display top 10 participants
            System.out.println("Top 10 Participants:");
            for (int i = 0; i < Math.min(10, sortedParticipants.size()); i++) {
                Map.Entry<String, Integer> entry = sortedParticipants.get(i);
                System.out.println(entry.getKey() + " - Score: " + entry.getValue());
            }

            // Display top three winners
            System.out.println("\nTop Three Winners:");
            for (int i = 0; i < Math.min(3, sortedParticipants.size()); i++) {
                Map.Entry<String, Integer> entry = sortedParticipants.get(i);
                System.out.println(entry.getKey() + " - Score: " + entry.getValue());
            }
        }

}
