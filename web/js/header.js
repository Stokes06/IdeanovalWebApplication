$(function(){

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
             //aucune erreur
             $('#alert_inscription').html('<p class="alert alert-success">Inscription réussie</p>');
                $.post("#",{"user_id":user_id},function () {
                    console.log("rechargement page avec session avec id = ",user_id);
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