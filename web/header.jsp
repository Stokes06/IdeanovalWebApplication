<%@ page import="tools.Functions" %><%--
  Created by IntelliJ IDEA.
  User: HB1
  Date: 26/10/2017
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try{
    int user_id = Integer.parseInt(request.getParameter("user_id"));
    session.setAttribute("user_id",user_id);
    out.print(Functions.debug(session));
    System.out.println(session.getAttribute("user_id"));
}catch(Exception e){}
%>
<div id="header">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Ideanoval</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav navbar-right">
                    <li><a data-toggle="modal" data-target="#signup" href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a data-toggle="modal" data-target="#login" href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>
<!-- Modal inscription -->
<div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Inscrivez vous en quelques secondes</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <form action="#" method="post" id="form-inscription">
                            <div class="form-group">
                                <label for="pseudo_ins">Choisissez un pseudo:</label>
                                <input type="text" id="pseudo_ins" name="pseudo"class="form-control" placeholder="pseudo">
                            </div>
                            <div class="form-group">
                                <label for="email_ins">Votre email:</label>
                                <input type="email" id="email_ins" name="email"class="form-control" placeholder="email">
                            </div>
                            <div class="form-group">
                                <label for="password_ins">Choisissez un mot de passe</label>
                                <input type="password" id="password_ins" name="password"class="form-control" placeholder="mot de passe">
                            </div>
                            <div class="form-group">
                                <label for="password_confirm">Confirmez votre mot de passe</label>
                                <input type="password" id="password_confirm" name="password"class="form-control" placeholder="confirmer le mot de passe">
                            </div>
                                <button type="submit" id="btn_inscription" class="btn btn-lg btn-primary">S'inscrire</button>

                        </form>
                    </div>
                </div>
                <div class="row">
                    <div id="alert_inscription" class="col-md-12">

                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-lg btn-danger" data-dismiss="modal">Annuler</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Connexion -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal-title">Connectez-vous</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <form action="#" method="post" id="form-connexion">
                            <div class="form-group">
                                <label for="email_co">Votre email:</label>
                                <input type="email" id="email_co" name="email"class="form-control" placeholder="email">
                            </div>
                            <div class="form-group">
                                <label for="password_co">Votre mot de passe:</label>
                                <input type="password" id="password_co" name="password"class="form-control" placeholder="mot de passe">
                            </div>
                            <button type="submit" id="btn_connexion" class="btn btn-lg btn-primary">Se connecter</button>

                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-lg btn-danger" data-dismiss="modal">Annuler</button>
            </div>
        </div>
    </div>
</div>
