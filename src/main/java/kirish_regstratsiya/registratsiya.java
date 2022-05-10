package kirish_regstratsiya;

import qiymat_olish.Natija;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class registratsiya extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.sendRedirect("registratsiya.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname=req.getParameter("ism");
        String lastname=req.getParameter("familiya");
        String number=req.getParameter("nomer");
        String login=req.getParameter("login");
        String password=req.getParameter("parol");
        String password2=req.getParameter("parol2");
        System.out.println(firstname+"\n"+lastname+"\n"+number+"\n"+login+"\n"+password+"\n"+password2);

        PrintWriter printWriter=resp.getWriter();

        if (password.equals(password2)){

            baza data_base=new baza();
            users data_users=new users(firstname,lastname,number,login,password);
            Natija data_natija=data_base.malumot_joylash(data_users);

            if (data_natija.isHolat()){
                printWriter.write("<h1>"+data_natija.getXabar()+"</h1>");
            }
            else {
                printWriter.write("<h1>"+data_natija.getXabar()+"</h1>");
            }

        }
        else {
            printWriter.write("<h1>Parollar bir biriga mos emas!</h1>");
        }
    }
}
