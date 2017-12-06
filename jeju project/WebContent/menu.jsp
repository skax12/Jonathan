<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            background-color: #fff;  
        }
        h1{
            color: red;
        }
    
    
    </style>
   
  </head>
 <body>
    
   <h1>Breadcrumbs</h1>
   <!--
       li 태그에 class active  부여시 회색으로 변함  
       a 태그를 삭제해야 하는점은 코딩시 불편할거 같지만 ....
   -->
   <ol class="breadcrumb">
      <li class="active">Home</li>
    </ol>
         
    <ol class="breadcrumb">
      <li><a href="#">Home</a></li>
      <li class="active">Library</li>
    </ol>
               
    
   <ol class="breadcrumb">
      <li><a href="#">Home</a></li>
      <li><a href="#">Library</a></li>
      <li class="active">Data</li>
    </ol>
    
    <h1>Pagination</h1>
    <!-- 
    li 태그에 class disabled 부여시 마우스 on 시  사용못한다는 마우스 이펙트 발생
    active 부여시 현재페이지 나타냄으로 사용할수 있음
    
    ul class에 pagination-sm 부여로 페이징 사이즈 크기를 부여할수 있다.
    sm , md , xs, lp 익숙해지는것 같다
    -->
     <nav>
      <ul class="pagination">
        <li class="disabled">
        
          <a href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
        <li><a href="#1">1</a></li>
        <li><a href="#2">2</a></li>
        <li><a href="#3">3</a></li>
        <li><a href="#4">4</a></li>
        <li><a href="#5">5</a></li>
        <li>
          <a href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>
     

  </body>
</html>
