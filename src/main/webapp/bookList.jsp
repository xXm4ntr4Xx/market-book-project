
<%@page import="dao.BasketQueryDAO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page import="org.apache.jasper.JasperException"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css"
	rel="stylesheet">
	<style type="text/css">
		body{
	background-image: url("https://i.pinimg.com/originals/fb/c9/0c/fbc90c027969e55c8691f4479ec77c0e.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
	}
	
	</style>

<title>Insert title here</title>
</head>
<body>
<%String email = (String)session.getAttribute("email"); %>
	<!--  -->
	<nav
		class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 rounded dark:bg-gray-800">
		<div
			class="container flex flex-wrap justify-between items-center mx-auto">
			<a href="http://localhost:8080/market-book/WelcomePage.jsp" class="flex"> <span
				class="self-center text-lg font-semibold whitespace-nowrap dark:text-white">The
					Book Store</span>
			</a>
			<button data-collapse-toggle="mobile-menu" type="button"
				class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
				aria-controls="mobile-menu-2" aria-expanded="false">
				</button>
			<div class="hidden w-full md:block md:w-auto" id="mobile-menu">
				<ul
					class="flex flex-col mt-4 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium">
					<li>
						<a href="index.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Main Page</a>
					</li>
					<li>
 						<a href="Login.jsp"class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"aria-current="page">Login</a>
 					</li>
					<li>
						<a href="Register.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">New Customer</a>
					</li>
					<a href="http://localhost:8080/market-book/WelcomePage.jsp">${email}</a>
 					<li>
						<a href="http://localhost:8080/market-book/UserLogout" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"aria-current="page"/>Logout</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- email info -->
	

<!-- book table -->
<div class="p-20">
	<table border="1"
		class="flex justify-center table-auto border-separate border-spacing-2 border border-slate-500 ">
		<tr>
			<th class="border border-slate-700">Book id</th>
			<th class="border border-slate-700">Book Title</th>
			<th class="border border-slate-700">Book Author</th>
			<th class="border border-slate-700">Book Year</th>
			<th class="border border-slate-700">Book Cost</th>
			<th class="border border-slate-700">Link</th>
			<th class="border border-slate-700">Basket</th>
		</tr>

		<c:forEach items="${res}" var="book">
			<tr>
				<td class="border border-slate-800"><c:out
						value="${book.bookId}" /></td>
				<td class="border border-slate-800"><c:out
						value="${book.bookTitle}" /></td>
				<td class="border border-slate-800"><c:out
						value="${book.bookAuthor}" /></td>
				<td class="border border-slate-800"><c:out
						value="${book.bookYear}" /></td>
				<td class="border border-slate-800"><c:out
						value="${book.bookCost}" /></td>
				<td class="border border-slate-800">
					<form action="http://localhost:8080/market-book/SearchBookDetails"
						method="GET">
						<input type="text" value="${book.bookId}" name="bookDetailsId" hidden="" /> 
						<input type="submit" value="Info" 
							class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
							/>
					</form>
				</td>
				<td class="border border-slate-700">
					<form action="http://localhost:8080/market-book/AddToBasket" method="POST">
						<input type="text" value="${book.bookId}" name="id" hidden="" />
							<input type="submit" value="+"
							class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<!--  show book-->
	 <div class="flex justify-center ">
	<form action="http://localhost:8080/market-book/BookShow" action="http://localhost:8080/market-book/BookShow"method="GET">
		 <input type="submit" value="Show Books" 
				class="flex justify-center bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"/> 
	</form>
	</div> 
	
	<div class="flex justify-center ">
	<form action="http://localhost:8080/market-book/ShowBookOnBasket" method="GET">
		 <input type="submit" value="Show Basket" 
				class="flex justify-center bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"/> 
	</form>
	</div> 
	

<%-- <!-- //basket -->
	<table border="1"
		class="table-auto border-separate border-spacing-2 border border-slate-500">
		<tr>
		<th class="border border-slate-600">Book id</th>
			<th class="border border-slate-600">Book title</th>
			<th class="border border-slate-600">Book cost</th>
			<th class="border border-slate-600">Delete</th>
			<th class="border border-slate-600">Number of Books</th>
		</tr>
		<tr>
			<c:forEach items="${basket}" var="book">
				<tr>
					<td class="border border-slate-700">
					<c:out value="${book.bookId}" />
					</td>
					<td class="border border-slate-700">
					<c:out value="${book.bookTitle}" />
					</td>
					<td class="border border-slate-700">
					<c:out value="${book.bookCost}" />
					</td>
					<td class="border border-slate-700">
					<form action="http://localhost:8080/market-book/DeleteFromBasket"
						method="POST">
						<input type="text" value="${book.bookId}" name="id" hidden="" />
						<input type="submit" value="-" 
							class="bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"/>
					</form>
				</td>
			 	<td class="border border-slate-700">
				</td> 
					
				<tr>
			</c:forEach>			
	</table>
	
	<!--show book  -->
	<form action="http://localhost:8080/market-book/ShowBookOnBasket" method="GET">
	<input type="submit" value="Show Books"/>
	</form> --%>
</body>
</html>