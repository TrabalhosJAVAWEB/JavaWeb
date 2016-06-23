<%-- 
    Document   : cadQuestao
    Created on : 23/06/2016, 00:48:22
    Author     : david_000
--%>

<%@page import="br.com.fatecpg.quiz.Questao"%>
<%@page import="br.com.fatecpg.quiz.FuncoesBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getParameter("btnCadastrar")!=null){
                FuncoesBD bd = new FuncoesBD();
                String pergunta = request.getParameter("pergunta").toString();
                String resposta = request.getParameter("resposta").toString();
                String alt1 = request.getParameter("alt1").toString();
                String alt2 = request.getParameter("alt2").toString();
                String alt3 = request.getParameter("alt3").toString();
                String alt4 = request.getParameter("alt4").toString();
                boolean teste = bd.cadQuestao(new Questao(pergunta, resposta, alt1, alt2, alt3, alt4));
                if(teste){%><h1>Salvo Com Sucesso</h1><%;}
                else{ %><h1>erro</h1><%;}
            }
        %>
       <h1>CADASTRO Questão</h1>
        <form method="GET">
            Pergunta:
            <input type="text" name="pergunta" value="" required><br/>
            Resposta:
            <input type="text" name="resposta" value="" required><br/>
            Alternativa 1:
            <input type="text" name="alt1" value="" required><br/>
            Alternativa 2:
            <input type="text" name="alt2" value="" required><br/>
            Alternativa 3:
            <input type="text" name="alt3" value="" required><br/>
            Alternativa 4:
            <input type="text" name="alt4" value="" required><br/>
            <input type="submit" name="btnCadastrar" value="Cadastrar">
        </form>        
    </body>
</html>
