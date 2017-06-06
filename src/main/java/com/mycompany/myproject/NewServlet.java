/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myproject;

/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.*;
import com.data.TextData;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;


/**
 * The simplest possible servlet.
 *
 * @author James Duncan Davidson
 */

public class NewServlet extends HttpServlet {

    private  TextDataDao dao = null;
    @Override
     public void init(ServletConfig config) throws ServletException {
     super.init(config);    
      ApplicationContext app =new ClassPathXmlApplicationContext("config/context.xml");
      dao = (TextDataDao) app.getBean("TextDataDao");

     }
   
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        
        String id = request.getParameter("id");
        String title ="test";
        String body = "";
        body = dao.GetData(Integer.parseInt(id));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(body);
        /*
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");

       
        

        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");

    
        out.println("<h1>" + body + "</h1>");
        out.println("</body>");
        out.println("</html>");
        */
    }
    
    @Override
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        
        int id = Integer.parseInt( request.getParameter("id"));
        String text  = request.getParameter("text");
        TextData data = new TextData();
        data.setId(id);
        data.setName(text);
        String title ="test";
        String body = "";
        if (dao.Update(data))
        {
            body ="success updated row with the text "+ data.getName();
        }
        else
        {
            body = "new row created with the text " +data.getName();
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(body);
        
    }
}