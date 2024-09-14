public class Main {
    public static void main(String[] args) {

//        Creat php_demo1 folder and its subfolder and files
        Folder phpDemo1 = new Folder("php_demo1");
        phpDemo1.createSubFolder("Source Files");
        phpDemo1.createSubFolder("Include Path");
        phpDemo1.createFile("Remote Files");

//        Add source files content
        phpDemo1.getSubFolder("Source Files").createSubFolder(".phalcon");
        phpDemo1.getSubFolder("Source Files").createSubFolder("app");
        phpDemo1.getSubFolder("Source Files").createSubFolder("cache");
        phpDemo1.getSubFolder("Source Files").createSubFolder("public");
        phpDemo1.getSubFolder("Source Files").createFile(".htaccess");
        phpDemo1.getSubFolder("Source Files").createFile(".htrouter.php");
        phpDemo1.getSubFolder("Source Files").createFile("index.html");

        phpDemo1.getSubFolder("Source Files").getSubFolder("app").createSubFolder("config");
        phpDemo1.getSubFolder("Source Files").getSubFolder("app").createSubFolder("controllers");
        phpDemo1.getSubFolder("Source Files").getSubFolder("app").createSubFolder("library");
        phpDemo1.getSubFolder("Source Files").getSubFolder("app").createSubFolder("migrations");
        phpDemo1.getSubFolder("Source Files").getSubFolder("app").createSubFolder("models");
        phpDemo1.getSubFolder("Source Files").getSubFolder("app").createSubFolder("views");

//        phpDemo1.print();
        phpDemo1.getSubFolder("Source Files").removeSubFolder("app");
//        phpDemo1.print();
        phpDemo1.getSubFolder("Source Files").removeSubFolder("public");
        phpDemo1.print();
    }
}