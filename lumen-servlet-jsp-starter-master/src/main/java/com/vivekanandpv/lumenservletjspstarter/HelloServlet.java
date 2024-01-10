package com.vivekanandpv.lumenservletjspstarter;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.Part;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@MultipartConfig
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//public class HelloServlet extends HttpServlet {
//    private String message;
//    //private List<String> colors = List.of("blue", "red", "green", "white");
//    private List<String> quotes = new ArrayList<>();
//
//    public void init() {
//        message = "Hello World!";
//        System.out.println("init of servlet");
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//         String quote = request.getParameter("Quotes");
////        String username = request.getParameter("username");
////        String password = request.getParameter("password");
//        PrintWriter out = response.getWriter();
//        quotes.add(out.toString());
//        out.println("<html><body>");
////        out.println("<h1>" + username + " - " + password + "</h1>");
//        out.println(out);
//        out.println("</body></html>");
//    }
//
//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//
//        Part part = request.getPart("username");
//
//        InputStream inputStream = part.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//
//
//
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println(String.format("<h1>POST successful: Username: %s</h1>", sb.toString()));
//        out.println("<hr />");
//        out.println("</body></html>");
//    }
//
//    public void destroy() {
//        System.out.println("destroy of servlet");
//    }
//}

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/QuoteServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> quotes = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Quote Form</title></head><body>");
        out.println("<h1>Enter a Quote:</h1>");
        out.println("<form method='post'>");
        out.println("Quote: <input type='text' name='quote'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");

        out.println("<h2>Stored Quotes:</h2>");
        out.println("<ul>");
        for (String quote : quotes) {
            out.println("<li>" + quote + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quote = request.getParameter("quote");
        if (quote != null && !quote.isEmpty()) {
            quotes.add(quote);
        }
        response.sendRedirect("QuoteServlet");
    }
}