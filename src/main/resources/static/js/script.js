function validate() {
  username = $("#name")
  password = $("#pass")
    $.ajax({url: "login",
      method: "POST",
      data:{  "username":username.val(),
    	  	  "password":password.val()
      },
      success: function(result){
          alert(result);
          $("#section-login").hide();
          $("#section-list").show();
          $.ajax({url: "/list",
        	  success:function(list){
        		  generateTable(list);
        		 
        	  }
          });
        },
      error: function(error) {
        alert("Invalid username or password");
      } 
    
  });
  
}
function generateTable(list){
	var row = "";
    for (var i = 0; i < list.length; i++) {
        row+="<tr>";
        row+="<td>"+list[i].employeeCode+"</td>";
        row+="<td>"+list[i].name+"</td>";
        row+="<td>"+list[i].location+"</td>";
        row+="<td>"+list[i].email+"</td>";
        row+="<td>"+list[i].dob+"</td>";
        row+="<td><button id=\""+list[i].employeeCode+"\"onclick=editpage("+list[i].employeeCode+")>Edit</button></td>";
  		row+="</tr>";

    }
  $("#emp-table tbody").html(row); 
}
function editpage(empId){
	//$("#empCode").text(empId);
	$("#empCode").val(empId);
	$("#section-list").hide();
	$("#edit-details").show();
	}
function editUser() {
	empCode=$("#empCode")
	empName = $("#empName")
	empLoc= $("#empLoc")
	empMail = $("#empMail")
	empDob = $("#empDob")
	$("#empCode").prop("disabled", true);
	console.log(empCode.val());
	console.log(empName.val());
	console.log(empLoc.val());
	  $.ajax({url:"editdetails",
		  method: "POST",
	      data:{ 
	    	      "empCode":empCode.val(),
	    	  	  "empName":empName.val(),
	    	  	  "	empLoc":empLoc.val(),
	    	  	  "empMail":empMail.val(),
	    	  	  "empDob":empDob.val()
	      },
	      success: function(result) {
	    	  alert("success")
	      },
	      error: function(error) {
	    	  alert("error")
	      }
	    	  
	  });
}
