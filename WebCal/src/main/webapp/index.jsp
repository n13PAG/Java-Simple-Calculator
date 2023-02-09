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
      <!--
       <form method="get" action="appservlet">
       Enter No:<input type=text name=t1>
       <input type = submit value="check evenorodd">
       </form> -->
     <form name = "form1" method="get" action="appservlet">  
     <div class="container">
        <div class="calc-body">
          <div class="calc-screen">
            <div class="calc-operation"> ${result}</div>
            <input class="calc-typed" id = "calc" type ="text" name = "answer" style="font-size: 18pt; height: 40px; width:230px; "><br> <br>  
            <!-- <div class="calc-typed"></div> -->
          </div>
          
          <div class="calc-button-row">
            <!-- <div class="button c">C</div> -->
            <input class="button l" type = "submit" value = "AC" name="allclear">
            <input class="button l" type = "button" value = "&radic;" onclick = "form1.answer.value += 'sqrt' ">
            <input class="button l" type = "button" value = "x&sup2" onclick = "form1.answer.value += '^2' ">
            <input class="button l" type = "button" value = "/" onclick = "form1.answer.value += '/' ">
            <!-- <div class="button l">&radic;</div>
            <div class="button l">x<sup>2</sup></div>
            <div class="button l">/</div> -->
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
            <!-- <div class="button">1</div> -->
            <!-- <div class="button">2</div> -->
            <!-- <div class="button">3</div>
            <div class="button l">+</div> -->
          </div>
          <div class="calc-button-row">
          	<input class="button" type = "button" value = "." onclick = "form1.answer.value += '.' ">
          	<input class="button" type = "button" value = "0" onclick = "form1.answer.value += '0' ">
          	<input class="button" type = "button" value = "!" onclick = "form1.answer.value += '!' ">
          	<input class="button l" type = "submit" name="equal" value = "=" >
            </div>
           <div class="calc-button-row" style="display:flex;">
            <input class="button l" style="flex-grow: 4; justify-content: space-evenly;" type = "button" value = "ANS" onclick = " ">
            <input class="button l" type = "button" value = "<" onclick = " ">
            <input class="button l"  type = "button" value = ">" onclick = " ">
          </div>
          </div>
        </div>
        </form>
</body>
</html>