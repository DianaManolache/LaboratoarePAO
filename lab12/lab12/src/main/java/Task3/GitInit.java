package Task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GitInit {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GitInit <path>");
            return;
        }

        String path = args[0];
        File gitDir = new File(path, ".git");

        if (!gitDir.exists()) {
            if (gitDir.mkdirs()) {
                System.out.println("Created directory: " + gitDir.getAbsolutePath());

                File objectsDir = new File(gitDir, "objects");
                File refsDir = new File(gitDir, "refs");

                if (objectsDir.mkdir() && refsDir.mkdir()) {
                    System.out.println("Created directories: objects and refs");

                    File headFile = new File(gitDir, "HEAD");
                    try (FileWriter writer = new FileWriter(headFile)) {
                        writer.write("ref: refs/heads/main\n");
                        System.out.println("Created file: HEAD with content 'ref: refs/heads/main'");
                    } catch (IOException e) {
                        System.err.println("Failed to create HEAD file: " + e.getMessage());
                    }
                } else {
                    System.err.println("Failed to create objects or refs directory");
                }
            } else {
                System.err.println("Failed to create .git directory");
            }
        } else {
            System.err.println(".git directory already exists");
        }
    }
}

