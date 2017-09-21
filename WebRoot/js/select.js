function inputGmjjhy(){
	var xqjsyyhy2 = document.getElementById('sec_h');
	var xqjsyyhy3 = document.getElementById('thi_h');
	
	if(xqjsyyhy3=="")
	{
		form1.XKFL.value = xqjsyyhy2.options[xqjsyyhy2.selectedIndex].text;
	}else if(xqjsyyhy3 != "")
	{
		form1.XKFL.value = xqjsyyhy3.options[xqjsyyhy3.selectedIndex].text;
	}
}
function inputXkfl(){
	var xkfl2 = document.getElementById('sec');
	var xkfl3 = document.getElementById('thi');
	if(xkfl3=="")
	{
		form1.GMJJHY.value = xkfl2.options[xkfl2.selectedIndex].text;
	}else if(xkfl3 != "")
	{
		form1.GMJJHY.value = xkfl3.options[xkfl3.selectedIndex].text;
	}else{
		form1.GMJJHY.value ="";
	}
	
}

//获取国民经济的第二个下拉框的值

function getSecondGmjjhys(){
	if($("#fir_h").val()==null||$("#fir_h").val()=="")
	{
		//alert("空");
	}else{
		$.ajax({
		    type:"post",
		    dataType:"text",
		    url:"Gm2.action",
		    data:{
		     'GmCode2':$("#fir_h").val()
		    },
		    success:function(data)
		    {
		    	//alert(data);
		    	 var data1 = eval("("+data+")"); 
		    	$("#sec_h").html("");//清空sec_h内容
				$("#sec_h").append("<option value=''></option>");
				$.each(data1.second, function(i, item) {
					if((item.code).substr(1, 4)!="0000")
					{
					$("#sec_h").append(
							"<option value='"+ item.code+"'>"+item.title+"</option>");
					}
				});
		    }
		  });
	}
}


//获取国民经济行业的第三个下拉框的值
function getThirdGmjjhys(){
	if($("#sec_h").val()==null||$("#sec_h").val()=="")
	{
		//alert("空");
	}else{
		$.ajax({
		    type:"post",
		    dataType:"text",
		    url:"Gm3.action",
		    data:{
		     'GmCode3':$("#sec_h").val()
		    },
		    success:function(data)
		    {
		    	//alert(data);
		    	 var data1 = eval("("+data+")"); 
		    	$("#thi_h").html("");//清空thigm内容
				$("#thi_h").append("<option value=''></option>");
				$.each(data1.third, function(i, item) {
					if((item.code).substr(3, 2)!="00")
					{
					$("#thi_h").append(
							"<option value='"+ item.code+"'>"+item.title+"</option>");
					}
				});
		    }
		  });
	}
}

//获取学科分类第二个下拉框的值
function getSecondXkfls(){
	if($("#fir").val()==null||$("#fir").val()=="")
	{
		//alert("空");
	}else{
		//alert($("#XKFL1").val());
		$.ajax({
		    type:"post",
		    dataType:"text",
		    url:"Classify2.action",
		    data:{
		     'ClassifyCode2':$("#fir").val()
		    },
		    success:function(data)
		    {
		    	//alert(data);
		    	 var data1 = eval("("+data+")"); 
		    	$("#sec").html("");//清空XKFL2内容
				$("#sec").append("<option value=''></option>");
				$.each(data1.secondid, function(i, item) {
					if((item.code).substr(2, 5)!="00000")
					{
					$("#sec").append(
							"<option value='"+ item.code+"'>"+item.title+"</option>");
					}
				});
		    }
		  });
	}
}

//获取学科分类的第三个下拉框的值
function getThirdXkfls(){
	if($("#sec").val()==null||$("#sec").val()=="")
	{
		//alert("空");
	}else{
		//alert($("#XKFL2").val());
		$.ajax({
		    type:"post",
		    dataType:"text",
		    url:"Classify3.action",
		    data:{
		     'ClassifyCode3':$("#sec").val()
		    },
		    success:function(data)
		    {
		    	//alert(data);
		    	 var data1 = eval("("+data+")"); 
		    	$("#thi").html("");//清空XKFL3内容
				$("#thi").append("<option value=''></option>");
				$.each(data1.thirdid, function(i, item) {
					if((item.code).substr(5, 2)!="00")
					{
					$("#thi").append(
							"<option value='"+ item.code+"'>"+item.title+"</option>");
					}
				});
		    }
		  });
	}
}

window.onload = function(){
    //获取国民经济的第一个下拉框值
	$.getJSON("Gm1.action", function(data) {
		$("#fir_h").html("");//清空SZDY内容
		$("#fir_h").append("<option value=''></option>");
		$.each(data.first, function(i, item) {
			$("#fir_h").append(
					"<option value='"+ item.code+"'>"+item.title+"</option>");
		});
	});
	
	//获取学科分类的第一个下拉框的值
	$.getJSON("Classify1.action", function(data) {
		$("#fir").html("");//清空XKFL1内容
		$("#fir").append("<option value=''></option>");
		$.each(data.firstid, function(i, item) {
			$("#fir").append(
					"<option value='"+ item.code+"'>"+item.title+"</option>");
		});
	});
	
}
