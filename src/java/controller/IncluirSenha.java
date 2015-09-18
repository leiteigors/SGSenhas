/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.SenhaGerada;
import dao.*;

/**
 *
 * @author Igor
 */
public class IncluirSenha extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DAOSenhaGerada dao;
            dao = new SenhaGeradaDAOImp();
            SenhaGerada mySenhaGerada = new SenhaGerada();
            Integer maiorId = dao.retornaMaiorId();
            String checked = request.getParameter("Preferencial");
            if (checked != null) {
                if (checked.equalsIgnoreCase("on")) {
                    if (dao.retornaMaiorPreferencial() != 0) {
                        Integer maiorPreferencial = dao.retornaMaiorPreferencial();
                        maiorPreferencial++;
                        String maiorPreferencialP = "P".concat(("0000" + maiorPreferencial.toString()).substring(maiorPreferencial.toString().length()));
                        mySenhaGerada.setId(maiorId);
                        mySenhaGerada.setNomeSenha(maiorPreferencialP);
                        mySenhaGerada.setChamouSenha(0);
                    } else {
                        String maiorPreferencialP = "P".concat(("0000" + "1".toString()).substring("1".toString().length()));
                        mySenhaGerada.setId(maiorId);
                        mySenhaGerada.setNomeSenha(maiorPreferencialP);
                        mySenhaGerada.setChamouSenha(0);
                    }
                }
            } else if (checked == null){
                if (dao.retornaMaiorNormal() != 0) {
                        Integer maiorNormal = dao.retornaMaiorNormal();
                        maiorNormal++;
                        String maiorNormalN = "N".concat(("0000" + maiorNormal.toString()).substring(maiorNormal.toString().length()));
                        mySenhaGerada.setId(maiorId);
                        mySenhaGerada.setNomeSenha(maiorNormalN);
                        mySenhaGerada.setChamouSenha(0);
                    } else {
                        String maiorNormalN = "N".concat(("0000" + "1".toString()).substring("1".toString().length()));
                        mySenhaGerada.setId(maiorId);
                        mySenhaGerada.setNomeSenha(maiorNormalN);
                        mySenhaGerada.setChamouSenha(0);
                    }
            }
            dao.salvar(mySenhaGerada);
            response.sendRedirect("Start");
//request.getRequestDispatcher("/start.jsp").forward(request, response);

        } catch (Exception e) {
            e.getMessage();
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
