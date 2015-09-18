<%-- 
    Document   : index
    Created on : 14/09/2015, 23:58:13
    Author     : Igor
--%>

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
                <tr>
                    <c:forEach var="lista" items="${requestScope.SenhaChamadaList}"><td align="center">${lista.nomeChamado}</td> 
                </tr>
                </c:forEach>
             </table>
             <table align="center" style="font-family: sans-serif; font-size: xx-large; color: red;">
                <tr>
                    <td>Última Chamada:</td>
                    <td>${nomeUltimoChamado}</td>
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
