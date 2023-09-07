# maria-bonita-skincare-routine-api

## Presentation

I created this project thinking about today's modern women, who with work, studies and family don't have time to think 
about a skin care routine or to research good products that match their skin and wallet, but even so they still want to 
have a me time and a beautiful skin.

## How the application works: 

The user answers a questionnaire of enums where she will respond:
* skin type (dry, oily, normal or combination),
* age (over 50 years old anti age products will be recommended),
* sensitive skin or not
* pigmented skin or not
* how much she wants to spend on her routine ($, $$, $$$) .

And then the magic happens. She will be presented with a 5-step skin care routine plus a bonus of two products.

The 5-step routine consists of:
* Step 1: Cleanser,
* Step 2 :Tonic,
* Step 3 :Serum,
* Step 4 :Moisturizer,
* Step 5 :Sunscreen.

And in the bonus there will be two more steps:
* Time to Glow: which are made of a serum or a moisturizer that gives a glow effect on the skin to be used on special occasions.
* Twice a Week: which are made of a mask, a scrub or a peeling to be used twice a week to boost skin health.

## Construction: 

The application uses Spring Boot technology and MySql database to store all the data that is managed by JPA and has a Bearer Authentication 
implemented with Spring Security to protect login and password.

I used  models with Parent/Child relationships and implemented the JPA Inheritance strategy Table per Class to connect the table Products with 
the tables Category, SkinType and Features and to implement the logic of the application that I'm still working on. All of the REST API routes 
are tested with the API Testing tool Insomnia.


