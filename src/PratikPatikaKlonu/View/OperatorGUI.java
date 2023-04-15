package PratikPatikaKlonu.View;

import PratikPatikaKlonu.Helper.Helper;
import PratikPatikaKlonu.Model.Operator;
import PratikPatikaKlonu.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame {
    private final Operator operator;
    private JPanel pnlWrapper;
    private JTabbedPane tabbedPane1;
    private JPanel pnlLeft;
    private JLabel lblWelcome;
    private JButton btnExit;
    private JScrollPane scrlUserList;
    private JTable tblUserList;
    private JPanel pnlRight;
    private JLabel lblName;
    private JTextField txtName;
    private JTextField txtUsername;
    private JLabel lblPass;
    private JTextField txtPass;
    private JComboBox cmbType;
    private JButton btnAdd;
    private JButton btnUserDelete;
    private JTextField txtUserDelete;
    private DefaultTableModel mdlUserList;
    private Object[] rowUserList;

    public OperatorGUI(Operator operator){
        operator.setName("Özgür Girilen kullancı adı ile değiştir!");
        lblWelcome.setText("Hoşgeldiniz " + operator.getName());
        this.operator = operator;
        Helper.setLayout();
        setContentPane(pnlWrapper);
        setSize(1050,450);
        setVisible(true);
        setResizable(false);
        setLocation(Helper.centerPoint("x",getSize().width),Helper.centerPoint("y",getSize().height));
        //Model User List
        mdlUserList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };


        Object[] colUserList = {"ID","Ad Soyad" ,"Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        rowUserList = new Object[colUserList.length];
        mdlUserList.setColumnIdentifiers(colUserList);
        tblUserList.setModel(mdlUserList);
        tblUserList.getTableHeader().setReorderingAllowed(false);
        getUserTable();

        tblUserList.getModel().addTableModelListener(e ->{
            if(e.getType() == TableModelEvent.UPDATE){
                if(tblUserList.getSelectedRow() > -1){ // for exception index -1 out of bounds for length
                    int id = Integer.parseInt(tblUserList.getValueAt(tblUserList.getSelectedRow(),0).toString());
                    String name = tblUserList.getValueAt(tblUserList.getSelectedRow(),1).toString();
                    String username = tblUserList.getValueAt(tblUserList.getSelectedRow(),2).toString();
                    String pass = tblUserList.getValueAt(tblUserList.getSelectedRow(),3).toString();
                    String type = tblUserList.getValueAt(tblUserList.getSelectedRow(),4).toString();
                    if(User.updateUser(id,name,username,pass,type)){
                        Helper.showInfoMsg("done");
                    }else {
                        Helper.showErrorMsg("Ekleme İşlemi Sırasında Beklenmeyen Hata Oluştu!");
                    }
                }
                getUserTable();
            }

        });


        tblUserList.getSelectionModel().addListSelectionListener(e ->{
            if(tblUserList.getSelectedRow() > -1){ // for exception index -1 out of bounds for length
                String selectUserID = tblUserList.getValueAt(tblUserList.getSelectedRow(),0).toString();
                txtUserDelete.setText(selectUserID);
            }

        });

        btnExit.addActionListener(e ->{
            this.dispose();
            LoginGUI loginGUI = new LoginGUI();
        });

        btnUserDelete.addActionListener(e->{
            if(Helper.isFieldEmpty(txtUserDelete)){
                Helper.showErrorMsg("fill");
            }else {
                if (User.deleteUser(Integer.parseInt(txtUserDelete.getText()))){
                    Helper.showInfoMsg("done");
                    getUserTable();
                }

            }
        });

        btnAdd.addActionListener(e ->{
            if(Helper.isFieldEmpty(txtName) || Helper.isFieldEmpty(txtUsername) || Helper.isFieldEmpty(txtPass)){
                Helper.showErrorMsg("fill");
            }else {
                if(User.getFetch(txtUsername.getText()) != null){
                    Helper.showErrorMsg("duplicate");
                }else{
                    String name = txtName.getText();
                    String username = txtUsername.getText();
                    String pass = txtPass.getText();
                    String usertype = cmbType.getSelectedItem().toString();
                    if(User.addUser(name,username,pass,usertype)){
                        Helper.showInfoMsg("done");
                        getUserTable();
                        txtName.setText(null);
                        txtUsername.setText(null);
                        txtPass.setText(null);
                        cmbType.setSelectedIndex(0);
                    }else {
                        Helper.showErrorMsg("error");
                    }
                }
            }
        });

    }

    private void getUserTable(){

        DefaultTableModel clearModel = (DefaultTableModel) tblUserList.getModel();
        clearModel.setRowCount(0);
        for(User user : User.getUserList()){
            int i = 0;
            rowUserList[i++] = user.getId();
            rowUserList[i++] = user.getName();
            rowUserList[i++] = user.getUsername();
            rowUserList[i++] = user.getPass();
            rowUserList[i++] = user.getType();
            mdlUserList.addRow(rowUserList);
            txtUserDelete.setText(null);
        }
    }

}
