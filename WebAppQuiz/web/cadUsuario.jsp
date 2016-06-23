<%-- 
    Document   : cadUsuario
    Created on : 21/06/2016, 13:24:36
    Author     : david_000
--%>

<%@page import="br.com.fatecpg.quiz.Usuario"%>
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
                String Login = request.getParameter("login").toString();
                String nome = request.getParameter("nome").toString();
                long hash = Long.parseLong(request.getParameter("senha").toString());
                String adm = request.getParameter("administrador").toString();
                boolean administrador = (adm.equals("on"))?true:false;
                boolean teste = bd.cadUsuario(new Usuario(Login, nome, hash, administrador));
                if(teste){%><h1>Salvo Com Sucesso</h1><%;}
                else{ %><h1>erro</h1><%;}
            }
        %>
        <h1>CADASTRO USUARIO</h1>
        <form method="GET">
            login:
            <input type="text" name="login" value="" required><br/>
            nome:
            <input type="text" name="nome" value="" required><br/>
            senha:
            <input type="password" name="senha" value="" required><br/>
            administrador:
            <input type="checkbox" name="administrador" ><br/>
            <input type="submit" name="btnCadastrar" value="Cadastrar">
        </form>        
    </body>
</html>
