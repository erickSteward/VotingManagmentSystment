import controller.CitizenController;
import dao.CitizenDao;
import sevice.CitizenService;

import java.util.Scanner;

public class AppMain {



    public static void main(String[] args) throws Exception {
        System.out.println("************** Welcome Patriot System *************");
        launch();
    }

    public static void launch(){
        VotingManger votingManger = new VotingManger();
        votingManger.run();
    }



}
