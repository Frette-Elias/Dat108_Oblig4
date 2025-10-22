<!DOCTYPE html>
<html lang="no">
<head>
	<link href="/css/simple.css" rel="stylesheet" type="text/css" />
	<script src="/js/myscript.js" defer></script>
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<p style="color:red;">Påmeldingsdetaljer er ugyldige</p>

    <div id="root">
        <fieldset id="paamelding">
            <legend>Påmelding</legend>
            <div id="input">
                <label for="fornavn">Fornavn</label>
                <input type="text" id="fornavn" placeholder="Fornavn paa deltager" autocomplete="off" size="40" pattern="\s*\p{L}{2,}((\s+|-)\p{L}{2,})*\s*"
                       title="Tillate tegn er kun bokstaver, mellomrom og enkel bindestrek mellom delnavn">
                <label for="etternavn">Etternavn</label>
                <input type="text" id="etternavn" placeholder="Etternavn paa deltager" autocomplete="off" size="40" pattern="\s*\p{L}{2,}((\s+|-)\p{L}{2,})*\s*"
                       title="Tillate tegn er kun bokstaver, mellomrom og enkel bindestrek mellom delnavn">
                <label for="mobil">Mobilnummer</label>
                <input type="tel" id="mobil" placeholder="Mobilnummer" autocomplete="off" size="15" pattern="\s*\d{8}\s*"
                       title="Mobilnummer må bestå av 11 siffer">
                <label for="passord">Passord</label>
                <input type="password" id="passord" placeholder="Passord" autocomplete="off" size="20" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                       title="Passord må inneholde minst 8 tegn, en stor bokstav, en liten bokstav og et tall">
                <label for="bekreftPassord">Bekreft Passord</label>
                <input type="password" id="bekreftPassord" placeholder="Bekreft Passord" autocomplete="off" size="20">
                <div id="kjonn">
                    <span>Kjonn</span>
                    <label for="mann">Mann</label> <input type="radio" id="mann" name="kjonn" value="mann">
                    <label for="kvinne">Kvinne</label>
                    <input type="radio" id="kvinne" name="kjonn" value="kvinne">
                </div>
                <button type="submit">Meld meg paa</button>




            </div>


        </fieldset>

    </div>

	<!-- Jeg har fjernet alt som har med form og input å gjøre,
		 siden dette er pensum. Her får dere sette opp skjemaet
		 selv. Lykke til.
	-->

</body>
</html>
