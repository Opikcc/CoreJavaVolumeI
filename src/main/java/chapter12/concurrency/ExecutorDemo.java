package chapter12.concurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This program demonstrates the Callable interface and executor
 * @version 1.0 2018-01-04
 * @author Cay Horstmann
 */
public class ExecutorDemo {
  
  /**
   * Counts occurences of a given word in a file.
   * @return the number of times the word occurs in the given
   */
  public static long occurence(String word, Path path) {
    try (var in = new Scanner(path)) {
      int count = 0;
      while (in.hasNext())
        if (in.next().equals(word)) count++;
      return count;
    }
    catch (IOException e) {
      return 0;
    }
  }
  
  /**
   * Returns all descendants of a given directory
   * @param rootDir the root directory
   * @return a set of all descendants of the root directory
   */
  public static Set<Path> descendants(Path rootDir) throws IOException {
    try (Stream<Path> entries = Files.walk(rootDir)) {
      return entries.filter(Files::isRegularFile).collect(Collectors.toSet());
    }
  }
  
  /**
   * Yields a task that searches for a word in a file.
   * @param word the word to search
   * @param path the file in which to search
   * @return the search task that yields the path upon success
   */
  public static Callable<Path> searchForTask(String word, Path path) {
    return () -> {
      try (var in = new Scanner(path)) {
        while (in.hasNext()) {
          if (in.next().equals(word))
            return path;
          if (Thread.currentThread().isInterrupted()) {
            System.out.println("Search in " + path + " cancelled.");
            return null;
          }
        }
        throw new NoSuchElementException();
      }
    };
  }
  
  public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {
    try (var in = new Scanner(System.in)) {
      System.out.print("Enter base directory (e.g. /opt/jdk-src): ");
      String start = in.nextLine();
      
      System.out.print("Enter keyword (e.g. volatile): ");
      String word = in.nextLine();
      
      Set<Path> files = descendants(Path.of(start));
      var tasks = new ArrayList<Callable<Long>>();
      
      for (Path file : files) {
        Callable<Long> task = () -> occurence(word, file);
        tasks.add(task);
      }
      
      ExecutorService executor = Executors.newCachedThreadPool();
      // Use a single thread executor instead to see if multithreading
      // speed up the search
      // ExecutorService executor = Executors.newSingleThreadPool();
      
      Instant startTime = Instant.now();
      List<Future<Long>> results = executor.invokeAll(tasks);
      long total = 0;
      for (Future<Long> result : results)
        total += result.get();
      Instant endTime = Instant.now();
      System.out.println("Occurences of " + word + ": " + total);
      System.out.println("Time elapsed: " + Duration.between(startTime, endTime).toMillis() + " ms");
    
      var searchTasks = new ArrayList<Callable<Path>>();
      for (Path file : files)
        searchTasks.add(searchForTask(word, file));
      Path found = executor.invokeAny(searchTasks);
      System.out.println(word + " occurs in: " + found);
      
      if (executor instanceof ThreadPoolExecutor)
        System.out.println("Largest pool size: " + ((ThreadPoolExecutor) executor).getLargestPoolSize());
      executor.shutdown();
    }
  }
  
}
