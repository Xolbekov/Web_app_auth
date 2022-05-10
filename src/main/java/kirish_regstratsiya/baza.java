package kirish_regstratsiya;
import qiymat_olish.Natija;

import java.sql.*;

public class baza {
    String url = "jdbs://postgres:localhost:5432/apppp";
    String dbuser = "postgres";
    String dbpassword = "Asad0520#";

    public Natija malumot_joylash(users users) {
        try {

            Class.forName("org.postgres.Driver");

            Connection connection = DriverManager.getConnection(url, dbuser, dbpassword);
            Statement statement = connection.createStatement();
            String tel_nomer = "select count(tel_nomer) from register where tel_nomer="+users.getTel_nomer();
            ResultSet resultSet=statement.executeQuery(tel_nomer);
            int cout;
            while(resultSet.next()){
                cout=resultSet.getInt(1);
                if(cout>0){
                    return new Natija("Bunday telefon raqam mavjud",false);
                }
            }
            ///////////////
            String login = "select count(login) from register where login="+users.getLogin();
            ResultSet resultSet1=statement.executeQuery(login);
            while(resultSet1.next()){
                cout=resultSet.getInt(1);
                if(cout>0){
                    return new Natija("Bunday login raqam mavjud",false);
                }
            }

            String query="insert into register(ism,familiya,tel_nomer,login,parol) values(?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,users.getIsm());
            preparedStatement.setString(2,users.getFamiliya());
            preparedStatement.setString(3,users.getTel_nomer());
            preparedStatement.setString(4,users.getLogin());
            preparedStatement.setString(5,users.getParol());

            preparedStatement.executeUpdate();
            return new Natija("Muvaffaqiyatli ro'yxatdan o'tdingiz!",true);

        } catch (SQLException e) {
            e.printStackTrace();
            return  new Natija("Server ishlamayapti",false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  new Natija("Server ishlamayapti",false);
        }
    }
}



