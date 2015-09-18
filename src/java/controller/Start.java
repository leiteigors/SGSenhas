/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOSenhaChamada;
import dao.SenhaChamadaDAOImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.SenhaChamada;
import util.Conexao;

/**
 *
 * @author Igor
 */
public class Start extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        DAOSenhaChamada dao;
        try  {
            /* TODO output your page here. You may use following sample code. */
            
            dao = new SenhaChamadaDAOImp();
            //RequestDispatcher rd = null;
            
            List SenhaChamadaList = dao.retornaUltimos();
            String nomeUltimoChamado = dao.retornaUltimoChamado();
            request.getSession().setAttribute("SenhaChamadaList", SenhaChamadaList);
            request.getSession().setAttribute("nomeUltimoChamado", nomeUltimoChamado);
            //rd = request.getRequestDispatcher("/index.jsp");
            //rd.forward(request, response);
            request.getRequestDispatcher("/start.jsp").forward(request, response);
        } catch (Exception e)
        {
            e.getCause();
        }
    }

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

}
