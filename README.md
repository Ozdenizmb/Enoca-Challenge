# Enoca Challenge

<h1>
This repository is a challenge project provided for the JAVA Developer - CX position recruitment at Enoca Company.</h1>

<p>Things you need to pay attention to for the Spring project to run successfully:</p>

<h3>1. Install the PostgreSQL database on your computer.</h3>

<p>Within the project, database tables are automatically created using Flyway. Since Flyway is configured to work specifically with PostgreSQL, errors may occur when using other databases.</p>

<h3>2. Configure yaml file</h3>

<p>Update the database's username and password information to be compatible with your own database.</p>
<p>Make sure you have a database named ecommerce_db</p>

<h3>3. Congratulations! You can now run the project 🎉</h3>

<p>After running the project, you can navigate to "http://localhost:9001/docs/swagger-ui/index.html#/" to use the endpoints through the Swagger documentation.</p>

<br><br><br><br>

<h2>Technologies Used</h2>

<ul>
<li>Java 23</li>
<li>Spring Boot 3.4.0</li>
<li>Spring Data JPA</li>
<li>Spring Security</li>
<li>Postgresql</li>
<li>Flyway</li>
<li>Spring Starter Validation</li>
<li>Springdoc Openapi Swagger</li>
<li>Mapstruct</li>
<li>Lombok</li>
</ul>

<h1>Services</h1>

![Screenshot_1](https://github.com/user-attachments/assets/7736afa2-ba8e-4696-852e-d675c277a177)
<br>
<p><b>BASE APİ: </b><i>http://localhost:9001</i></p>
<br><br>

<h2>Customer</h2>

![Screenshot_2](https://github.com/user-attachments/assets/15f78735-c64c-4526-bebf-6600146842f2)
<br>
<p><b>ADD CUSTOMER</b></p>
<p><i>/api/v1/customers/signup</i></p>
<p><b>LOGIN CUSTOMER</b></p>
<p><i>/api/v1/customers/login/{EMAIL}?password={PASSWORD}</i></p>
<p><i>{If the login process is successful, place the email and password values into the request headers sent from the frontend. /{AuthService}}</i></p>
<p><b>GET CUSTOMERS</b></p>
<p><i>/api/v1/customers/get?page={PAGE}&size={SIZE}&sort=createdDate%2Cid%2CDESC</i></p>
<p><b>GET CUSTOMER WITH EMAIL</b></p>
<p><i>/api/v1/customers/get/{EMAIL}</i></p>
<p><b>UPDATE CUSTOMER</b></p>
<p><i>/api/v1/customers/update/{CUSTOMER_ID}</i></p>
<p><b>DELETE CUSTOMER</b></p>
<p><i>/api/v1/customers/delete/{CUSTOMER_ID}</i></p>
<br>

<h2>Product</h2>

![Screenshot_3](https://github.com/user-attachments/assets/7b1423bd-8a25-44a4-9073-5ad6f86e6b07)
<br>
<p><b>CREATE PRODUCTS</b></p>
<p><i>/api/v1/products/create</i></p>
<p><b>GET PRODUCTS</b></p>
<p><i>/api/v1/products/get?page={PAGE}&size={SIZE}&sort=createdDate%2Cid%2CDESC'</i></p>
<p><b>GET PRODUCT</b></p>
<p><i>/api/v1/products/get/{PRODUCT_ID}</i></p>
<p><b>GET PRODUCT WITH NAME</b></p>
<p><i>/api/v1/products/get/name/{PRODUCT_NAME}?page={PAGE}&size={SIZE}&sort=createdDate%2Cid%2CDESC</i></p>
<p><b>GET PRODUCT WİTH CATEGORY</b></p>
<p><i>/api/v1/products/get/category/{PRODUCT_CATEGORY}?page={PAGE}&size={SIZE}&sort=createdDate%2Cid%2CDESC</i></p>
<p><b>UPDATE PRODUCT</b></p>
<p><i>/api/v1/products/update/{PRODUCT_ID}</i></p>
<p><b>DELETE PRODUCT</b></p>
<p><i>/api/v1/products/delete/{PRODUCT_ID}</i></p>
<br>

<h2>Cart</h2>

![Screenshot_4](https://github.com/user-attachments/assets/acd0877e-932d-40fa-8f72-8508d5638141)
<br>
<p><b>ADD PRODUCT TO CART</b></p>
<p><i>/api/v1/carts/add/{CUSTOMER_ID}</i></p>
<p><b>REMOVE PRODUCT FROM CART</b></p>
<p><i>/api/v1/carts/remove/{CUSTOMER_ID}</i></p>
<p><b>GET CART</b></p>
<p><i>/api/v1/carts/get/{CUSTOMER_ID}</i></p>
<p><b>EMPTY CART</b></p>
<p><i>/api/v1/carts/empty/{CUSTOMER_ID}</i></p>
<br>

<h2>Order</h2>

![Screenshot_5](https://github.com/user-attachments/assets/da0f0ad6-a721-45cb-babd-877f5fdaa061)
<br>
<p><b>PLACE ORDER</b></p>
<p><i>/api/v1/orders/place/{CUSTOMER_ID}</i></p>
<p><b>GET ORDER FOR CODE</b></p>
<p><i>/api/v1/orders/get/{ORDER_ID}</i></p>
<p><b>GET ALL ORDERS FOR CUSTOMER</b></p>
<p><i>/api/v1/orders/get/customer/{CUSTOMER_ID}?page={PAGE}&size={SIZE}&sort=createdDate%2Cid%2CDESC</i></p>
<br>
