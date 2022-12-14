
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
<style>
input {
	background: none !important;
	border: none;
	padding: 0 !important;
	border-bottom: medium;
	cursor: pointer;
	text-decoration: underline;
	color: -webkit-link;
	font-family: serif;
	font-size: 15px;
}

input:visited {
	color: blu;
}
.theBody{
	background-image: url("https://cdn5.vectorstock.com/i/1000x1000/83/84/hand-drawn-book-retro-sketch-engraving-monochrome-vector-26628384.jpg");
	}
	.theBody2{
		background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSr_H8J7Rc08IspI1qtrvnXuU3wGIaktNGDUw&usqp=CAU");
	
	}
</style>
<title>Main</title>
</head>
<body>
	<%String email = (String)session.getAttribute("email"); %>
	<!--  -->
	<nav
		class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 rounded dark:bg-gray-800">
		<div
			class="container flex flex-wrap justify-between items-center mx-auto">
			<a href="index.jsp" class="flex"> <span
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
					<li><a href="SearchBook.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Search Book</a></li>
					<li><a href="Login.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Login</a></li>
					<li><a href="Register.jsp" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>New
							Customer</a>
					</li>
					<%-- <li >${email}</li> --%>
					<a href="http://localhost:8080/market-book/WelcomePage.jsp">${email}</a>
 					<li>
					<a href="http://localhost:8080/market-book/UserLogout" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"aria-current="page"/>Logout</a>
					</li>
				</ul>
				
			</div>
		</div>
	</nav>
	<!--  -->
	
	
	
	<div class="flex items-center justify-center min-h-screen bg-gray-100 fail theBody">
    	<div class="px-8 py-6 mx-4 mt-4 text-left bg-white shadow-lg md:w-1/3 lg:w-1/3 sm:w-1/3 theBody2">
        <div class="flex justify-center">
        </div>
        <h2 class="text-2xl font-bold text-center">Hello ${email}</h2> 
        <form action="http://localhost:8080/market-book/BookShow?" method="GET">
                <div class="flex">
                    <button class="w-full px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900"type="submit" name="Submit">Go to Book List???</button>
                </div>
                <div class="flex">
                <a href="UpdateUserAccount.jsp" class="w-full px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900 flex items-center justify-center"> Update Details</a>
                </div>
            </div>
        </form>
    </div>
	

	
</body>
</html>