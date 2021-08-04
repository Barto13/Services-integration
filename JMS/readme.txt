CarInfoTopicProducer - "Aplikacja zainstalowana w boldzie", co 15 sekund przesyla informacje z losowo wygenerowanymi
			danymi z okreslonych zakresow
			do komponentow CarInfoTopicLogReceiver oraz CarStateMessageRouter (wykorzystano topic)

CarInfoTopicLogReceiver - komponent odbierajacy wyslana przez wyzej wymioniony komponent wiadomosc i zapisujaca
			jej tresc w pliku tekstowym Logs.txt

CarStateMessageRouter - komponent, ktory rowniez odbiera wiadomosc wyslana przez bolid, sprawdza on czy parametry
			bolidu sa ok,
			w przypadku nieznacznego ich przekroczenia wysyla kierowcy(DriverQueueReceiver)
			ostrzezenie, w przypadku znacznego ich przekroczenia informowany
			jest rowniez mechanik(MechanicQueueReceiver). Gdy parametry sa w porzadku,
			zwracana jest informacja o prawidlowosci parametrow (wykorzystane sa kolejki)

PitStopRequestProducer - komponent, ktory co 15 sekund losowo podejmuje decyzje tak/nie o wyslaniu potrzeby zjazdu
			samochodu do pitstopu(PitStopRequestReceiver), a takze odbiera informacje zwrotna 
			tak/nie odnosnie pozwolenia, ktora to rowniez jest losowo generowana.(zastosowano request-reply)


CarMessage, PitStopRequestMessage, WarningMessage - wykorzystywane modele komunikatow