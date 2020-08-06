package todoapp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Tasks {

  public void listTasks(String fileName) {
    try {
      Path filePath = Paths.get(fileName);
      List<String> lines = Files.readAllLines(filePath);
      if (lines.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        for (int i = 0; i < lines.size(); i++){
          if (lines.get(i).charAt(lines.get(i).length() - 1) != ' ') {
            System.out.println((i + 1) + " - " + "[ ] " + lines.get(i));
          } else {
            System.out.println((i + 1) + " - " + "[x] " + lines.get(i));
          }
        }
      }
    } catch (Exception e) {
      System.out.println("could not read file");
    }
  }

  public void addTask(String fileName, String taskName) {
    try {
      Path filePath = Paths.get(fileName);
      Files.write(filePath, (taskName + "\n").getBytes(), StandardOpenOption.APPEND);
    } catch (Exception e) {
      System.out.println("could not read file");
    }
  }

  public void checkTask(String fileName, String index) {
    try {
      Path filePath = Paths.get(fileName);
      List<String> lines = Files.readAllLines(filePath);
      lines.add((Integer.valueOf(index) - 1), lines.get(Integer.valueOf(index)-1) + " ");
      lines.remove(lines.get(Integer.valueOf(index)));
      Files.write(filePath, lines);
    } catch (Exception e) {
      System.out.println("could not read file");
    }
  }

  public void removeTask(String fileName, String index) {
    try {
      Path filePath = Paths.get(fileName);
      List<String> lines = Files.readAllLines(filePath);
      lines.remove(lines.get(Integer.valueOf(index) - 1));
      Files.write(filePath, lines);
    } catch (Exception e) {
      System.out.println("could not read file");
    }
  }
}
