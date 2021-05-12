package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    public static class WorldData extends Data {
        public String Active(String s){
             String output1 = getData(s);
            int i3 = output1.indexOf("active",0);
            int index3 = output1.indexOf(':',i3);
            int index32 = output1.indexOf(',',index3);
            String Active = output1.substring(index3+1,index32);
            return Active;

        }
        public String death( String s){
            String output = getData(s);
            int i1 = output.indexOf("deaths",0);
            int index1 = output.indexOf(':',i1);
            int index12 = output.indexOf(',',index1);
            String deaths = output.substring(index1+1,index12);
            return deaths;
        }
        public String recover(String s){
            String output = getData(s);
            int i2 = output.indexOf("recovered",0);
            int index2 = output.indexOf(':',i2);
            int index22 = output.indexOf(',',index2);
            String recovered = output.substring(index2+1,index22);
            return recovered;
        }



    }
    public static class CityData extends city{

        public String Active(String s){
            String output1 = getData(s);
            int i = output1.indexOf(s,0);
            int i3 = output1.indexOf("active",i);
            int index3 = output1.indexOf(':',i3);
            int index32 = output1.indexOf(',',index3);
            String Active = output1.substring(index3+1,index32);
            return Active;

        }
        public String confirmed( String s){
            String output = getData(s);
            int i = output.indexOf(s,0);
            int i1 = output.indexOf("confirmed",i);
            int index1 = output.indexOf(':',i1);
            int index12 = output.indexOf(',',index1);
            String confirmed = output.substring(index1+1,index12);
            return confirmed;
        }
        public String recover(String s){
            String output = getData(s);
            int i = output.indexOf(s,0);
            int i2 = output.indexOf("recovered",i);
            int index2 = output.indexOf(':',i2);
            int index22 = output.indexOf(',',index2);
            String recovered = output.substring(index2+1,index22);
            return recovered;
        }
    }
    public static class StateData extends state{

        int index11 = 0;

        public String confirmed( String s){
            String output = getData(s);
            int i = output.indexOf(s,0);
            int i1 = output.indexOf(",",i);
            int index1 = output.indexOf(',',i1+1);
            index11 = index1;
            String confirmed = output.substring(i1+1,index1);
            return confirmed;
        }
        int index22 = 0;

        public String recover(String s){
            String output = getData(s);
            int i2 = output.indexOf(',',index11);
            int index2 = output.indexOf(',',i2+1);
            index22 = index2;
            String recovered = output.substring(i2+1,index2);
            return recovered;
        }
        int index33 = 0;
        public String Death(String s){
            String output = getData(s);
            int i3 = output.indexOf(',',index22);
            int index3 = output.indexOf(',',i3+1);
            index33 = index3;
            String deaths = output.substring(i3+1,index3);
            return deaths;
        }
        public String Active(String s){
            String output = getData(s);
            int i4 = output.indexOf(',',index33);
            int index4 = output.indexOf(',',i4+1);
            String Active = output.substring(i4+1,index4);
            return Active;

        }
    }



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Corona tracker");

        Image image = new Image(new FileInputStream("/Users/yoshin/Downloads/90.gif"));
        ImageView imageView = new ImageView(image);
        Group root = new Group();
        imageView.setFitHeight(580);
        imageView.setFitWidth(600);
        Image image1 = new Image(new FileInputStream("/Users/yoshin/Downloads/tp for t-shirt 2 2.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setY(340);
        imageView1.setFitHeight(80);
        imageView1.setFitWidth(80);
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(580);
        imageView2.setFitWidth(600);
        ImageView imageView3 = new ImageView(image1);
        imageView3.setY(340);
        imageView3.setFitHeight(80);
        imageView3.setFitWidth(80);
        Text text14 = new Text(25,230,"Select State");
        Text text15= new Text(25,290,"Select district");
        Text text16 = new Text(150,200,"India Data");


        //Setting the text to be added.
//        text.setText("World cases");
//        text.setX(200);text.setY(5);
        Rectangle rectangle1 = new Rectangle(25,100,100,70);
        Rectangle rect2 = new Rectangle(150,100,100,70);
        Rectangle rect3 = new Rectangle(270,100,100,70);
        DropShadow ds = new DropShadow();
        ds.setOffsetY(5.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));


        String family = "Helvetica";
        double size = 19;
        Text text10 = new Text(140,20,"CORONA TRACKER");
        text10.setFont(Font.font("Serif", FontWeight.EXTRA_BOLD,
                FontPosture.REGULAR, 60));
        text10.setFill(Color.RED);
        text10.setFontSmoothingType(FontSmoothingType.LCD);
        text10.setEffect(ds);
        text10.setFont(Font.font(family, size));
        text10.setFill(Color.RED);

//        Text text = new Text(150,100, "World Cases");
        Text text11 = new Text(140,40, "World Cases");
        text11.setFont(Font.font(family, size));
        text11.setFill(Color.RED);
        WorldData world = new WorldData();

        Text text1 = new Text(160,140, world.death("world"));
        Text text2 = new Text(270,140, world.recover("world"));
        text1.setFont(Font.font(family, size));
        text1.setFill(Color.RED);
        text2.setFont(Font.font(family, size));
        text2.setFill(Color.RED);
        Text text3 = new Text(40,140, world.Active("world"));
        text3.setFont(Font.font(family, size));
        text3.setFill(Color.RED);
        Text text5 = new Text(50,90,"Active");
        Text text6 = new Text(170,90,"Death");
        Text text7 = new Text(270,90,"Recovered");
        text5.setFont(Font.font(family, size));
        text5.setFill(Color.RED);
        text6.setFont(Font.font(family, size));
        text6.setFill(Color.RED);
        text7.setFont(Font.font(family, size));
        text7.setFill(Color.RED);

        root.getChildren().addAll(imageView,imageView1);
        root.getChildren().add(rectangle1);
        root.getChildren().add(rect2);
        root.getChildren().add(rect3);
//        root.getChildren().add(text);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().addAll(text3,text7,text5,text6);
        root.getChildren().addAll(text10,text11);
        CityData city = new CityData();
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox1 = new ComboBox();
        comboBox.setLayoutX(-100);
        comboBox.setLayoutY(20);
        comboBox1.setLayoutX(20);
        comboBox1.setLayoutY(170);






        comboBox.getItems().addAll("Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chhattisgarh",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttarakhand",
                "Uttar Pradesh",
                "West Bengal",
                "Andaman and Nicobar Islands",
                "Chandigarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Delhi",
                "Lakshadweep",
                "Puducherry");

        comboBox.setTranslateX(200);
        comboBox.setTranslateY(200);
        comboBox1.setTranslateX(100);
        comboBox1.setTranslateY(100);
        Rectangle rectangle4 = new Rectangle(25,100,100,70);
        Rectangle rect5 = new Rectangle(150,100,100,70);
        Rectangle rect6 = new Rectangle(270,100,100,70);

        Group root2 = new Group();

        Scene scene1 = new Scene(root2,450,450);
        root2.getChildren().addAll(imageView2,imageView3,rect5,rect6,rectangle4);
        StateData stateData = new StateData();
        Image image3 = new Image(new FileInputStream("/Users/yoshin/Downloads/Webp.net-resizeimage-2.png"));
        ImageView imageview5 = new ImageView(image3);

        Button back = new Button("Back");
        back.setMaxSize(20,20);
        back.setGraphic(imageview5);
        back.setShape(new Circle(1.5));
        back.setMaxSize(2,2);
        Scene scene = new Scene(root, 400, 400);

        String HimachalPradesh[] = {"Bilaspur", "Chamba","Hamirpur" , "Kangra" , "Kinnaur" , "Kullu" , "Lahaul & Spiti" , "Mandi" , "Shimla" , "Sirmaur" , "Solan" , "Una"};
        String JK[] = {"Anantnag", "Bandipore", "Baramulla", "Budgam", "Doda", "Ganderbal", "Jammu", "Kathua", "Kishtwar", "Kulgam","Kupwara", "Poonch", "Pulwama", "Rajouri", "Ramban", "Reasi", "Samba", "Shopian", "Srinagar", "Udhampur"};
        String goa[] = { "North Goa", "South Goa"};
        String AndhraPradesh[]= {"Adilabad", "Anantapur", "Chittoor", "Kakinada", "Guntur", "Hyderabad", "Karimnagar", "Khammam", "Krishna", "Kurnool", "Mahbubnagar", "Medak", "Nalgonda", "Nizamabad", "Ongole", "Hyderabad", "Srikakulam", "Nellore", "Visakhapatnam", "Vizianagaram", "Warangal", "Eluru", "Kadapa"};
        String ArunachalPradesh[] ={"Anjaw", "Changlang", "East Siang", "Kurung Kumey", "Lohit", "Lower Dibang Valley", "Lower Subansiri", "Papum Pare", "Tawang", "Tirap", "Dibang Valley", "Upper Siang", "Upper Subansiri", "West Kameng", "West Siang"};
        String Assam[] = {"Baksa","Barpeta","Bongaigaon","Cachar","Chirang","Darrang","Dhemaji","Dima Hasao","Dhubri","Dibrugarh","Goalpara","Golaghat","Hailakandi","Jorhat","Kamrup","Kamrup Metropolitan","Karbi Anglong","Karimganj","Kokrajhar","Lakhimpur","Marigaon","Nagaon","Nalbari","Sibsagar","Sonitpur","Tinsukia","Udalguri"};
        String Bihar[] = {"Araria", "Arwal", "Aurangabad","Banka", "Begusarai", "Bhagalpur", "Bhojpur", "Buxar", "Darbhanga", "East Champaran", "Gaya", "Gopalganj", "Jamui", "Jehanabad", "Kaimur", "Katihar", "Khagaria", "Kishanganj", "Lakhisarai", "Madhepura","Madhubani", "Munger", "Muzaffarpur", "Nalanda", "Nawada", "Patna", "Purnia", "Rohtas", "Saharsa", "Samastipur", "Saran", "Sheikhpura", "Sheohar", "Sitamarhi", "Siwan", "Supaul", "Vaishali", "West Champaran","Chandigarh"};
        String Chattisgarh[] = {"Bastar", "Bijapur", "Bilaspur", "Dantewada", "Dhamtari", "Durg", "Jashpur", "Janjgir-Champa", "Korba", "Koriya", "Kanker", "Kabirdham (Kawardha)", "Mahasamund", "Narayanpur", "Raigarh", "Rajnandgaon", "Raipur", "Surguja"};
        String DamanDui[] = {"Daman","Diu"};
        String Delhi[] = {"Central Delhi", "East Delhi", "New Delhi", "North Delhi", "North East Delhi", "North West Delhi", "South Delhi", "South West Delhi", "West Delhi"};
        String Gujrat[] = {"Ahmedabad", "Amreli district", "Anand", "Banaskantha", "Bharuch", "Bhavnagar", "Dahod", "The Dangs", "Gandhinagar", "Jamnagar", "Junagadh", "Kutch", "Kheda", "Mehsana", "Narmada", "Navsari", "Patan", "Panchmahal","Porbandar", "Rajkot", "Sabarkantha", "Surendranagar", "Surat", "Vyara", "Vadodara", "Valsad"};
        String Jharkhand[] = {"Bokaro", "Chatra", "Deoghar", "Dhanbad", "Dumka", "East Singhbhum", "Garhwa", "Giridih", "Godda", "Gumla","Hazaribag", "Jamtara", "Khunti", "Koderma", "Latehar", "Lohardaga", "Pakur", "Palamu", "Ramgarh", "Ranchi", "Sahibganj", "Seraikela Kharsawan", "Simdega", "West Singhbhum"};
        String karnataka[] = {"Bagalkot", "Bangalore Rural", "Bangalore Urban", "Belgaum", "Bellary", "Bidar", "Bijapur", "Chamarajnagar", "Chikkamagaluru", "Chikkaballapur", "Chitradurga", "Davanagere", "Dharwad", "Dakshina Kannada", "Gadag", "Gulbarga", "Kodagu", "Kolar", "Koppal", "Mandya", "Mysore", "Raichur", "Shimoga", "Tumkur", "Udupi", "Uttara Kannada", "Ramanagara", "Yadgir"};
        String Kerala[]= {"Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod", "Kollam", "Kottayam", "Kozhikode", "Malappuram", "Palakkad", "Pathanamthitta", "Thrissur", "Thiruvananthapuram", "Wayanad"};
        String MadhyaPradesh[] = {"Alirajpur", "Anuppur", "Ashok Nagar", "Balaghat", "Barwani", "Betul", "Bhind", "Bhopal", "Burhanpur", "Chhatarpur", "Chhindwara", "Damoh", "Datia", "Dewas", "Dhar", "Dindori", "Guna", "Gwalior", "Harda", "Hoshangabad", "Indore", "Jabalpur", "Jhabua", "Katni", "Khandwa (East Nimar)", "Khargone (West Nimar)", "Mandla", "Mandsaur", "Morena", "Narsinghpur", "Neemuch", "Panna", "Rewa", "Rajgarh", "Ratlam", "Raisen", "Sagar", "Satna", "Sehore", "Seoni", "Shahdol", "Shajapur", "Sheopur", "Shivpuri", "Sidhi", "Singrauli", "Tikamgarh", "Ujjain", "Umaria", "Vidisha"};


        AtomicInteger i = new AtomicInteger();


        comboBox.setOnAction((event) -> {
//            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
//            Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
//            String PreviousState = null;
//            if ((String) comboBox.getValue() != PreviousState){
//                root2.getChildren().removeAll(te)
//            }
//            PreviousState = (String) comboBox.getValue();


            if (i.get() ==1){
                comboBox1.getItems().clear();
            }
            i.set(1);


//            root2.getChildren().addAll(t,text20,text17,text18,text19);
//            back.setOnAction((event2) -> {
//                root2.getChildren().removeAll(t,text17,text18,text19,text20);
//
//                primaryStage.setScene(scene);
//
//            });

            if ((String) comboBox.getValue() == "Himachal Pradesh") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(HimachalPradesh));
            }if ((String) comboBox.getValue() == "Jammu and kashmir") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(JK));
            }
            if ((String) comboBox.getValue() == "Jharkhand") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(Jharkhand));
            }
            if ((String) comboBox.getValue() == "Madhya Pradesh") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(MadhyaPradesh));
            }
            if ((String) comboBox.getValue() == "Karnataka") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(karnataka));
            }
            if ((String) comboBox.getValue() == "Kerala") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(Kerala));
            }
            if ((String) comboBox.getValue() == "Delhi") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(Delhi));
            }
            if ((String) comboBox.getValue() == "Daman and Diu") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(DamanDui));
            }
            if ((String) comboBox.getValue() == "Assam") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(Assam));
            }
            if ((String) comboBox.getValue() == "Chattisgarh") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(Chattisgarh));
            }
            if ((String) comboBox.getValue() == "Gujarat") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(Gujrat));
            }
            if ((String) comboBox.getValue() == "Arunachal Pradesh") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(ArunachalPradesh));
            }
            if ((String) comboBox.getValue() == "Andhra Pradesh") {
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll(FXCollections.observableArrayList(AndhraPradesh));
            }





            if ((String) comboBox.getValue() == "Haryana"){
//                comboBox1.getItems().clear();
                comboBox1.getItems().addAll("Ambala", "Bhiwani", "Charkhi Dadri", "Faridabad", "Fatehabad", "Gurugram (Gurgaon)", "Hisar", "Jhajjar", "Jind", "Kaithal", "Karnal", "Kurukshetra", "Mahendragarh", "Nuh", "Palwal", "Panchkula", "Panipat", "Rewari", "Rohtak","Sirsa", "Sonipat", "Yamunanagar");
            }
            else if ((String) comboBox.getValue() == "Goa"){
                comboBox1.getItems().addAll(FXCollections.observableArrayList(goa));
            }

            System.out.println("   ComboBox.getValue(): " + comboBox.getValue());
        });




        comboBox1.setOnAction((event) -> {
            int selectedIndex = comboBox1.getSelectionModel().getSelectedIndex();
            Object selectedItem = comboBox1.getSelectionModel().getSelectedItem();
            Text t = new Text(250,180, (String) comboBox.getValue());
            Text text17 = new Text(100,200, stateData.confirmed((String) comboBox.getValue()));
            Text text18= new Text(100,230,stateData.recover((String) comboBox.getValue()));
            Text text19 = new Text(100,260, stateData.Death((String) comboBox.getValue()));
            Text text20 = new Text(100,300, stateData.Active((String) comboBox.getValue()));
            Text text4 = new Text(40, 140, city.Active((String) comboBox1.getValue()));
            Text text12 = new Text(160,140, city.confirmed((String) comboBox1.getValue()));
            Text text13= new Text(280,140, city.recover((String) comboBox1.getValue()));
            text4.setFont(Font.font(family, size));
            text4.setFill(Color.RED);
            text12.setFont(Font.font(family, size));
            text12.setFill(Color.RED);
            text13.setFont(Font.font(family, size));
            text13.setFill(Color.RED);
            back.setOnAction((event2) -> {
                root2.getChildren().removeAll(text4,text12,text13,t,text17,text18,text19,text20);

                primaryStage.setScene(scene);

            });





            primaryStage.setScene(scene1);
            root2.getChildren().add(text4);
            root2.getChildren().add(text12);
            root2.getChildren().addAll(text13,t,text17,text18,text19,text20);
            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ComboBox1.getValue(): " + comboBox1.getValue());
        });


        root.getChildren().addAll(comboBox,comboBox1,text14,text15,text16);
     



        root2.getChildren().add(back);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
//        WorldData d = new WorldData();
//        d.getData("world");
//        city c = new city();
//        c.getData("Fatehabad");
//        state s = new state();
//        s.getData("Haryana");
        launch(args);

    }
}
