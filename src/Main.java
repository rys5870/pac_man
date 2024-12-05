import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SetImages images = new SetImages();
        images.lowdImages();

        MyForm windowHome = new MyForm();
        windowHome.setVisible(true);
        windowHome.setSize(400,400);

    }
}