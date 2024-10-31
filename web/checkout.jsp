<%@page import="Cart.CartDTO"%>
<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page import="Invoice.InvoiceDTO"%>
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
            if (loginUser == null || !"US".equals(loginUser.getRoleID())) {
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
                                            <li>
                                                <a href="cart.jsp" class="site-cart">
                                                    <span class="icon icon-shopping_cart"></span>

                                                </a>
                                            </li> 
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

                            <% if (loginUser != null && loginUser.getRoleID().equals("US")) { %>
                            <li><a href="update.jsp">Account</a></li>
                                <%} %>

                        </ul>
                    </div>
                </nav>
            </header>


            <div class="bg-light py-3">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 mb-0"><a href="home.jsp">Home</a> <span class="mx-2 mb-0">/</span><a href="shop.jsp">Shop</a> <span class="mx-2 mb-0">/</span> <a href="cart.jsp">Cart</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Checkout</strong></div>
                    </div>
                </div>
            </div>

            <div class="site-section">
                <div class="container">
                    <%
                        InvoiceDTO invoice = (InvoiceDTO) session.getAttribute("invoice");

                    %>
                    <form action="CreateInvoiceController" method="POST">
                        <div class="row">

                            <div class="col-md-6 mb-5 mb-md-0">
                                <h2 class="h3 mb-3 text-black">Billing Details</h2>
                                <div class="p-3 p-lg-5 border">
                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="c_invId" class="text-black">Invoice ID</label>
                                            <input type="text" class="form-control" id="c_invId" name="InvId" value="<%=invoice.getInvId()%>" readonly>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="c_userId" class="text-black">User ID</label>
                                            <input type="text" class="form-control" id="c_userId" name="UserId" value="<%=loginUser.getUserId()%>" readonly>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="c_dateBuy" class="text-black">Date of Purchase <span class="text-danger">*</span></label>
                                            <input type="datetime-local" class="form-control" id="c_dateBuy" name="dateBuy">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="c_gmail" class="text-black">Email <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="c_gmail" name="gmail"value="<%=loginUser.getGmail()%>" placeholder="Enter email">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control" id="c_address" name="address" value="<%=loginUser.getAddress()%>"placeholder="Enter address">
                                        </div>
                                    </div>

                                    <!-- Rest of your form here -->
                                </div>
                            </div>


                            <div class="col-md-6">
                                <div class="row mb-5">
                                    <div class="col-md-12">
                                        <h2 class="h3 mb-3 text-black">Your Order</h2>
                                        <div class="p-3 p-lg-5 border">
                                            <table class="table site-block-order-table mb-5">
                                                <thead>
                                                <th>Product</th>
                                                <th>Total</th>
                                                </thead>
                                                <tbody>
                                                    <%
                                                        List<CartDTO> cartList = (List<CartDTO>) session.getAttribute("cartList");
                                                        float totalCost = 0;
                                                        for (CartDTO cart : cartList) {
                                                            totalCost += cart.getTotalPrice();
                                                    %>
                                                    <tr>
                                                        <td><%=cart.getJewelryId()%> <strong class="mx-2">x</strong> <%=cart.getQuantity()%></td>
                                                        <td>$<%=cart.getTotalPrice()%></td>
                                                    </tr>
                                                    <%
                                                        }
                                                    %>
                                                    <tr>
                                                        <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                                                        <td class="text-black font-weight-bold"><strong>$<%=totalCost%></strong></td>
                                                    </tr>
                                                    
                                                </tbody>
                                            </table>
                                            <div class="form-group">
                                                <input type="hidden" name="total" value="<%=totalCost%>">
                                                <button type="submit"name="action" value="CreateInvoice" class="btn btn-primary btn-lg py-3 btn-block">Place Order</button>
                                            </div>
                                                <div class="form-group row">   
                                    <div class="col-lg-12">
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
                                </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </form>
                    <!-- </form> -->
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