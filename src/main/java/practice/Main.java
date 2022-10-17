package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        while (true) {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                String command = "";
                String toDo = "";
                String index = "";
                int ind;
                Pattern pattern = Pattern.compile("(ADD|LIST|EDIT|DELETE|STOP)\\s*(\\d*)\\s?(.*)");
                Matcher matcher = pattern.matcher(input);

                if (matcher.find()) {
                    command = matcher.group(1);
                    index = matcher.group(2);
                    toDo = matcher.group(3);
                } else {  break; }
                if (index.isEmpty()) {
                    ind = 0;
                } else {
                    ind = Integer.valueOf(index);
                }
                switch (command) {
                    case "ADD":
                        if (ind == 0) {
                            todoList.add(toDo);
                        } else {
                            todoList.add(ind, toDo);
                        }
                    case "EDIT" :
                        todoList.edit(ind, toDo);
                        break;
                    case "LIST" :
                        todoList.getTodos();
                        break;
                    case "DELETE" :
                        todoList.delete(ind);
                        break;
                }
            }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
