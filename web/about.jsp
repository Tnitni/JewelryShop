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
                        <div class="col-md-12 mb-0"><a href="home.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">About</strong></div>
                    </div>
                </div>
            </div>  

            <div class="site-section border-bottom" data-aos="fade">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-md-6">
                            <div class="block-16">
                                <figure>
                                    <img src="images/HopgoBlake_2_460x.webp" alt="image placeholder" class="img-fluid rounded">
                                </figure>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-5">


                            <div class="site-section-heading pt-3 mb-4">
                                <h2 class="text-black">8 Years of Crafting Handcrafted</h2>
                            </div>
                            <p>Each piece of jewelry from Helios is meticulously handcrafted by skilled artisans. These master jewelers pour their heart and passion into every creation, ensuring that each item is a unique work of art. The journey of crafting these exquisite pieces spans over eight years, during which our craftsmen have honed their skills to perfection. Every intricate detail and delicate engraving is a testament to their dedication and love for the art of jewelry making. At Helios, we believe in the timeless beauty and unparalleled quality that only handcrafted silver jewelry can offer, making each piece a cherished heirloom for generations to come.</p>
                           

                        </div>
                    </div>
                </div>
            </div>




            <div class="site-section site-section-sm site-blocks-1">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="">
                            <div class="icon mr-4 align-self-start">
                                <span class="icon-truck"></span>
                            </div>
                            <div class="text">
                                <h2 class="text-uppercase">Free Shipping</h2>
                                <p>Enjoy our Free Shipping service as we ensure your Jewelry reach you safely, no matter where you are. We handle all shipping costs, making your shopping experience hassle-free and enjoyable.</p>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="100">
                            <div class="icon mr-4 align-self-start">
                                <span class="icon-refresh2"></span>
                            </div>
                            <div class="text">
                                <h2 class="text-uppercase">Free Returns</h2>
                                <p>We stand behind the quality of our products. If you are not completely satisfied with your purchase, return it for free. We believe in making your experience with us as smooth as possible.</p>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="200">
                            <div class="icon mr-4 align-self-start">
                                <span class="icon-help"></span>
                            </div>
                            <div class="text">
                                <h2 class="text-uppercase">Customer Support</h2>
                                <p>Our dedicated Customer Support team is here to help you every step of the way. Whether you have questions about our products, need help with your order, or want advice on choosing the perfect pair, we are just a call or click away.</p>
                            </div>
                        </div>
                    </div>
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