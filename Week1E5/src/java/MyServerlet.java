/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Assignment required: Week 1 E5, a web game guess number with session
 * @author Zeting Luo Student ID:16938158
 */
public class MyServerlet extends HttpServlet {

     private final char QUOTE = '"'; 
     private int theAnswer;
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     
     @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
        HttpSession session = request.getSession(true);
        String welcome;
        String hit;
        Integer counter = (Integer)session.getAttribute("tries");
        Integer savedAnswer = (Integer)session.getAttribute("theAnswer");
        
        boolean firstTime = (counter==null||savedAnswer==null);
       
        //Set up the session
        //post: counter = 0
        //post: Random Answer setup
        //post: hit 0 to top
        if (firstTime){
            counter = 0;
            welcome = "Here is your first time guest number, counter Set up to 0";
            int randomTop = Integer.parseInt(request.getParameter("maxNumber"));
            this.theAnswer = new Random().nextInt(randomTop+1);
            session.setAttribute("theAnswer", theAnswer);
            hit = "guest number from 0 to "+randomTop; 
        }
        //found set up session
        //do: check answer
        else{
            counter++;
            welcome = "Answer not right, go try again, this is your "+counter+" times";
            int userInput = Integer.parseInt(request.getParameter("userInput"));
            this.theAnswer=savedAnswer;
            hit = this.compareInput(userInput, this.theAnswer); 
        }
        
        session.setAttribute("tries", counter);        
        boolean isUserRight = hit.equals("Correct guess!");// see if user get it right
        
//prepare response
        response.setContentType("text/html");
        String thisURL = "RequestCounter";
        String res =
                "<!DOCTYPE HTML PUBLIC -//W3C//DTD HTML 4.0 Transitional//EN>\n"+
                    "<HTML>\n" +
                    "<HEAD>\n" +
                    "<TITLE>GuessGameCounter</TITLE>\n"+
                    "</HEAD>\n" +
                    "<BODY>\n" ;
//set up web page
        //get body by checking 
        String rightBody = 
                    "<H1>GuessGameCounter Response</H1>\n" +
                    "Wll done, you get the answer right<br>"+
                    "you used "+counter+" times to get it right";
                    
        String wrongBody = 
                    "<H1>GuessGameCounter Response</H1>\n" +
                    "<P>" + welcome + "</P>\n"+
                    "<B><P>"+hit+"</P></B>"+
//uncomment next line for debug
                    //this.theAnswer+
                    "<form action=\'http://localhost:8080/Week1E5/SessionTest\'>"+
                    "<input type='number' min='0' name='userInput' required></input>"+ 
                    "<button name='' type='submit'>Guess</button></form>";
        res += isUserRight?
                rightBody:wrongBody;
        res+="</BODY>\n</HTML>\n";
// web page set up finish display it
        try (PrintWriter pw = response.getWriter()) {
                pw.println(res);
                if(hit.equals("Correct guess!"))
                    session.invalidate();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public String compareInput(int clientGuess, int answer){
       String result = "init";
        if (clientGuess < answer)
           result = "Guess too low, try again";
        else if (clientGuess > answer)
           result = "Guess too high, try again";
        else
           result = "Correct guess!";
       return result;
   }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException
   {  doGet(request, response);
   }
   
}
