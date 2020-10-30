package pt.pa;

public class PrintJob implements Comparable<PrintJob> {
    private String name;
    private Priority priority;
    private int numberPages;

    public PrintJob(String name, Priority priority, int numberPages) {
        this.name = name;
        this.priority = priority;
        this.numberPages = numberPages;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getNumberPages() {
        return numberPages;
    }

    @Override
    public int compareTo(PrintJob printJob) {
        return this.priority.ordinal() - printJob.getPriority().ordinal();
    }

    @Override
    public String toString() {
        return "" + name + "\n" + "Pages: " + numberPages;
    }
}
