public abstract class ContentItem {
    private int id;
    private static int idGen = 1;
    private String title;
    private int year;
    private int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        this.id = idGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title is blank");
        this.title = title;
    }

    public void setYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        if (year < 1990 || year > currentYear) throw new IllegalArgumentException("Invalid year");
        this.year = year;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) throw new IllegalArgumentException("Duration must be > 0");
        this.durationMinutes = durationMinutes;
    }

    public int getYear() { return year; }
    public int getDurationMinutes() { return durationMinutes; }
    public int getAge(int currentYear) { return currentYear - year; }

    public abstract double getLicenseCost(int currentYear);

    @Override
    public String toString() {
        return "ID: " + id + " | " + title + " (" + year + ") | " + durationMinutes + " min";
    }
}
