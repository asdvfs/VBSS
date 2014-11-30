<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>

<script type="text/javascript">

function GetXmlHttpObject()
  { 
   var xmlHttp=null; 
   try {
     // Firefox, Opera 8.0+, Safari
     xmlHttp=new XMLHttpRequest(); 
    }catch (e){ 
    // Internet Explorer
    try{ 
       xmlHttp=new ActiveXObject("Msxml2.XMLHTTP"); 
      }catch (e) {
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP"); 
      } 
    } 
    return xmlHttp; 
   }

function LoadData(){
    var userlPath="<%=request.getContextPath()%>/order/handle";
    //alert(userlPath);
    httpRequest=GetXmlHttpObject();
    httpRequest.open("POST",userlPath,false);
    httpRequest.onreadystatechange=callbackhandler;
    httpRequest.send(null);
    }
  
     function callbackhandler(){
      if(httpRequest.readyState==4&&httpRequest.status==200){
         var loadData = httpRequest.responseText;
           alert(loadData);
         }
         
    }     

</script>

</head>
<body>

<input type="button" value="测试" onclick="LoadData();" />







</body>
</html>
