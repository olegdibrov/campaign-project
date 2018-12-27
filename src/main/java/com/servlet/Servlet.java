package com.servlet;

import com.controller.command.ICommand;
import com.controller.command.ListOfCommands;
import com.model.entity.Speciality;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(Servlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
//        LOGGER.debug("do Get");
//        LOGGER.debug("parameter: "+req.getParameter(SessionParameters.COMMAND));
//        String commandName = req.getParameter(SessionParameters.COMMAND);
//        if(commandName == null) return;
//        ICommand command = CommandList.valueOf(commandName).getCommand();
//        String redirect = command.execute(req, resp);
//        req.getRequestDispatcher(redirect).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String commandName = req.getParameter("command");
        System.out.println("command name = " + commandName);
        commandName = commandName.toUpperCase();
        if(commandName == null) return;
        ICommand command = ListOfCommands.valueOf(commandName).getCommand();
        String redirect = command.execute(req, resp);
        req.getRequestDispatcher(redirect).forward(req, resp);
    }


}
