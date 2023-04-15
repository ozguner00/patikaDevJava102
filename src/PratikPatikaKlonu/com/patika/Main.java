package PratikPatikaKlonu.com.patika;

import PratikPatikaKlonu.com.patika.Model.Operator;
import PratikPatikaKlonu.com.patika.Model.User;
import PratikPatikaKlonu.com.patika.View.LoginGUI;
import PratikPatikaKlonu.com.patika.View.OperatorGUI;

public class Main {
    public static void main(String[] args) {
        //LoginGUI e = new LoginGUI();
        Operator op = new Operator();
        OperatorGUI eg = new OperatorGUI(op);

    }

}
