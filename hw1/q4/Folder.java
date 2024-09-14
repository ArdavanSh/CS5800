import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String folderName;
    private List<File> files;
    private List<Folder> subFolders;


    public Folder(String folderName) {
        this.folderName = folderName;
        this.files = new ArrayList<>();
        this.subFolders = new ArrayList<>();
    }

//    Create and add a file to the folder
    public void createFile(String fileName) {
        File file = new File(fileName);
        files.add(file);
    }

//    Create and add a subfolder to the folder
    public Folder createSubFolder(String subFolderName) {
        Folder subFolder = new Folder(subFolderName);  // Folder "owns" this SubFolder
        subFolders.add(subFolder);
        return subFolder;
    }

//    Remove a subfolder by name
    public void removeSubFolder(String folderName) {
        subFolders.removeIf(folder -> folder.folderName.equals(folderName));
    }

//    Get a subfolder by name
    public Folder getSubFolder(String folderName) {
        for (Folder folder : subFolders) {
            if (folder.folderName.equals(folderName)) {
                return folder;
            }
        }
        return null;
    }

//    Print function to display folder contents
    public void print() {
        System.out.println("Folder: " + folderName);

//        Print all files in the folder
        for (File file : files) {
            file.print();
        }

//        Recursively print all subfolders
        for (Folder subFolder : subFolders) {
            subFolder.print();
        }
    }
}

