import controller.CitizenController;

public class App {
    static CitizenController citizenController = new CitizenController();

    public static void main(String[] args) throws Exception {
        launch();
    }

    public static void launch(){
        citizenController.run();
    }
}
