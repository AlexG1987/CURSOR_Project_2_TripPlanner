Project#2. Trip Planner. Alexander Gavrilyuk

REST-application, with which you can:
- See places for your trip;
- Create, delete, update your trip;
- Comment places;
- Place rate for place;

Project IP - http://127.0.0.1:8080/

Methods:

Place Methods (/place):

/ (GET) - add new place
Body
{
"placeName": "YourPlaceName",
"country": "yourCountry"
}

/comment (PUT) - comment place (Place place)
Body
{
"tripName": "YourTripName",
"tripDate": "2019-09-06"
}

/rate (POST - rate place
Body
{
"date" : "2019-09-06",
"userName": "UserCommentName",
"comment": "YourStringComment"
}

/all (GET) - show all places to trip;

/country (GET) - show all trips by different country (String country);

/{tripId} (GET) - how all trips by different trip (Long tripId);


Trip Methods (/trip):

/{userId} (GET) - show all trips by iser ID (Long userId)

/ (POST) - add trip (Trip trip);
Body
{
"tripName": "YourTripName",
"tripDate": "2019-09-06"
}

/{id} (DELETE) - delete trip by id (Long tripId);

/{id} (PATCH) - edit trip (Long oldTripId, Trip newTrip);

/place (POST) - add place to trip (Long userId, Long tripId, Long placeId) 

/place{userId}{tripId}{placeId} (DELETE) - delete place from trip (Long userId, Long tripId, Long placeId)

/share{userId}{tripId} (POST) - share trip with other users (Long userId, Long tripId)


User Methods (/users):

/ (POST) - add new user (User user);
Body
{
"userName": "YourUserName",
"email": "youruseremail@domain.com"
}

/{id} (DELETE) - delete user by userId (Long id);

/{id} (PATCH) - delete user by userId (Long id, User user).



