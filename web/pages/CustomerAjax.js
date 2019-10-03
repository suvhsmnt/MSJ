/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

     document.getElementById("overlayfortable").style.display = "block";
    ajaxGOLD_STOCK_Types();
    
    $("#addCustomerGold").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        document.getElementById("overlayfortable").style.display = "block";
        alert("hh");
        ajaxAddCustomerGold();
    });
     function ajaxGOLD_STOCK_Types() {
        var Type = {
            "Type": "GOLD_STOCK"

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'getGoldStocktypes.htm',
            data: JSON.stringify(Type),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlayfortable").style.display = "none";

                $("#GoldType").children('option').remove();
                if (result) {
                 
                    for (var i = 0; i < result.length; i++) {
                        $("#GoldType").append('<option value=' + result[i].name + '>' + result[i].name + '</option>');
                    }
                    ;
                    $("#GoldType").selectpicker("refresh");

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
     function ajaxAddCustomerGold() {
        var data = {
            "Customer_id": $('#Customer_id').val(),
            "Gold_Quantity": $('#GoldQuantity').val(),
            "Purpose": $('#Purpose').val(),
            "Password": $('#PassForAddGold').val(),
            "Type": $('#GoldType').val()

        };
        $.ajax({
            type: "POST",
            contentType: 'application/json; charset=utf-8',
            url: 'AddGoldCustomer.htm',
            data: JSON.stringify(data),
            dataType: "JSON",
            success: function (result) {
                document.getElementById("overlayfortable").style.display = "none";
                
               
                if (result) {
                    $("#msg").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>");
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
