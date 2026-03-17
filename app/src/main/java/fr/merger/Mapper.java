package fr.merger;

public class Mapper {

    public String map(String idsProperties, String targetJsonl) {
        String mappedString = targetJsonl;

        for (String line : idsProperties.split("\n")) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                String id = parts[1].trim();
                String value = parts[0].trim();
                mappedString = mappedString.replace("\"method\":" + id + "}", "\"method\":" + "\"" + value + "\"}");
            }
        }

        return mappedString;
    }
}
