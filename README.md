# inditex-ecommerce
Inditex demo app in Java 17.

# How to run app localy?
-1 Run clean, compile and install maven commands to build project and download dependencies


<img width="1413" alt="Captura de pantalla 2023-12-07 a la(s) 4 31 17 a m" src="https://github.com/brunokiryluk/inditex-ecommerce/assets/51805262/0c071ddc-f8e6-4357-82cb-563fe93f74bc">


2-  Click "play" button in InditexEcommerceApplication class to run project.


<img width="922" alt="Captura de pantalla 2023-12-07 a la(s) 4 33 54 a m" src="https://github.com/brunokiryluk/inditex-ecommerce/assets/51805262/d0f4021a-ebd9-4b20-aa6d-7999caee831d">

# How to see H2 database user interface?
-1 Once you have your app set and running, go to this url: http://localhost:8080/h2-console
You will see something like this:


<img width="808" alt="Captura de pantalla 2023-12-07 a la(s) 4 43 12 a m" src="https://github.com/brunokiryluk/inditex-ecommerce/assets/51805262/776f17a0-08a8-481c-a353-efbfc2473fbe">

Put "password" as password. Password's value is in application.properties file, in variable spring.datasource.password=password.
Once you enter your password, you will see H2 interface.

<img width="798" alt="Captura de pantalla 2023-12-07 a la(s) 4 47 41 a m" src="https://github.com/brunokiryluk/inditex-ecommerce/assets/51805262/699f3154-cc36-4f64-90b0-9e8cb40e63e1">

# Swagger documentation
To see swagger docs, enter this url: http://localhost:8080/doc/swagger-ui/index.html#/
