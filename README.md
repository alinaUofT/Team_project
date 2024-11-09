### **Team:** <br />
Alina Tiemiertiei, alinaUofT <br />
Rhea Sharma, RSharma-png <br />
Alice Guo, aliceguo050 <br />
Nehir Arpat, nehirarpat <br />
Wyatt Anderson, Jellyfish1996 <br />

### **Use Cases** 
Team Use Cases:
- As a new user, I want to create an account, so that I can use this application.
  - User is shown to the Login/create account screen 
  - User clicks “Create new account” button 
  - User is taken to the New Account screen.
    - On screen, there are text fields for Username, Password, and Re-enter Password. 
  - User fills in all the fields accordingly. 
  - User clicks the “Create New Account” button. 
    - If Username is taken, then an error message (Username is taken) is shown on the same screen, and the user is prompted to try a different username. 
    - If Passwords do not match, then an error message (Passwords are not the same) is shown on the same screen, and the user is prompted to re enter the matching passwords 
    - If no errors, then a confirmation message (Account Created) is shown, and the user is taken to the survey screens. 
      - After successful completion of the survey, take the user to the Home screen.
UI Sketch:
      
- As a user, I want to log into my account, so that I can use this application. 
  - User is shown to the Login/create account screen 
  - User enters their username and password. 
  - User clicks “Login” button 
    - If the username is not stored in our database, then an error message (Incorrect Username) is shown on the same screen, and the user is prompted to re-enter a different username or to create a new account 
    - If the password does not match the associated username, then an error message (Incorrect Password) is shown on the same screen, and the user is prompted to re-enter a different password 
    - If no errors, then a confirmation message of successful login is shown, and the user is taken to the Home screen
UI Sketch:
  
- As a user, I want to log out of my account, so that I can exit this application. 
  - User is on the Home screen. 
  - User clicks “Logout” button 
  - User is taken to Login/create account screen
UI Sketch:

- As a new user, I want to take an initial survey to establish my preferences so that I can get generated default recommendations.
  - User is shown Survey screen 1
  - User select 3 of their favourite genres by clicking the associated buttons
    - If the user clicks less than 3 genres, they will not be able to submit (the button will be grey). Once the user selects 3 genres, the Submit button will turn green and is click-able.
    - When the user clicks on a genre button, borders will appear around it, suggesting that the box had been clicked
  - Once user is done, user clicks the “Submit” button, and is taken to Survey screen 2
  - On Survey screen 2, the user searches and selects 3 movies that they’ve previously watched.
    - If they search for a movie that does not match any titles in our database, an error message will appear (No movie found), and the user is prompted to re-enter a different movie name
    - If there are no errors, a confirmation message (Movie selected) will appear. 
    - If the user selects less than 3 movies, they will not be able to submit (the button will be grey). Once the user selects 3 genres, the Submit button will turn green and is click-able.
  - Once user is done, user clicks the “Submit” button, and is taken to Home screen
  - User is taken to Home screen and is shown a pop-up window (now you can view your recommendations below)
UI Sketch:

- As a user, I want to get recommendations based on movies that I watched previously so that I can find new movies. User is recommended a movie.
  - User is on the Home screen.
  - User clicks on “Recommendation” button
  - User is taken to Recommendation screen, where they can view a list of movies recommended by the program
    - Users can click on the movies to access additional information (See Use case)
    - After clicking, users can click the “I’ve watched this movie” button
UI Sketch:


