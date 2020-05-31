INSERT INTO aircrafts(aircraft_code, model, range) VALUES('CR2','{""en"": ""Bombardier CRJ-200"", ""ru"": ""Бомбардье CRJ-200""}',2700);
INSERT INTO seats(aircraft_code, seat_no, fare_conditions) VALUES(319,'4D','Business');
INSERT INTO airports(airport_code, airport_name, city, coordinates, timezone) VALUES('VVO','{""en"": ""Vladivostok International Airport"", ""ru"": ""Владивосток""}','{""en"": ""Vladivostok"", ""ru"": ""Владивосток""}','(132.147994995117,43.398998260498)','Asia/Vladivostok');
INSERT INTO bookings(book_ref, book_date, total_amount) VALUES('00000F','2017-07-05 03:12:00+03',265700.00);
INSERT INTO tickets(ticket_no, book_ref, passenger_id, passanger_name, contact_data) VALUES(0005432000988,'06B046',8499 420203,'EVGENIYA ALEKSEEVA','{""phone"": ""+70378089255""}');
INSERT INTO ticket_flights(ticket_no, flight_id, fare_conditions, amount) VALUES(0005432159776,30625,'Business',42100.00);
INSERT INTO flights(flight_id, flight_no, scheduled_departure, scheduled_arrival, departure_airport, arrival_airport, status, aircraft_code, actual_departure, actual_arrival) VALUES(14,'PG0402','2017-08-06 12:25:00+03','2017-08-06 13:20:00+03','DME','LED','Arrived','321,2017-08-06 12:28:00+03','2017-08-06 13:23:00+03');
INSERT INTO boarding_passes(ticket_no, flight_id, boarding_no, seat_no) VALUES(0005435212357,30625,5,'11A');