<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web Calculator</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='style.css'>
    </head>
    <body>
      <h3>Web Calculator</h3>
     <form name = "form1" method="get" action="appservlet">  
     <div class="container">
        <div class="calc-body">
          <div class="calc-screen">
            <div class="calc-operation" style="text-align: right; color: grey; font-size:20px"> ${result}</div>
            <input class="calc-typed" id = "calc" type ="text" name = "answer" value="${inputBox}" style="font-size: 18pt; height: 40px; width:230px; ">
            <br> <br>  
          </div>
          
          <div class="calc-button-row">
            <input class="button l" type = "submit" value = "AC" name="equal" style="color:red">
            <input class="button l" type = "button" value = "&radic;" onclick = "form1.answer.value += 'sqrt' ">
            <input class="button l" type = "button" value = "x&sup2" onclick = "form1.answer.value += '^2' ">
            <input class="button l" type = "button" value = "/" onclick = "form1.answer.value += '/' ">
          </div>
          <div class="calc-button-row">
            <input class="button" type = "button" value = "7" onclick = "form1.answer.value += '7' ">
            <input class="button" type = "button" value = "8" onclick = "form1.answer.value += '8' ">
            <input class="button" type = "button" value = "9" onclick = "form1.answer.value += '9' ">
            <input class="button l" type = "button" value = "*" onclick = "form1.answer.value += '*' ">
          </div>
          <div class="calc-button-row">
            <input class="button" type = "button" value = "4" onclick = "form1.answer.value += '4' ">
            <input class="button" type = "button" value = "5" onclick = "form1.answer.value += '5' ">
            <input class="button" type = "button" value = "6" onclick = "form1.answer.value += '6' ">
            <input class="button l" type = "button" value = "-" onclick = "form1.answer.value += '-' ">
          </div>
          <div class="calc-button-row">
          	<input class="button" type = "button" value = "1" onclick = "form1.answer.value += '1' ">
          	<input class="button" type = "button" value = "2" onclick = "form1.answer.value += '2' ">
          	<input class="button" type = "button" value = "3" onclick = "form1.answer.value += '3' ">
          	<input class="button l" type = "button" value = "+" onclick = "form1.answer.value += '+' ">
          </div>
          <div class="calc-button-row">
          	<input class="button" type = "button" value = "." onclick = "form1.answer.value += '.' ">
          	<input class="button" type = "button" value = "0" onclick = "form1.answer.value += '0' ">
          	<input class="button" type = "button" value = "!" onclick = "form1.answer.value += '!' ">
          	<input class="button l" type = "submit" name="equal" value = "=" >
            </div>
           <div class="calc-button-row" style="display:flex;">
            <input class="button l" style="flex-grow: 4; justify-content: space-evenly;" type = "submit" name="equal" value = "ANS">
          </div>
          <div class="calc-button-row" style="display:flex; justify-content: space-evenly;">
            <input class="button l" style="display:flex; flex-grow: 2;" type = "submit" value = "Prev" name= "equal">
            <input class="button l" style="display:flex; flex-grow: 2;" type = "submit" value = "Next" name= "equal">
          </div>
          </div>
        </div>
        </form>
</body>
</html>