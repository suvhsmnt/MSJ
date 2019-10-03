/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var global;
var worker;
var isJpg = function (name) {
    return name.match(/jpg$/i)
};
var isPng = function (name) {
    return name.match(/png$/i)
};
$(document).ready(function () {
$('#btnUpload').on('click', function () {
        var file = $('[name="idLogoFile"]');
        var form = new FormData(document.getElementById('fileForm'));
        var filename = $.trim(file.val());

//        if (!(isJpg(filename) || isPng(filename))) {
//            alert('Please browse a JPG/PNG file to upload ...');
//            return;
//        }
//        
        $.ajax({
            url: "imagetest.htm",
            data: form,
            dataType: 'text',
            processData: false,
            contentType: false,
            enctype: 'multipart/form-data',
            type: 'POST',
            success: function (response) {
                var data = jQuery.parseJSON(response);
//                $('#idImagePlaceHolder').html('');
//                var img='<img src="data:' +data.contenttype + ';base64,'+data.base64 +'"/>';
                $('#idImagePlaceHolder').html('<img src="data:image/png;base64,' + data.image + '"/>');
//                $('#idImagePlaceHolder').append(img);
            },
            error: function (jqXHR) {
                //Error handling
                alert(jqXHR);
            }
        });
    });
$('#btnClear').on('click', function () {
        imgContainer.html('');
        file.val('');
    });
$("button").click(function () {
        if (this.id == "test")
        {
            $("#ans").text(this.value);
            global = this.value;
            $("#pid").attr('value', this.value);
            $("#pid_r").attr('value', this.value);
            $("#msg").hide();
            $("#MAKING_ASSIGN").hide();
             $("#img_product").hide();
             $("#MAKING_RECEIVE").hide();
            ajaxGETDETAILS();
        }
    });
$("#MAKING").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        document.getElementById("overlay1").style.display = "block";
        ajaxAssignMaking();
    });
$("#MAKINGRECEIVE").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        document.getElementById("overlay1").style.display = "block";
        ajaxReceiveMaking();
    });
function ajaxGetAllMaker() {
        var Type = {
            "Type": worker

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'getallworker.htm',
            data: JSON.stringify(Type),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay1").style.display = "none";
                $("#msg").show();
                $("#sel").children('option').remove();
                if (result) {
                   
                    for (var i = 0; i < result.length; i++) {
                        $("#sel").append('<option value=' + result[i].workerid + '>' + result[i].workerid + '::' + result[i].name + '</option>');
                    }
                    ;
                    $("#sel").selectpicker("refresh");

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
function ajaxAssignMaking() {
        var data = {
            "pid": global,
            "Maker": $('#sel').val(),
            "Loss_Percentage": $('#l_percentage').val(),
        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'assingmaking.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay1").style.display = "none";
                $("#msg").show();
                if (result.status == "success") {
                    ajaxGETDETAILS();
                    $("#msg").html("<strong>success</strong>");
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
function ajaxGETDETAILS() {
        // PREPARE FORM DATA
        var data = {
            "pid": global

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'getdetails.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay1").style.display = "none";
                $("#msg").show();
                if (result.status == "success") {
//                    $("#ans").text(result.prodId);
                    $("#status").text(result.product_Status);
                    if (result.product_Status == "Wait") {
                         worker = "MK";
                         $("#MAKING_RECEIVE").hide();
                         ajaxGetAllMaker();
                         $("#tbody").children('tr').remove();
                        $("#MAKING_ASSIGN").show();
                    } else if (result.product_Status == "AMAKING")
                    {
                        
                        $("#MAKING_ASSIGN").hide();
                         $("#MAKING_RECEIVE").show();
                         ajaxGetTableData();
                        worker = "CH";
//                        ajaxGetAllMaker();
                    }else if(result.product_Status == "RMAKING")
                    {
                         $("#MAKING_ASSIGN").hide();
                         $("#MAKING_RECEIVE").hide();
                         ajaxGetTableData();
                        
                    }
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
function ajaxGetTableData() {
        var data = {
            "Pid": global

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'gettableData.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay1").style.display = "none";
                
               $("#tbody").children('tr').remove();
                if (result) {
                   
//                    for (var i = 0; i < result.length; i++) {
//                        $("#m_worker").text(+result[i].assigned_By);
                      
                        $('#tbody').append('<tr><td>'+result.table+'</td><td>'+result.worker+'</td><td>'+result.assigned_By+'</td><td>'+result.loss_Percentage+'</td><td>'+result.given_GOLD+'</td><td>'+result.return_GOLD+'</td><td>'+result.given_Stone+'</td><td>'+result.return_Stone+'</td><td>'+result.date_of_Assign+'</td></tr>');
//                    }
           
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
function ajaxReceiveMaking() {
         alert("hellow");
        var data = {
            "Pid": global,
            "Return_Stone": $('#R_GOLD').val(),
            "Return_Gold": $('#R_STONE').val(),

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'receivemaking.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlay1").style.display = "none";
                
               $("#tbody").children('tr').remove();
                if (result) {
                   
//                    for (var i = 0; i < result.length; i++) {
//                        $("#m_worker").text(+result[i].assigned_By);
                       $("#msg").html("<strong>success Loading</strong>");
                       ajaxGETDETAILS();
//                    }
           
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
});