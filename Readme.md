Project#2. Trip Planner. Alexander Gavrilyuk

REST-application, with which you can:
- See places for your trip;
- Create, delete, update your trip;
- Comment places;
- Place rate for place;

Project IP - http://127.0.0.1:8080/

Methods:

Place Methods:

/showAllPlaces - show all places to trip (no parameters);

/showPlacesByCountry - show all trips by different country (String country as parameter);

/showPlacesByTrip - how all trips by different trip (Trip trip as parameter);

Trip Methods:

/showTripsByUser - show all trips by different user (User user as parameter);

/addTrip - add trip (Trip trip as parameter);
Body
{
"tripName" : "YourTripName",
"tripDate" : "2019-09-06"
}

/deleteTrip/{id} - delete trip by id (trip id as parameter);

/editTrip/{id} - edit trip (Long oldTripId, Trip newTrip as parameters);

Comment Methods:

/commentPlace - place your comment to Place (Comment comment as parameter);
Body
{
"tripName" : "YourTripName",
"tripDate" : "2019-09-06"
}

/ratePlace - place your rate to Place (Rate rate as parameter);
Body
{
"date" : "2019-09-06",
"userName" : "UserCommentName",
"comment" : "YourStringComment"
}

User Methods:

/addUser - add new user (User user as parameter);
Body
{
"userName" : "YourUserName",
"email" : "youruseremail@domain.com"
}

/deleteUser/{id} - delete user by userId (Long id as parameter);

/editUser/{id} - delete user by userId (Long id and User user as parameter).



