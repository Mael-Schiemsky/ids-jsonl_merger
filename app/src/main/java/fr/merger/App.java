package fr.merger;

import java.io.File;

public class App {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java -jar app.jar <directory_path where ids.properties and target.jsonl are located>");
            return;
        }

        Reader reader = new Reader();
        Editor editor = new Editor();
        Mapper mapper = new Mapper();
        Writer writer = new Writer();

        String directoryPath = args[0];

        File dir = new File(directoryPath);
        File[] files = dir.listFiles();

        String idsProperties = reader.readFile(directoryPath + "/ids.properties");

        for (File file : files) {
            String fileName = file.getName();

            if(fileName.matches("thread-[0-9]*\\.jsonl")) {
                System.out.println("Reading " + fileName + " file...");
                String targetJsonl = reader.readFile(file.getPath());

                System.out.println("Adding ID on EXIT in " + fileName + "...");
                targetJsonl = editor.addIdOnExit(targetJsonl);

                System.out.println("Mapping " + fileName + " data...");
                String mappedData = mapper.map(idsProperties, targetJsonl);

                System.out.println("Writing merged " + fileName + " output...");
                writer.writeFile(mappedData, directoryPath + "/merged_" + fileName);
            }
        }
    }
}
