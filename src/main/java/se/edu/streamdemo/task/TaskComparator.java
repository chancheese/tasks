package se.edu.streamdemo.task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2) {
        return t1.getDescription().compareToIgnoreCase(t2.getDescription());
    }
}

public static void printDeadlinesUsingStreams(ArrayList<Task> tasks) {
    System.out.println("Using Streams...");
    tasks.stream()
            .filter(t -> t instanceof Deadline)
            .sorted((t1, t2) -> t1.getDescription().compareToIgnoreCase(t2.getDescription()))
            .forEach(System.out::println);
}

public static ArrayList<Task> filterTaskByString(ArrayList<Task> tasks, String filterString) {
    ArrayList<Task> filteredList = tasks.stream()
            .filter(t -> t.getDescription().contains(filterString))
            .collect(Collectors.toList());
    return filteredList;
}