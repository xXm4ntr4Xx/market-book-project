<%@page import="org.apache.jasper.JasperException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1 {
	text-align: center;
}

h2 {
	color: gray;
	text-align: center;
}
</style>
<meta charset="UTF-8">
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css"
	rel="stylesheet">
<title>Book Details</title>
</head>
<body>
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
					<li><a href="index.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Main Page</a></li>
					<li><a href="bookList.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Book List</a></li>
					<li><a href="Register.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">New
							Customer</a>
					</li>
					<a href="http://localhost:8080/market-book/WelcomePage.jsp">${email}</a>
 					<li>
					<a href="http://localhost:8080/market-book/UserLogout" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"aria-current="page"/>Logout</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!--  -->
	<%String email = (String)session.getAttribute("email"); %>
	<p>${email}</p>
<div class="card w-96 bg-base-100 shadow-xl">
<div class="card-body">
 <c:forEach items="${singleBook}" var="book">
  <h1>Book Name</h1>
  <h2>${book.bookTitle}</h2>
  <h1>Author</h1>
  <h2>${book.bookAuthor}</h2>
  <h1>Date of Release</h1>
  <h2>${book.bookYear}</h2>
  <h1>Price</h1>
  <h2>${book.bookCost}</h2>
 </c:forEach>
</div>
</div>

<!--  show book-->
	 <div class="flex justify-center ">
	<form action="http://localhost:8080/market-book/BookShow" method="GET">
		 <input type="submit" value="Show Books" autofocus="autofocus"
				class="flex justify-center bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"/> 
	</form>
	</div> 

</body>

</html>