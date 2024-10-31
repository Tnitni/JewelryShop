<%@page import="Invoice.InvoiceDTO"%>
<%@page import="Invoice.InvoiceDAO"%>
<%@page import="java.util.List"%>
<%@page import="user.UserDAO"%>
<%@page import="user.UserDTO"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">


        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>    
        <%-- searh bar --%>
        <div class="site-wrap">
            <header class="site-navbar" role="banner">
                <div class="site-navbar-top">
                    <div class="container">
                        <div class="row align-items-center">

                            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
                                <form action="MainController" method="POST" class="site-block-top-search">
                                    <span class="icon icon-search2"></span>
                                    <input type="text" name="search" class="form-control border-0" placeholder="Search">
                                    <input type="hidden" name="action" value="Search">
                                </form>
                            </div>

                            <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
                                <div class="site-logo">
                                    <a href="home.jsp" class="js-logo-clone">MY Jewelry</a>
                                </div>
                            </div>
                            <%--login-cart-update account information -logout--%>
                            <div class="col-6 col-md-4 order-3 order-md-3 text-right">
                                <form action="MainController" method="POST">
                                    <div class="site-top-icons">
                                        <ul>
                                            <% if (loginUser == null) { %>
                                            <li><a href="login.jsp"><span class="icon icon-person"></span> Login</a></li>
                                            <li><a href="register.jsp"><span class="icon icon-person"></span> Register</a></li>
                                                <% } else { %>
                                            <li><a href="LogoutController"></span>LOG OUT</a></li>
                                            <li><a href="update.jsp"><span class="icon icon-person"></span></a></li>
                                                    <% } %>

                                            <li class="d-inline-block d-md-none ml-md-0"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
                                        </ul>
                                    </div> 
                                </form>    
                            </div>

                        </div>
                    </div>
                </div> 
                <nav class="site-navigation text-right text-md-center" role="navigation">
                    <div class="container">
                        <ul class="site-menu js-clone-nav d-none d-md-block">
                            <li><a href="home.jsp">Home</a></li>
                            <% if (loginUser != null && loginUser.getRoleID().equals("US")) { %>
                    <li class="has-children">
                        <a href="shop.jsp">JEWELRY</a>

                        <ul class="dropdown" style="list-style-type: none;">
                            <form action="MainController" method="POST">
                                <li><a href="SearchCategoriesController?category=Bracelet" class="d-flex">Bracelet</a></li>
                                <li><a href="SearchCategoriesController?category=Chain" class="d-flex">Chain</a></li>
                                <li><a href="SearchCategoriesController?category=Earring" class="d-flex">Earring</a></li>
                                <li><a href="SearchCategoriesController?category=Ring" class="d-flex">Ring</a></li>
                                <li><a href="SearchCategoriesController?category=Pendant" class="d-flex">Pendant</a></li>
                                <li><a href="SearchCategoriesController?category=Other" class="d-flex">Other...</a></li>
                            </form>
                        </ul>
                    </li>
                    <li><a href="about.jsp">About</a></li>
                        <%}%>
                                <% if (loginUser != null && loginUser.getRoleID().equals("AD")) { %>
                            <li><a href="createJewelry.jsp">Add new product</a></li>
                            <li><a href="user.jsp">Manage User</a></li>
                            <li><a href="invoice.jsp">Manage Invoice</a></li>
                            <li><a href="Jewelry.jsp">Update Jewelry</a></li>
                            <li><a href="update.jsp">Account</a></li>
                                <%} %>
                                <% if (loginUser != null && loginUser.getRoleID().equals("US")) { %>
                            <li><a href="update.jsp">Account</a></li>
                                <%}%>

                        </ul>
                    </div>
                </nav>
            </header>

            <div class="bg-light py-3">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 mb-0"><a href="admin.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Invoice Manage</strong></div>
                    </div>
                </div>
            </div>  


            <%
                InvoiceDAO dao = new InvoiceDAO();
                List<InvoiceDTO> invoiceList = dao.getAllInvoices();
                if (request.getAttribute("Invoice_List") != null) {
                    invoiceList = (List<InvoiceDTO>) request.getAttribute("Invoice_List");
                }
            %>
            <div class="container">
                <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
                    <form action="MainController" method="POST" class="site-block-top-search">
                        <span class="icon icon-search2"></span>
                        <input type="text" name="search" class="form-control border-0" placeholder="Search by UserId">
                        <input type="hidden" name="action" value="SearchInvoice">
                    </form>
                </div>
                <table class="table table-striped table-responsive-md">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Invoice ID</th>
                            <th scope="col">User ID</th>
                            <th scope="col">Date</th>
                            <th scope="col">Email</th>
                            <th scope="col">Address</th>
                            <th scope="col">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (InvoiceDTO invoice : invoiceList) {%>
                        <tr>
                            <td><%= invoice.getInvId()%></td>
                            <td><%= invoice.getUserId()%></td>
                            <td><%= invoice.getDateBuy()%></td>
                            <td><%= invoice.getGmail()%></td>
                            <td><%= invoice.getAddress()%></td>
                            <td>$<%= invoice.getTotal()%></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
            <%
                String message = (String) request.getAttribute("message");
                if (message == null) {
                    message = "";
                }
            %>
            <div class="d-flex justify-content-center">
                <h3 style="color: red;"><%= message%></h3>
            </div> 
        </div>


        <footer class="site-footer border-top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <div class="row">
                            <div class="col-md-12">
                                <h3 class="footer-heading mb-4">Navigations</h3>
                            </div>
                            <div class="col-md-6 col-lg-4">
                                <ul class="list-unstyled">
                                    <li><a href="register.jsp">Create new account</a></li>
                                    <li><a href="login.jsp">Login</a></li>
                                    <li><a href="home.jsp">Menu</a></li>

                                </ul>
                            </div>
                            <div class="col-md-6 col-lg-4">
                                <ul class="list-unstyled">
                                    <li><a href="shop.jsp">Shop</a></li>

                                    <li><a href="about.jsp">About</a></li>

                                </ul>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 mb-4 mb-lg-0">

                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="block-5 mb-5">
                            <h3 class="footer-heading mb-4">Contact Info</h3>
                            <ul class="list-unstyled">
                                <li class="Address">FPT university</li>
                                <li class="phone"><a href="tel://1234567">+2 392 3929 210</a></li>
                                <li class="email">SE180481emailAddress@gmail.com</li>
                            </ul>
                        </div>


                    </div>
                </div>

            </div>
        </footer>
    </div>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/aos.js"></script>

    <script src="js/main.js"></script>

</body>
</html>