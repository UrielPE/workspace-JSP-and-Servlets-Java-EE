/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.ServletContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import models.CatalogoDb;

/**
 * Web application lifecycle listener.
 *
 * @author Andrés Guzmán F
 */
public class CatalogoEventListener implements ServletContextListener {

    ServletContext servletContext;

    public void contextInitialized(ServletContextEvent sce) {

        servletContext = sce.getServletContext();
        servletContext.setAttribute("catalogoDb", new CatalogoDb());

    }

    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.removeAttribute("catalogoDb");
    }

}
