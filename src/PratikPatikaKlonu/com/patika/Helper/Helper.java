package PratikPatikaKlonu.com.patika.Helper;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Helper {
    public static int centerPoint(String axis, int size){
        int cntrPoint;
        switch (axis){
            case "x" :
                cntrPoint = ((Toolkit.getDefaultToolkit().getScreenSize().width - size) / 2);
                break;
            case "y":
                cntrPoint = ((Toolkit.getDefaultToolkit().getScreenSize().height - size) / 2);
                break;
            default:
                cntrPoint = 0;
        }

        return cntrPoint;
    }

       public static void setLayout(){

        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            //System.out.println(info.getClassName() + "--" + info.getName());
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }

    }

    public static boolean isFieldEmpty(JTextField text){
        return text.getText().trim().isEmpty();
    }

    public static void optionPageTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
    }

    public static void showErrorMsg(String str){
        optionPageTR();
        String msg;
        String title = "HATA !!!";
        switch (str){
            case "fill":
                msg = "Lütfen Tüm Alanları Doldurunuz!";
                break;
            case "error":
                msg = "Bilinmeyen Bir Hata Oluştu!";
                break;
            case "duplicate":
                msg = "Kullanıcı Adı Başka Biri Tarafından Kullanılıyor" +
                        "\n Lütfen Başka Bir Kullanıcı Adı Seçip Tekrar Deneyiniz.";
                break;
            default:
                msg = str;
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.ERROR_MESSAGE);
    }


    public static void showInfoMsg(String str){
        optionPageTR();
        String title = "İşlem Durumu";
        String msg;
        switch (str){
            case "done":
            msg = "İşlem Başarıyla Tamamlandı!";
            break;
            default:
                msg = str;
        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
}
