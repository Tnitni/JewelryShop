<%@page import="user.UserDTO"%>
<%@page import="Jewelry.JewelryDTO"%>
<%@page import="java.util.List"%>
<%@page import="Jewelry.JewelryDAO"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.5.0/nouislider.min.css">
        <style>

            /*            body{background: rgb(51,39,34);
                            background: linear-gradient(90deg, rgba(51,39,34,1) 0%, rgba(55,26,6,1) 56%, rgba(25,16,2,1) 100%);}
            */
            #priceSlider .noUi-handle {
                width: 20px;
                height: 20px;
                background: #fff;
                border: 2px solid #007bff;
                border-radius: 50%;
                box-shadow: 0 0 4px rgba(0, 0, 0, 0.5);
            }
            #priceSlider .noUi-connect {
                background: #007bff;
            }
            .form-container {
                max-width: 400px;
                margin: auto;
            }
            .filter-header {
                font-weight: bold;
                font-size: 1.2em;
                color: #343a40;
            }
        </style>
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
                        <div class="col-md-12 mb-0"><a href="home.jsp">Home</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Shop</strong></div>
                    </div>
                </div>
            </div>

            <div class="site-section">
                <div class="container">

                    <div class="row mb-5">
                        <%--show case--%>    
                        <%
                            JewelryDAO dao = new JewelryDAO();
                            List<JewelryDTO> JewelryList = null;
                            if (request.getAttribute("Jewelry_List") != null) {
                                JewelryList = (List<JewelryDTO>) request.getAttribute("Jewelry_List");
                            } else {
                                JewelryList = dao.getAllJewelry();
                            }
                        %>
                        <div class="col-md-9 order-2">
                            <div class="row">
                                <div class="col-md-12 mb-5">
                                    <div class="float-md-left mb-4"><h2 class="text-black h5">Shop All</h2></div>
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
                            <div class="row mb-5">
                                <% //  float highestPrice = 0;
                                    for (JewelryDTO Jewelry : JewelryList) {
//                                        if (Jewelry.getPrice() > highestPrice) {
//                                            highestPrice = Jewelry.getPrice();
//                                        }

                                %>
                                <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                                    <div class="block-4 text-center border">
                                        <figure class="block-4-image">
                                            <img src="images/<%= Jewelry.getImage()%>" alt="Image placeholder" class="img-fluid">
                                        </figure>
                                        <div class="block-4-text p-4">
                                            <h3><a href="#"><%= Jewelry.getJewelryId()%></a></h3>
                                            <p class="mb-0"><%= Jewelry.getDescription()%></p>
                                            <p class="text-primary font-weight-bold">$<%= Jewelry.getPrice()%></p>
                                            <form action="AddToCartController" method="POST">
                                                <input type="hidden" name="JewelryId" value="<%= Jewelry.getJewelryId()%>">
                                                <input type="hidden" name="Price" value="<%= Jewelry.getPrice()%>">
                                                <input type="hidden" name="image" value="<%= Jewelry.getImage()%>">
                                                <% if (loginUser == null) { %>
                                                <input type="hidden" name="UserId" value="">
                                                <% } else {%>
                                                <input type="hidden" name="UserId" value="<%= loginUser.getUserId()%>">
                                                <% } %>
                                                <input type="hidden" name="InvId" value="null">
                                                <input type="hidden" name="Quantity" value="1">
                                                <button type="submit" name="action" value="Add" class="btn btn-primary">Add to Cart</button>
                                            </form>   
                                        </div>
                                    </div>
                                </div>
                                <% }%>
                            </div>

                        </div>

                        <%--Searching bar--%>

                        <div class="col-md-3 order-1 mb-5 mb-md-0">
                            <div class="border p-4 rounded mb-4">
                                <h3 class="mb-3 h6 text-uppercase text-black d-block">Categories</h3>
                                <ul class="list-unstyled mb-0">
                                    <form action="MainController" method="POST">
                                        <li><a href="SearchCategoriesController?category=Bracelet" class="d-flex">Bracelet</a></li>
                                        <li><a href="SearchCategoriesController?category=Chain" class="d-flex">Chain</a></li>
                                        <li><a href="SearchCategoriesController?category=Earring" class="d-flex">Earring</a></li>
                                        <li><a href="SearchCategoriesController?category=Ring" class="d-flex">Ring</a></li>
                                        <li><a href="SearchCategoriesController?category=Pendant" class="d-flex">Pendant</a></li>
                                        <li><a href="SearchCategoriesController?category=Other" class="d-flex">Other...</a></li>
                                        <li class="mb-1"><a href="SearchCategoriesController?category=" class="d-flex"><span>All</span></a></li>
                                    </form>
                                </ul>

                            </div>

                            <div class="border p-4 rounded mb-4 form-container ">
                                <div class="mb-4">
                                    <form action="MainController" method="POST" id="priceForm">
                                        <h3 class="mb-3 h6 text-uppercase text-black d-block filter-header">Filter by Price</h3>
                                        <div id="priceSlider" class="mb-4"></div>
                                        <div class="d-flex justify-content-between mb-4">
                                            <input type="number" id="minPrice" name="minPrice" class="form-control" min="0" step="0.01" placeholder="Min Price">
                                            <span class="mx-2">-</span>
                                            <input type="number" id="maxPrice" name="maxPrice" class="form-control" min="0" step="0.01" placeholder="Max Price">
                                        </div>
                                        <input type="hidden" name="action" value="SearchPrice">
                                        <div class="mb-1 text-center">
                                            <button type="submit" class="btn btn-primary">Filter</button>
                                        </div>
                                    </form>
                                </div>
                            </div>


                            <!-- Include jQuery -->
                            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                            <!-- Include Bootstrap JS -->
                            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
                            <!-- Include noUiSlider JS -->
                            <script src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.5.0/nouislider.min.js"></script>
                            <% float highestPrice = 0;
                                for (JewelryDTO Jewelry : JewelryList) {
                                    if (Jewelry.getPrice() > highestPrice) {
                                        highestPrice = Jewelry.getPrice();
                                    }
                                }%>
                            <script>

                                document.addEventListener('DOMContentLoaded', function () {
                                    var highestPrice = <%= highestPrice%>;
                                    var priceSlider = document.getElementById('priceSlider');

                                    noUiSlider.create(priceSlider, {
                                        start: [0, highestPrice], // Initial values for the handles
                                        connect: true,
                                        range: {
                                            'min': 0,
                                            'max': highestPrice
                                        },
                                        tooltips: false, // Disable tooltips
                                        format: {
                                            to: function (value) {
                                                return value.toFixed(2);
                                            },
                                            from: function (value) {
                                                return Number(value);
                                            }
                                        }
                                    });

                                    var minPriceInput = document.getElementById('minPrice');
                                    var maxPriceInput = document.getElementById('maxPrice');

                                    priceSlider.noUiSlider.on('update', function (values, handle) {
                                        if (handle === 0) {
                                            minPriceInput.value = values[0];
                                        } else {
                                            maxPriceInput.value = values[1];
                                        }
                                    });

                                    minPriceInput.addEventListener('change', function () {
                                        priceSlider.noUiSlider.set([this.value || 0, null]);
                                    });

                                    maxPriceInput.addEventListener('change', function () {
                                        priceSlider.noUiSlider.set([null, this.value || highestPrice]);
                                    });

                                    // Sync the slider with initial values
                                    minPriceInput.value = 0;
                                    maxPriceInput.value = highestPrice;
                                    priceSlider.noUiSlider.set([minPriceInput.value, maxPriceInput.value]);
                                });
                                ;
                            </script>


                        </div>

                    </div>

                    <div class="site-section site-blocks-2">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                    <a class="block-2-item" href="SearchCategoriesController?category=Bracelet">
                                        <figure class="image">
                                            <img src="images/VongtaykimloaiHeliosXichFreedomhopkimV2VTKL0013_1_460x.webp" alt="" class="img-fluid">
                                        </figure>
                                        <div class="text">
                                            <span class="text-uppercase">Collections</span>
                                            <h3>Bracelet</h3>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                    <a class="block-2-item" href="SearchCategoriesController?category=Chain">
                                        <figure class="image">
                                            <img src="images/DSC07762_460x.webp" alt="" class="img-fluid">
                                        </figure>
                                        <div class="text">
                                            <span class="text-uppercase">Collections</span>
                                            <h3>Chain</h3>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                    <a class="block-2-item" href="SearchCategoriesController?category=Earring">
                                        <figure class="image">
                                            <img src="images/DSC08543_460x.jpg" alt="" class="img-fluid">
                                        </figure>
                                        <div class="text">
                                            <span class="text-uppercase">Collections</span>
                                            <h3>Earring</h3>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-sm-6 col-md-6 col-lg-4 mb-4 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                    <a class="block-2-item" href="SearchCategoriesController?category=Ring">
                                        <figure class="image">
                                            <img src="images/DSC07762_460x.webp" alt="" class="img-fluid">
                                        </figure>
                                        <div class="text">
                                            <span class="text-uppercase">Collections</span>
                                            <h3>Ring</h3>
                                        </div>
                                    </a>
                                </div>

                                <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                    <a class="block-2-item" href="SearchCategoriesController?category=Pendant">
                                        <figure class="image">
                                            <img src="images/MatDayChuyenBacS925.jpg" alt="" class="img-fluid">
                                        </figure>
                                        <div class="text">
                                            <span class="text-uppercase">Collections</span>
                                            <h3>Pendant</h3>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-6 col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                                    <a class="block-2-item" href="SearchCategoriesController?category=Pendant">
                                        <figure class="image">
                                            <img src="images/HopgoBlake_2_460x.webp" alt="" class="img-fluid">
                                        </figure>
                                        <div class="text">
                                            <span class="text-uppercase"></span>
                                            <h3>Other..</h3>
                                        </div>
                                    </a>
                                </div>
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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.5.0/nouislider.min.js"></script>


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