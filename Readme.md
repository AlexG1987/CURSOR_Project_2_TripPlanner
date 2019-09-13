Project#2. Trip Planner. Alexander Gavrilyuk

REST-application, with which you can:
- See places for your trip;
- Create, delete, update your trip;
- Comment places;
- Place rate for place;

Project IP - http://127.0.0.1:8080/

Methods:

Place Methods (/places):

/addPlace - add new place
Body
{
"placeName": "YourPlaceName",
"country": "yourCountry"
}

/commentPlace - comment place (Place place)
Body
{
"tripName": "YourTripName",
"tripDate": "2019-09-06"
}

/RatePlace - rate place
Body
{
"date" : "2019-09-06",
"userName": "UserCommentName",
"comment": "YourStringComment"
}

/showAllPlaces - show all places to trip;

/showPlacesByCountry - show all trips by different country (String country);

/showPlacesByTrip - how all trips by different trip (Long tripId);


Trip Methods (/trips):

/addTrip - add trip (Trip trip);
Body
{
"tripName": "YourTripName",
"tripDate": "2019-09-06"
}

/deleteTrip/{id} - delete trip by id (Long tripId);

/editTrip/{id} - edit trip (Long oldTripId, Trip newTrip);

/addPlaceToTrip (Long userId, Long tripId, Long placeId)

/removePlaceFromTrip (Long userId, Long tripId, Long placeId)

/shareTripWhitOtherUser/user/{userId}/trip/{tripId} - share trip with other users (Long userId, Long tripId)


User Methods (/users):

/addUser - add new user (User user);
Body
{
"userName": "YourUserName",
"email": "youruseremail@domain.com"
}

/deleteUser/{id} - delete user by userId (Long id);

/editUser/{id} - delete user by userId (Long id, User user).



