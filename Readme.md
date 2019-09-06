Project#2. Trip Planner. Alexander Gavrilyuk

REST-application, with which you can:
- See places for your trip;
- Create, delete, update your trip;
- Comment places;
- Place rate for place;

Methods:

/showAllPlaces - show all places to trip (no parameters);

/showTripsByUser - show all trips by different user (User user as parameter);

/showPlacesByCountry - show all trips by different country (String country as parameter);

/showPlacesByTrip - how all trips by different trip (Trip trip as parameter);

/addTrip - add trip (Trip trip as parameter);

/deleteTrip/{id} - delete trip by id (trip id as parameter);

/editTrip/{id} - edit trip (Long oldTripId, Trip newTrip as parameters);

/commentPlace - place your comment to Place (Comment comment as parameter);

/ratePlace - place your rate to Place (Rate rate as parameter);



