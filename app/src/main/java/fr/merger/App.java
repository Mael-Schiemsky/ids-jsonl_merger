package fr.merger;

public class App {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage: java -jar merger.jar <ids.properties> <target.jsonl> <output_file.jsonl>");
            return;
        }

        Reader reader = new Reader();
        Mapper mapper = new Mapper();
        Writter writter = new Writter();

        System.out.println("Reading files...");
        String idsProperties = reader.readFile(args[0]);
        String targetJsonl = reader.readFile(args[1]);

        System.out.println("Mapping data...");
        String mappedData = mapper.map(idsProperties, targetJsonl);

        System.out.println("Writing output...");
        writter.writeFile(mappedData, args[2]);
    }
}
