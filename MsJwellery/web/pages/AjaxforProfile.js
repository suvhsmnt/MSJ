/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 function edit(type,phase,loss,worker) {

      $('#editworktype').prop('disabled', 'disabled');
        $('#editworkingtype').prop('disabled', 'disabled');
     $("#editworktype").children('option').remove();
      $("#editworktype").append('<option value=' + type +'>' + type+ '</option>');
     $("#editworktype").selectpicker("refresh");
    
     $("#editworkingtype").children('option').remove();
     $("#editworkingtype").append('<option value=' + phase + '>' + phase + '</option>');
     $("#editworkingtype").selectpicker("refresh");
    
     $("#edit_l_percentage").val(loss);
     }

$(document).ready(function () {
    document.getElementById("overlayfortable").style.display = "block";   
    ajaxGetLossTable();

$('#btnAdd').click(function () {

        $('#l_percentage').val('');

        ajaxWorkTypes();
        ajaxWorkingTypes();
    });
   
$('#btnCancel').on('click', function () {
        dialog.close();
    });
$('#refresh').on('click', function () {
    document.getElementById("overlayfortable").style.display = "block";   
    ajaxGetLossTable();
       
    });
$("#Password").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        document.getElementById("overlay2").style.display = "block";
        alert("hh");
        ajaxUdatePass();
    });

$("#AddLoss").submit(function (event) {
        event.preventDefault();
      document.getElementById("overlayforaddloss").style.display = "block";
        ajaxAddLoss();

    });
$("#editLoss").submit(function (event) {
        event.preventDefault();
       document.getElementById("overlayforeditloss").style.display = "block";
        ajaxeditLoss();

    });
$("#updatedetails").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        alert("hhhhhh");
        document.getElementById("overlay1").style.display = "block";
        ajaxUserDetails();
    });
$("#GoldCredit").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();

        document.getElementById("overlayForGold").style.display = "block";
        ajaxGoldCredit();
    });
function ajaxeditLoss(){
    	
    	// PREPARE FORM DATA
    	var data = {
                "Password" :  $('#PassForeditLoss').val(),
                "WorkType" :$('#editworktype').val(),
                "Loss" :$('#edit_l_percentage').val(),
                "Working" : $('#editworkingtype').val(),
                "Worker_id" : $('#worker_id_foredit').val()
                
    	};
    	
    	$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			url : 'editloss.htm',
			data : JSON.stringify(data),			  
			dataType : "JSON",    
			success : function(result) {
                        document.getElementById("overlayforeditloss").style.display = "none";		
                        if(result.status == "success"){
					$("#msgforeditloss").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>");
				}else{
					$("#msgforeditloss").html("<strong style='background-color:#7FA7B0; padding:10px 10px 5px 5px'>Error</strong>");
				}
                                ajaxGetLossTable();
				console.log(result);
			},
			error : function(e) {
				alert("Error!!!");
				console.log("ERROR: ", e);
			}
		});
    	
    	
 
    }
function ajaxGetLossTable() {
        var data = {
            "WorkerId": $('#worker_id').val()

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'getLossTable.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlayfortable").style.display = "none";
                
               $("#Loss_table").children('tbody').children('tr').remove();
                if (result) {
                   
                  for (var i = 0; i < result.length; i++) {
//                        $("#m_worker").text(+result[i].assigned_By);
                      
                       $("#Loss_table").children('tbody').append('<tr class="gradeX"><td>'+result[i].workerType+'</td><td>'+result[i].working+'</td><td>'+result[i].loss_Percentage+'</td><td>'+result[i].date_of_Assign+'</td><td>'+result[i].assigned_By+'</td><td class="actions"><button id="edit" onclick="edit(\''+result[i].workerType+'\',\''+result[i].working+'\',\''+result[i].loss_Percentage+'\',\''+result[i].worker+'\')" data-toggle="modal" data-target="#editLoss" value="abc" ><i class="fa fa-pencil"></i></button> <button id="btnAdd"  data-toggle="modal" data-target="#custom-width-modal" value="abc" ><i class="fa fa-trash-o"></i></button></td>');
                 }
           
                } else {
                    $("#msg").html("<strong>Error Loading</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!!!");
                console.log("ERROR: ", e);
            }
        });
    }
function ajaxAddLoss(){
    	
    	// PREPARE FORM DATA
    	var data = {
                "Password" :  $('#PassForAddLoss').val(),
                "WorkType" :$('#worktype').val(),
                "Loss" :$('#l_percentage').val(),
                "Working" : $('#workingtype').val(),
                "Worker_id" : $('#worker_id').val()
                
    	};
    	
    	$.ajax({
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			url : 'addloss.htm',
			data : JSON.stringify(data),			  
			dataType : "JSON",    
			success : function(result) {
                        document.getElementById("overlayforaddloss").style.display = "none";		
                        if(result.status == "success"){
					$("#msgforaddloss").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>");
				}else{
					$("#msgforaddloss").html("<strong style='background-color:#7FA7B0; padding:10px 10px 5px 5px'>Error</strong>");
				}
                                ajaxGetLossTable();
				console.log(result);
			},
			error : function(e) {
				alert("Error!!!");
				console.log("ERROR: ", e);
			}
		});
    	
    	
 
    }
function ajaxWorkingTypes() {
        var Type = {
            "Type": "WORKER_TYPE"

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'getallworktypes.htm',
            data: JSON.stringify(Type),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay2nd").style.display = "none";

                $("#workingtype").children('option').remove();
                if (result) {

                    for (var i = 0; i < result.length; i++) {
                        $("#workingtype").append('<option value=' + result[i].name + '>' + result[i].name + '</option>');
                    }
                    ;
                    $("#workingtype").selectpicker("refresh");

                } else {
                    $("#msg").html("<strong>Error Loading</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!!!");
                console.log("ERROR: ", e);
            }
        });
    }
function ajaxWorkTypes() {
        var Type = {
            "Type": "WORK_TYPE"
        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'getallworktypes.htm',
            data: JSON.stringify(Type),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay2nd").style.display = "none";

                $("#worktype").children('option').remove();
                if (result) {

                    for (var i = 0; i < result.length; i++) {
                        $("#worktype").append('<option value=' + result[i].name + '>' + result[i].name + '</option>');
                    }
                    ;
                    $("#worktype").selectpicker("refresh");

                } else {
                    $("#msg").html("<strong>Error Loading</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!!!");
                console.log("ERROR: ", e);
            }
        });
    }
function ajaxUdatePass() {

        // PREPARE FORM DATA
        var data = {
            "Oldpass": $('#password').val(),
            "Password": $('#pass2').val(),
            "confirmpassword": $('#cnfpass').val(),
            "Adhar": $('#adhar').val()

        };

        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'updatepass.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay2").style.display = "none";
                if (result.status == "Done") {
                    $("#msg").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                            "Post Successfully! <br>");
                } else {
                    $("#msg").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!!!");
                console.log("ERROR: ", e);
            }
        });



    }
function ajaxUserDetails() {

        // PREPARE FORM DATA
        var data = {
            "Pass": $('#PasswordForUpdate').val(),
            "Name": $('#NameUpdate').val(),
            "Phone": $('#PhoneUpdate').val(),
            "Email": $('#EmailUpdate').val(),
            "id": $('#WorkerId').val()

        };

        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'UpdateUser.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay1").style.display = "none";
                if (result.msg == "Success") {
                    $("#msgd").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                            "Post Successfully! <br>");
                } else {
                    $("#msgd").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!!!");
                console.log("ERROR: ", e);
            }
        });

    }
function ajaxGoldCredit() {

        // PREPARE FORM DATA
        var data = {
            "Gold": $('#Gold').val(),
            "Adhar": $('#adharForCredit').val(),
            "Pass": $('#PassForCreditGold').val()

        };

        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'GoldCredit.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay1").style.display = "none";
                if (result.msg == "Success") {
                    $("#msgd").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                            "Post Successfully! <br>");
                } else {
                    $("#msgd").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!!!");
                console.log("ERROR: ", e);
            }
        });

    }
});