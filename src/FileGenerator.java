import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileGenerator {
    String path;

    public FileGenerator(String path) {
        if (path.endsWith(".json")) {
            this.path = path;
        } else {
            this.path = path + ".json";
        }
    }

    public void saveJson(Address address) {
        try {
            FileWriter writer = new FileWriter(this.path);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(address));
            writer.close();
        } catch (Exception e) {
            System.out.println(String.format("Failed to save result to '%s'", this.path));
            System.out.println("Exception message: " + e.getMessage());
            throw new RuntimeException("Finalizing now!");
        }
    }

}
