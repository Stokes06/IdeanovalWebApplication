$(function(){

    console.log("log dans firefox ??")
 var btn_ins = $('#btn_inscription');
 btn_ins.click(function(e)
 {
     e.preventDefault();
     var pseudo = $('#pseudo_ins').val();
     var email = $('#email_ins').val();
     var password = $('#password_ins').val();
     var password_confirm = $('#password_confirm').val();
     $.post("/inscription",{"pseudo": pseudo,"email":email,"password":password,"password_confirm":password_confirm},function(data)
     {
         console.log(data);
         // format des données  = [index(id input) : msg d'erreur :]
         var datas = data.split("||");
        console.log(datas);
         if(datas.length<2)
         {
             var user_id=datas[0];
             console.log(user_id);
             //aucune erreur
             $('#alert_inscription').html('<p class="alert alert-success">Inscription réussie</p>');
                $.post("#",{"user_id":user_id},function () {
                    console.log("rechargement page avec session avec id = ",user_id);
                     window.location.reload()
                })
         }else{
             $('#alert_inscription').html("");

             $('#form-inscription input').css({"border-color":"green"});
             for(var i=0; i<datas.length; i+=2)
             {
                 //Vider le champ erroné et lui donner une bordure rouge
                 var input = $('#'+datas[i]);
                 input.css({"border-color":"red"});
                 input.val("");
                 //afficher le msg d'erreur correspondant
                 $('#alert_inscription').append('<p class="alert alert-danger">'+datas[i+1]+'</p>');
             }

         }
     })

 })
})

var btn_co = $('#btn_connexion')
btn_co.click(function(event){
    console.log("clic sur connexion");
    event.preventDefault();
    var email = $('#email_co').val();
    var password = $('#password_co').val();
    $.post("/login",{"email":email , "password":password},function(data){
        console.log("reponse du serveur : ",data)
        if(data!=="")
        {

            var user_id = data;
            //connexion réussie

            $.post("header.jsp",{"user_id":user_id},function () {
                console.log("go vers page connectée")
                window.location.reload()

            })
        }else{
            $('#alert_connexion').html('<span class="alert alert-danger">L\'identification a écouchée. Veuillez reessayer.</span>')

        }
    })
})


var btn_logout = $('#btn_logout');
btn_logout.click(function(event){
    event.preventDefault();
    console.log("i go away")
    var deco = 'disconnected';
    $.post("header.jsp",{"deco":deco},function () {
        console.log("rechargement page pour deconnexion");
        window.location.reload()
    })

});