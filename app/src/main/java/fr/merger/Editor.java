package fr.merger;

import java.util.Stack;

public class Editor {

    public String addIdOnExit(String targetJsonl) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(String line : targetJsonl.split("\n")) {
            if(line.contains("\"enter\"")) {
                result.append(line + "\n");
                stack.push(line);

            } else if(line.contains("\"exit\"") && !stack.isEmpty()) {
                String previousEnter = stack.pop();
                String newLine = previousEnter.replace("\"enter\"", "\"exit\"");
                result.append(newLine + "\n");
            }
        }
         
        return result.toString();
    }
}
