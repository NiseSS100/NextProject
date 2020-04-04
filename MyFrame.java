import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class MyFrame extends JFrame{

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    MyModel model = null;
    int id = -1; //selected id

    //Clients Panel//
    JPanel panelClients = new JPanel();

    JPanel upPanelClients = new JPanel();
    JPanel midPanelClients = new JPanel();
    JPanel downPanelClients = new JPanel();

    JButton insertButtonClients = new JButton("Insert");
    JButton updateButtonClients = new JButton("Update");
    JButton delButtonClients = new JButton("Delete");
    JButton searchButtonClients = new JButton("Search by name");
    JButton buttonResetClients = new JButton("Възстанови");
    //Services Panel//
    JPanel panelServices = new JPanel();

    JPanel upPanelServices = new JPanel();
    JPanel midPanelServices = new JPanel();
    JPanel downPanelServices = new JPanel();

    JButton insertButtonServices = new JButton("Insert");
    JButton updateButtonServices = new JButton("Update");
    JButton delButtonServices = new JButton("Delete");
    JButton searchButtonServices = new JButton("Search by price");
    JButton buttonResetServices = new JButton("Възстанови");

    //Studio Panel//
    JPanel panelStudio = new JPanel();

    JPanel upPanelStudio = new JPanel();
    JPanel midPanelStudio = new JPanel();
    JPanel downPanelStudio = new JPanel();

    JButton insertButtonStudio = new JButton("Insert");
    JButton updateButtonStudio = new JButton("Update");
    JButton delButtonStudio = new JButton("Delete");
    JButton searchButtonStudio = new JButton("Search by date");
    JButton buttonResetStudio = new JButton("Възстанови");

    //Query Panel//
    JPanel panelQuery = new JPanel();

    JPanel upPanelQuery = new JPanel();
    JPanel midPanelQuery = new JPanel();
    JPanel downPanelQuery = new JPanel();

    JButton showQuery = new JButton("Show");

    //Query2 Panel//
    JPanel panelQuery2 = new JPanel();

    JPanel upPanelQuery2 = new JPanel();
    JPanel midPanelQuery2 = new JPanel();
    JPanel downPanelQuery2 = new JPanel();

    JButton showQuery2 = new JButton("Do");

    JTable tableClients = new JTable();
    JScrollPane scrollerClients = new JScrollPane(tableClients);

    JTable tableServices = new JTable();
    JScrollPane scrollerServices = new JScrollPane(tableServices);

    JTable tableStudio = new JTable();
    JScrollPane scrollerStudio = new JScrollPane(tableStudio);

    JTable tableQuery = new JTable();
    JScrollPane scrollerQuery = new JScrollPane(tableQuery);

    JTable tableQuery2 = new JTable();
    JScrollPane scrollerQuery2 = new JScrollPane(tableQuery2);

    JLabel nameLabel = new JLabel("Name:");
    JLabel numberLabel = new JLabel("Number:");
    JLabel serviceNameLabel = new JLabel("Service name:");
    JLabel numberDoneLabel = new JLabel("Fingers done:");
    JLabel priceLabel = new JLabel("Price");
    JLabel dateLabel = new JLabel("Date");
    JLabel timeLabel = new JLabel("Time");

    JLabel clientIDLabel = new JLabel("Client");
    JLabel serviceIDLabel = new JLabel("Service");

    JLabel nameQueryLabel = new JLabel("Enter Client Name:");
    JLabel dateQueryLabel = new JLabel("Enter Date:");
    JLabel nameSerQuery2Label = new JLabel("Enter Service Name:");
    JLabel timeQuery2Label = new JLabel("Enter Time:");

    JTextField nameTField = new JTextField();
    JTextField numberTField = new JTextField();
    JTextField serviceNameTField = new JTextField();
    String[] serviceNames = {" ","Гел лак","Обикновен лак"};
    JComboBox<String> serviceNameCombo = new JComboBox<>(serviceNames);
    JTextField numberDoneTField = new JTextField();
    JTextField priceTField = new JTextField();
    JTextField dateTField = new JTextField();
    JTextField timeTField = new JTextField();

    JTextField nameQueryTField = new JTextField();
    JTextField nameSerQuery2TField = new JTextField();
    JTextField dateQueryTField = new JTextField();
    JTextField timeQuery2TField = new JTextField();

    JTabbedPane tabbedPane = new JTabbedPane();

    JComboBox<String> ID_client = new JComboBox<>();
    JComboBox<String> ID_service = new JComboBox<>();

    public MyFrame() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(tabbedPane);


        tabbedPane.add("Клиенти", panelClients);
        tabbedPane.add("Услуги", panelServices);
        tabbedPane.add("Студио", panelStudio);
        tabbedPane.add("Справка", panelQuery);
        tabbedPane.add("Справка-2", panelQuery2);

        panelClients.setLayout(new GridLayout(3,1));
        panelClients.add(upPanelClients);
        panelClients.add(midPanelClients);
        panelClients.add(downPanelClients);

        panelServices.setLayout(new GridLayout(3,1));
        panelServices.add(upPanelServices);
        panelServices.add(midPanelServices);
        panelServices.add(downPanelServices);

        panelStudio.setLayout(new GridLayout(3,1));
        panelStudio.add(upPanelStudio);
        panelStudio.add(midPanelStudio);
        panelStudio.add(downPanelStudio);

        panelQuery.setLayout(new GridLayout(3,1));
        panelQuery.add(upPanelQuery);
        panelQuery.add(midPanelQuery);
        panelQuery.add(downPanelQuery);

        panelQuery2.setLayout(new GridLayout(3,1));
        panelQuery2.add(upPanelQuery2);
        panelQuery2.add(midPanelQuery2);
        panelQuery2.add(downPanelQuery2);

        //upPanel
        upPanelClients.setLayout(new GridLayout(2,2));
        upPanelClients.add(nameLabel);
        upPanelClients.add(nameTField);
        upPanelClients.add(numberLabel);
        upPanelClients.add(numberTField);

        upPanelServices.setLayout(new GridLayout(3,2));
        upPanelServices.add(serviceNameLabel);
        upPanelServices.add(serviceNameCombo);
        upPanelServices.add(numberDoneLabel);
        upPanelServices.add(numberDoneTField);
        upPanelServices.add(priceLabel);
        upPanelServices.add(priceTField);

        upPanelStudio.setLayout(new GridLayout(4,2));
        upPanelStudio.add(clientIDLabel);
        upPanelStudio.add(ID_client);
        refreshComboClientId();
        upPanelStudio.add(serviceIDLabel);
        upPanelStudio.add(ID_service);
        refreshComboServiceId();
        upPanelStudio.add(dateLabel);
        upPanelStudio.add(dateTField);
        upPanelStudio.add(timeLabel);
        upPanelStudio.add(timeTField);

        upPanelQuery.setLayout(new GridLayout(2,2));
        upPanelQuery.add(nameQueryLabel);
        upPanelQuery.add(nameQueryTField);
        upPanelQuery.add(dateQueryLabel);
        upPanelQuery.add(dateQueryTField);

        upPanelQuery2.setLayout(new GridLayout(2,2));
        upPanelQuery2.add(nameSerQuery2Label);
        upPanelQuery2.add(nameSerQuery2TField);
        upPanelQuery2.add(timeQuery2Label);
        upPanelQuery2.add(timeQuery2TField);

        //midPanel
        midPanelClients.add(insertButtonClients);
        midPanelClients.add(updateButtonClients);
        midPanelClients.add(delButtonClients);
        midPanelClients.add(searchButtonClients);
        midPanelClients.add(buttonResetClients);
        insertButtonClients.addActionListener(new AddActionClients());
        updateButtonClients.addActionListener(new UpdateActionClients());
        delButtonClients.addActionListener(new DeleteActionClients());
        searchButtonClients.addActionListener(new SearchActionClients());
        buttonResetClients.addActionListener(new ResetActionClients());

        midPanelServices.add(insertButtonServices);
        midPanelServices.add(updateButtonServices);
        midPanelServices.add(delButtonServices);
        midPanelServices.add(searchButtonServices);
        midPanelServices.add(buttonResetServices);
        insertButtonServices.addActionListener(new AddActionServices());
        updateButtonServices.addActionListener(new UpdateActionServices());
        delButtonServices.addActionListener(new DeleteActionServices());
        searchButtonServices.addActionListener(new SearchActionServices());
        buttonResetServices.addActionListener(new ResetActionService());

        midPanelStudio.add(insertButtonStudio);
        midPanelStudio.add(updateButtonStudio);
        midPanelStudio.add(delButtonStudio);
        midPanelStudio.add(searchButtonStudio);
        midPanelStudio.add(buttonResetStudio);
        insertButtonStudio.addActionListener(new AddActionStudio());
        updateButtonStudio.addActionListener(new UpdateActionStudio());
        delButtonStudio.addActionListener(new DeleteActionStudio());
        searchButtonStudio.addActionListener(new SearchActionStudio());
        buttonResetStudio.addActionListener(new ResetActionStudio());

        midPanelQuery.add(showQuery);
        midPanelQuery2.add(showQuery2);
        showQuery.addActionListener(new showQuery());
        showQuery2.addActionListener(new doQuery2());

        //downPanel
        scrollerClients.setPreferredSize(new Dimension(500,100));
        downPanelClients.add(scrollerClients);
        refreshTable("Clients", tableClients);
        tableClients.addMouseListener(new MouseActionClients());

        scrollerServices.setPreferredSize(new Dimension(500,100));
        downPanelServices.add(scrollerServices);
        refreshTable("Services",tableServices);
        tableServices.addMouseListener(new MouseActionServices());

        scrollerStudio.setPreferredSize(new Dimension(500,100));
        downPanelStudio.add(scrollerStudio);
        tableStudio.setModel(getFromTableStudio());
        tableStudio.addMouseListener(new MouseActionStudio());

        scrollerQuery.setPreferredSize(new Dimension(500,100));
        downPanelQuery.add(scrollerQuery);

        scrollerQuery2.setPreferredSize(new Dimension(500,100));
        downPanelQuery2.add(scrollerQuery2);
        this.setVisible(true);
    }//end constructor

    private MyModel getFromTableStudio() {
        conn = DBConnector.getConnection();
        String sql = "select ID_STUDIO,clients.name,SERVICES.name,date,time from STUDIO join clients on clients.ID_CLIENT = STUDIO.ID_CLIENT join SERVICES on SERVICES.ID_SERVICE = STUDIO.ID_SERVICE; ";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            model = new MyModel(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return model;
        }
    }

    public void refreshTable(String tableName, JTable table) {
        conn = DBConnector.getConnection();
        String sql = "select * from " + tableName;
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            model = new MyModel(result);
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DeleteActionClients implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnector.getConnection();
            String sql = "delete from clients where ID_CLIENT=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, id);
                state.execute();
                clearFormClients();
                refreshTable("Clients",tableClients);
                refreshComboClientId();
                id = -1;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    class DeleteActionServices implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            conn = DBConnector.getConnection();
            String sql = "delete from services where ID_SERVICE=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, id);
                state.execute();
                clearFormService();
                refreshTable("Services",tableServices);
                refreshComboServiceId();
                id = -1;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    class DeleteActionStudio implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnector.getConnection();
            String sql = "delete from studio where ID_STUDIO=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, id);
                state.execute();
                clearFormStudio();
                tableStudio.setModel(getFromTableStudio());
                id = -1;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    class MouseActionClients implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tableClients.getSelectedRow();
            id = Integer.parseInt(tableClients.getValueAt(row, 0).toString());
            if (e.getClickCount() > 1) {
                nameTField.setText(tableClients.getValueAt(row, 1).toString());
                numberTField.setText(tableClients.getValueAt(row, 2).toString());
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    class MouseActionServices implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tableServices.getSelectedRow();
            id = Integer.parseInt(tableServices.getValueAt(row, 0).toString());
            if(e.getClickCount() > 1) {
                serviceNameTField.setText(tableServices.getValueAt(row, 1).toString());
                if(tableServices.getValueAt(row,1).equals("Гел лак")){
                    serviceNameCombo.setSelectedIndex(1);
                }else if(tableServices.getValueAt(row,1).equals("Обикновен лак")){
                    serviceNameCombo.setSelectedIndex(2);
                }else{
                    serviceNameCombo.setSelectedIndex(0);
                }
                priceTField.setText(tableServices.getValueAt(row, 2).toString());
                numberDoneTField.setText(tableServices.getValueAt(row, 3).toString());
            }
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e){
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }

    class MouseActionStudio implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int row = tableStudio.getSelectedRow();
            id = Integer.parseInt(tableStudio.getValueAt(row, 0).toString());
            if (e.getClickCount() > 1) {
                dateTField.setText(tableStudio.getValueAt(row, 3).toString());
                timeTField.setText(tableStudio.getValueAt(row, 4).toString());
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    class AddActionClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameTField.getText();
            int number = Integer.parseInt(numberTField.getText());
            conn = DBConnector.getConnection();
            String query = "insert into clients values(null,?,?);";
            try {
                state = conn.prepareStatement(query);
                state.setString(1, name);
                state.setInt(2, number);
                state.execute();
                refreshTable("Clients",tableClients);
                clearFormClients();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }//end method
    }//end AddActionClients

    class AddActionServices implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float price = Float.parseFloat(priceTField.getText());
            int numberDone = Integer.parseInt(numberDoneTField.getText());
            String serviceName;
            if(serviceNameCombo.getSelectedIndex() == 0) {
                serviceName = "";
            }else if(serviceNameCombo.getSelectedIndex() == 1) {
                serviceName = "Гел лак";
            }else {
                serviceName = "Обикновен лак";
            }
            /*String serviceName2;
            if(serviceName2Combo.getSelectedIndex() == 0) {
                serviceName2 = "";
            }else if(serviceName2Combo.getSelectedIndex() == 1) {
                serviceName2 = "Декорация на по-малко от 3 пръста";
            }else {
                serviceName2 = "Декорация на повече от 3 пръста";
            }*/
            conn = DBConnector.getConnection();
            String query = "insert into services values(null,?,?,?);";
            try {
                state = conn.prepareStatement(query);
                state.setString(1, serviceName);
                state.setInt(3,numberDone);
                state.setFloat(2, price);
                state.execute();
                refreshTable("Services", tableServices);
                clearFormService();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }//end method
    }// end AddActionServices

    class AddActionStudio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String client = ID_client.getSelectedItem().toString().substring(0,ID_client.getSelectedItem().toString().indexOf('.'));
            String service = ID_service.getSelectedItem().toString().substring(0,ID_service.getSelectedItem().toString().indexOf('.'));
            String date = dateTField.getText();
            String time = timeTField.getText();
            conn = DBConnector.getConnection();
            String query = "insert into studio values(null,?,?,?,?);";
            try {
                state = conn.prepareStatement(query);
                state.setString(1,client);
                state.setString(2, service);
                state.setString(3, date);
                state.setString(4, time);
                state.execute();
                tableStudio.setModel(getFromTableStudio());
                clearFormStudio();
                id = -1;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }//end method
    }//end AddActionStudio

    class UpdateActionClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String name = nameTField.getText();
            String number = numberTField.getText();
            conn = DBConnector.getConnection();
            String sql = "update clients set name = ?,number = ? where ID_CLIENT = ?";
            try {
                state= conn.prepareStatement(sql);
                state.setString(1, name);
                state.setString(2, number);
                state.setInt(3, id);
                state.execute();
                clearFormClients();
                refreshTable("clients",tableClients);
                tableStudio.setModel(getFromTableStudio());
                refreshComboClientId();
                id = -1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class UpdateActionServices implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String serviceName = serviceNameCombo.getSelectedItem().toString();
            int numberDone = Integer.parseInt(numberDoneTField.getText());
            float price = Float.parseFloat(priceTField.getText());
            conn = DBConnector.getConnection();
            String sql = "update services set Name = ?, price = ?, number_Done = ? where ID_SERVICE = ?";
            try {
                state= conn.prepareStatement(sql);
                state.setString(1, serviceName);
                state.setInt(2, numberDone);
                state.setFloat(3, price);
                state.setInt(4, id);
                state.execute();
                clearFormService();
                refreshTable("Services",tableServices);
                tableStudio.setModel(getFromTableStudio());
                refreshComboServiceId();
                id = -1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class UpdateActionStudio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String client = ID_client.getSelectedItem().toString().substring(0,ID_client.getSelectedItem().toString().indexOf('.'));
            String service = ID_service.getSelectedItem().toString().substring(0,ID_service.getSelectedItem().toString().indexOf('.'));
            String date = dateTField.getText();
            String time = timeTField.getText();
            conn = DBConnector.getConnection();
            String sql = "update studio set id_client = ?, id_service = ?, date = ?, time = ? where ID_studio = ?";
            try {
                state= conn.prepareStatement(sql);
                state.setString(1,client);
                state.setString(2, service);
                state.setString(3, date);
                state.setString(4, time);
                state.setInt(5, id);
                state.execute();
                clearFormStudio();
                tableStudio.setModel(getFromTableStudio());
                id = -1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    class SearchActionClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String name = nameTField.getText();
            conn = DBConnector.getConnection();
            String sql = "select * from clients where name = ?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, name);
                result = state.executeQuery();
                model = new MyModel(result);
                tableClients.setModel(model);
                clearFormClients();
                refreshComboClientId();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class SearchActionServices implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            Float price = Float.parseFloat(priceTField.getText());
            conn = DBConnector.getConnection();
            String sql = "select * from services where price = ?";
            try {
                state = conn.prepareStatement(sql);
                state.setFloat(1, price);
                result = state.executeQuery();
                model = new MyModel(result);
                tableServices.setModel(model);
                clearFormService();
                refreshComboServiceId();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class SearchActionStudio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String date = dateTField.getText();
            conn = DBConnector.getConnection();
            String sql = "select ID_STUDIO,clients.name,SERVICES.name,date,time from STUDIO join clients on clients.ID_CLIENT = STUDIO.ID_CLIENT join SERVICES on SERVICES.ID_SERVICE = STUDIO.ID_SERVICE where date = ?;";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, date);
                result = state.executeQuery();
                model = new MyModel(result);
                tableStudio.setModel(model);
                clearFormStudio();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ResetActionClients implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTable("Clients", tableClients);
            clearFormClients();
        }
    }

    class ResetActionService implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTable("Services", tableServices);
            clearFormService();
        }
    }

    class ResetActionStudio implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            tableStudio.setModel(getFromTableStudio());
            clearFormStudio();
        }
    }

    public void refreshComboClientId() {
        ID_client.removeAllItems();
        conn = DBConnector.getConnection();
        String sql ="select  ID_client,name from clients";
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while(result.next()){
                item = result.getObject(1).toString()+"."+result.getObject(2).toString();
                ID_client.addItem(item);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshComboServiceId() {
        ID_service.removeAllItems();
        conn = DBConnector.getConnection();
        String sql ="select  ID_service,name from services";
        String item = "";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while(result.next()){
                item = result.getObject(1).toString()+"."+result.getObject(2).toString();
                ID_service.addItem(item);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    class showQuery implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent org) {
            String name = nameQueryTField.getText();
            String date = dateQueryTField.getText();
            conn = DBConnector.getConnection();
            String sql = "select ID_STUDIO,clients.name,SERVICES.name,date,time from STUDIO join clients on clients.ID_CLIENT = STUDIO.ID_CLIENT join SERVICES on SERVICES.ID_SERVICE = STUDIO.ID_SERVICE where clients.name =? and date = ?;";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, name);
                state.setString(2, date);
                result = state.executeQuery();
                model = new MyModel(result);
                tableQuery.setModel(model);
                clearFormQuery();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class doQuery2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent org) {
            String nameSer = nameSerQuery2TField.getText();
            String time = timeQuery2TField.getText();
            conn = DBConnector.getConnection();
            String sql = "select ID_STUDIO,clients.name,SERVICES.name,date,time from STUDIO join clients on clients.ID_CLIENT = STUDIO.ID_CLIENT join SERVICES on SERVICES.ID_SERVICE = STUDIO.ID_SERVICE where services.name =? and studio.time = ?;";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, nameSer);
                state.setString(2, time);
                result = state.executeQuery();
                model = new MyModel(result);
                tableQuery2.setModel(model);
                clearFormQuery2();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void clearFormClients() {
        nameTField.setText("");
        numberTField.setText("");
    }

    public void clearFormService() {
        serviceNameTField.setText("");
        numberDoneTField.setText("");
        priceTField .setText("");
    }
    public void clearFormStudio() {
        dateTField.setText("");
        timeTField.setText("");
    }

    public void clearFormQuery() {
        dateQueryTField.setText("");
        nameQueryTField.setText("");
    }

    public void clearFormQuery2() {
        nameSerQuery2TField.setText("");
        timeQuery2TField.setText("");
    }
}//end class MyFrame