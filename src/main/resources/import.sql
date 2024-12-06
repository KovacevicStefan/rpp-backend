----------- turisticka_agencija -----------------------------------------------------

INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Travel Point', 'Bulevar Mihaila Pupina 10a', '+381 11 213 81 45');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Putolovac', 'Knez Mihailova 4', '+381 11 263 54 88');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'GlobeTrekker', 'Bulevar Kralja Aleksandra 52', '+381 11 344 25 01');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Adria Tour', 'Gospodar Jevremova 15', '+381 11 263 81 22');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Travel Service', 'Knez Danilova 24', '+381 11 218 47 12');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Globus Tours', 'Bulevar Despota Stefana 107', '+381 11 344 08 88');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Fly&Go', 'Resavska 31', '+381 11 262 32 22');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Exotic Travel', 'Kraljice Marije 17', '+381 11 323 44 55');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'City Breaks', 'Kralja Petra 56', '+381 11 218 68 47');
INSERT INTO "turisticka_agencija"("id", "naziv", "adresa", "kontakt") VALUES(nextval('TURAG_SEQ'), 'Bon Voyage', 'Svetogorska 10', '+381 11 344 19 11');

----------- destinacija -----------------------------------------------------

INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Pariz', 'Francuska', 'Grad svetlosti i ljubavi');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Njujork', 'SAD', 'Grad koji nikad ne spava');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Tokio', 'Japan', 'Grad moderne tehnologije');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Rio de Zaneiro', 'Brazil', 'Grad karnevala');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Sidnej', 'Australija', 'Grad Operne kuce');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Budimpešta', 'Madjarska', 'Grad mostova');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Atina', 'Grcka', 'Grad anticke civilizacije');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Seul', 'Juzna Koreja', 'Grad modernih zgrada i tradicionalne kulture');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Zagreb', 'Hrvatska', 'Grad muzeja i katedrala');
INSERT INTO "destinacija"("id", "mesto", "drzava", "opis") VALUES(nextval('DESTINACIJA_SEQ'), 'Dubrovnik', 'Hrvatska', 'Grad zidina i mediteranske arhitekture');


----------- hotel -----------------------------------------------------

INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Cezar', 4, 'elegantan i moderan hotel', 2);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Sunny', 3, 'hotel sa bazenom i pogledom na more', 5);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Plaza', 5, 'ekskluzivni hotel u centru grada', 7);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Grand Hotel', 4, 'luksuzan hotel sa spa centrom', 4);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Savoy', 5, 'hotel sa odlicnim pogledom na grad', 8);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Serenity', 3, 'hotel za odmor i relaksaciju', 9);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Sapphire', 5, 'ekskluzivni hotel u turistickom naselju', 3);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Paradise', 4, 'hotel sa velikim brojem sadrzaja za decu', 6);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Classic', 3, 'hotel sa tradicionalnim dekorom', 10);
INSERT INTO "hotel"("id", "naziv", "broj_zvezdica", "opis", "destinacija") VALUES (nextval('HOTEL_SEQ'), 'Hotel Premier', 4, 'hotel sa modernim dizajnom', 1);

----------- aranzman -----------------------------------------------------

INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 28000, false, to_date('20.07.2023.', 'dd.mm.yyyy.'), 8, 9);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 31000, false, to_date('03.05.2023.', 'dd.mm.yyyy.'), 8, 7);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 28000, true, to_date('07.06.2023.', 'dd.mm.yyyy.'), 3, 9);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 17000, false, to_date('14.07.2023.', 'dd.mm.yyyy.'), 2, 5);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 15000, true, to_date('12.08.2023.', 'dd.mm.yyyy.'), 6, 4);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 23000, true, to_date('16.04.2023.', 'dd.mm.yyyy.'), 5, 10);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 25000, false, to_date('30.03.2023.', 'dd.mm.yyyy.'), 9, 3);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 14000, true, to_date('01.09.2023.', 'dd.mm.yyyy.'), 4, 1);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 29000, true, to_date('19.05.2023.', 'dd.mm.yyyy.'), 1, 6);
INSERT INTO "aranzman"("id", "ukupna_cena", "placeno", "datum_realizacije", "hotel", "turisticka_agencija") VALUES (nextval('ARANZMAN_SEQ'), 21000, false, to_date('22.06.2023.', 'dd.mm.yyyy.'), 10, 2);