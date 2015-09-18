<%-- 
    Document   : index
    Created on : 14/09/2015, 23:58:13
    Author     : Igor
--%>
<%@page import="modelo.SenhaChamada"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script lang="javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplicacao Gerenciamento de Senhas</title>
    </head>
    <body>
        <div>    
            <table align="center" style="font-family: sans-serif; font-size: medium; color: blue;">
                <tr>
                    <td><b>Últimas senhas chamadas pela gerencia</td>
                </tr>
                <tr align="center">
                    <td>
                    <%
                         ArrayList<SenhaChamada> list = (ArrayList<SenhaChamada>) request.getAttribute("SenhaChamadaList");
                         //(ArrayList<SenhaChamada>) request.getAttribute("SenhaChamadaList");
                         if(list == null) {
                            out.print("Não existem!");
                         } else if (list != null) {
                         for(modelo.SenhaChamada mySenhaChamada : list)
                            if (!mySenhaChamada.getNomeChamado().isEmpty() && (mySenhaChamada.getNomeChamado() != null))
                                out.print(mySenhaChamada.getNomeChamado());
                            out.print("Não existem!");
                         }
                    %>  
                    </td>  
                </tr>
             </table>
             <table align="center" style="font-family: sans-serif; font-size: xx-large; color: red;">
                <tr>
                    <td>Última Chamada:</td>
                    <td>
                        <% 
                            String ultimoChamado = new String();
                            ultimoChamado = (String) request.getAttribute("nomeUltimoChamado");
                            if ((ultimoChamado != null) && !ultimoChamado.isEmpty()){
                                out.print(ultimoChamado);
                            } else {out.print("Não existe senhas chamadas até o momento!");}
                        %>
                    </td>
                </tr>       
             </table>    
            <form action="IncluirSenha" method="post">
                <input type="checkbox" name="Preferencial" id="Preferencial">É Preferencial?  
                <input type="submit" name="gerar" value="Gerar nova senha">
            </form>
            
            
            
            <form action="ChamarSenha" method="post">
                <input type="submit" name="chamar" value="Chamar nova senha">
            </form>
            
            <form action="ResetarSenhas" method="post">
                <input type="submit" name="chamar" value="Resetar Senhas">
            </form>
                
        </div>
    </body>
</html>
