--Couriers
INSERT INTO public.couriers(courier_id, courier_name, courier_surname) VALUES (1, 'James', 'Wang');
INSERT INTO public.couriers(courier_id, courier_name, courier_surname) VALUES (2, 'Smith', 'Williams');
INSERT INTO public.couriers(courier_id, courier_name, courier_surname) VALUES (3, 'Mary', 'Brown');

--Stores
INSERT INTO public.stores(store_id, store_name) VALUES (1, 'Ataşehir MMM Migros');
INSERT INTO public.stores(store_id, store_name) VALUES (2, 'Novada MMM Migros');
INSERT INTO public.stores(store_id, store_name) VALUES (3, 'Beylikdüzü 5M Migros');
INSERT INTO public.stores(store_id, store_name) VALUES (4, 'Ortaköy MMM Migros');
INSERT INTO public.stores(store_id, store_name) VALUES (5, 'Caddebostan MMM Migros');

--Geolocations of Stores
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, store_id) VALUES (1, 40.9923307, 29.1244229, 1);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, store_id) VALUES (2, 40.986106, 29.1161293, 2);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, store_id) VALUES (3, 41.0066851, 28.6552262, 3);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, store_id) VALUES (4, 41.055783, 29.0210292, 4);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, store_id) VALUES (5, 40.9632463, 29.0630908, 5);

--Geolocations of Couriers
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, courier_id) VALUES (6, 40.8764512, 29.3164275, 1);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, courier_id) VALUES (7, 38.7856212, 31.7946251, 2);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, courier_id) VALUES (8, 35.9784611, 30.6447546, 2);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, courier_id) VALUES (9, 27.4948151, 13.4645124, 3);
INSERT INTO public.geolocations(geolocation_id, latitude, longitude, courier_id) VALUES (10, 28.6411351, 37.4679241,3);