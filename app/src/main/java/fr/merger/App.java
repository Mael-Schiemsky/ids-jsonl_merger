package fr.merger;

public class App {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage: java -jar app.jar <ids.properties> <target.jsonl> <output_file.jsonl>");
            return;
        }

        Reader reader = new Reader();
        Editor editor = new Editor();
        Mapper mapper = new Mapper();
        Writer writer = new Writer();

        System.out.println("Reading files...");
        String idsProperties = reader.readFile(args[0]);
        String targetJsonl = reader.readFile(args[1]);

        System.out.println("Adding ID on EXIT...");
        targetJsonl = editor.addIdOnExit(targetJsonl);

        System.out.println("Mapping data...");
        String mappedData = mapper.map(idsProperties, targetJsonl);

        System.out.println("Writing output...");
        writer.writeFile(mappedData, args[2]);
    }
}
