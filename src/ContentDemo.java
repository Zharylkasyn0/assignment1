import java.util.ArrayList;

public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Assignment-1", 2024, 60, "HD"));
        items.add(new VideoLecture("OOP Lecture", 2024, 90, "4K"));
        items.add(new PodcastEpisode("About 1 Lesson", 2025, 30, "Students IT-2509"));
        items.add(new PodcastEpisode("How to use Git", 2025, 45, "Traxel Xeniya"));

        int currentYear = java.time.Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(item.toString() + " | Cost: $" + item.getLicenseCost(currentYear));


            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads: " + d.getMaxDownloadsPerDay());
            }
            System.out.println("---");
        }
    }
}
