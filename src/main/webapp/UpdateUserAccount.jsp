<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css"
	rel="stylesheet">
	<style type="text/css">
	.theBody{
	background-image: url("https://cdn5.vectorstock.com/i/1000x1000/83/84/hand-drawn-book-retro-sketch-engraving-monochrome-vector-26628384.jpg");
	}
	.theBody2{
		background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSr_H8J7Rc08IspI1qtrvnXuU3wGIaktNGDUw&usqp=CAU");
	
	}
</style>
<title>Insert title here</title>
</head>
<body>
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
					<li><a href="WelcomePage.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Main Page</a></li>
					<li><a href="Login.jsp"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Login</a>
					</li>
					<a href="http://localhost:8080/market-book/WelcomePage.jsp">${email}</a>
				</ul>
			</div>
		</div>
	</nav>
	<!--  -->
	<%String email = (String)session.getAttribute("email"); %>
	
	<!-- <form action="http://localhost:8080/market-book/UserRegistration"method="GET">
		<label>Name:</label> <input type="text" name="name" /><br /> <label>Surname:</label>
		<input type="text" name="surname" /><br /> <label>Email:</label> <input
			type="email" name="email" /><br /> <label>Password:</label> <input
			type="password" name="password" /><br /> <input type="submit"
			name="Submit" />
	</form> -->

	 <div class="flex items-center justify-center min-h-screen bg-gray-100 theBody">
    	<div class="px-8 py-6 mx-4 mt-4 text-left bg-white shadow-lg md:w-1/3 lg:w-1/3 sm:w-1/3 theBody2">
       <!--  <div class="flex justify-center">
           <svg xmlns="http://www.w3.org/2000/svg" class="w-20 h-20 text-blue-600" fill="none" viewBox="0 0 24 24"
                stroke="currentColor">
                <path d="M12 14l9-5-9-5-9 5 9 5z" />
                <path
                    d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z" />
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                    d="M12 14l9-5-9-5-9 5 9 5zm0 0l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14zm-4 6v-7.5l4-2.222" />
            </svg> 
        </div> -->
        <h3 class="text-2xl font-bold text-center">Update Account</h3> 
        <form action="http://localhost:8080/market-book/UpdateUser" method="POST">
            <div class="mt-4">
            	<div>
                    <label class="block" for="email">Old email</label>
                            <input type="text" placeholder="Name"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
                                name="email" required>
                </div>
                <div>
                    <label class="block" for="passowrd">Old password</label>
                            <input type="text" placeholder="Surname"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
								name="password"required>
                </div>
                <div>
                    <label class="block" for="Name">New Name</label>
                            <input type="text" placeholder="new name"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
								name="newName"required>
                </div>
                <div>
                    <label class="block" for="Surname">New Surname</label>
                            <input type="text" placeholder="new surname"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"
								name="newSurname"required>
                </div>
                <div class="mt-4">
                    <label class="block" for="email">New Email</label>
                            <input type="text" placeholder="new email"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600" 
								name="newEmail"required>
                </div>
                <div class="mt-4">
                    <label class="block">New Password</label>
                            <input type="password" placeholder="new password"
                                class="w-full px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600" 
								name="newPassword"required>
                </div>
                  
                <div class="flex">
                    <button class="w-full px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900"type="submit" name="Submit">Update Account</button>
                </div>
            </div>
        </form>
    </div>
</div> 


</body>
</html>