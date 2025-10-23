<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<link href="/css/simple.css" rel="stylesheet" type="text/css" />
	<script src="/js/myscript.js" defer></script>
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<p class="hidden" style="color:red;">Påmeldingsdetaljer er ugyldige</p>

    <div id="root">
        <fieldset id="paamelding">
            <legend>Påmelding</legend>
            <form id="input" action="paamelding" method="get">
                <label for="fornavn">Fornavn</label>
                <input type="text" id="fornavn" placeholder="Fornavn på deltager"  autocomplete="off" size="40" required pattern="\s*\p{L}{2,}((\s+|-)\p{L}{2,})*\s*"
                       title="Tillate tegn er kun bokstaver, mellomrom og enkel bindestrek mellom delnavn">
                <label for="etternavn">Etternavn</label>
                <input type="text" id="etternavn" placeholder="Etternavn på deltager" autocomplete="off" size="40" pattern="\^[A-Za-zÆØÅæøå\-]{2,20}$"
                       title="Tillate tegn er kun bokstaver, mellomrom og enkel bindestrek mellom delnavn">
                <label for="mobil">Mobil (8 siffer)</label>
                <input type="tel" id="mobil" placeholder="123 45 678"  pattern="^[0-9]{8}$" inputmode="numeric"
                       title="Mobilnummer må bestå av 8 siffer">
                <label for="passord">Passord</label>
                <input type="password" id="passord" placeholder="Passord" autocomplete="off" size="20" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                       title="Passord må inneholde minst 8 tegn, en stor bokstav, en liten bokstav og et tall">
                <label for="bekreftPassord">Bekreft Passord</label>
                <input type="password" id="bekreftPassord" placeholder="Bekreft Passord" autocomplete="off" size="20">

                <div>Kjønn</div>
                <div class="kjonn">
                    <label for="mann">Mann</label>
                    <input type="radio" id="mann" name="kjonn" value="mann">
                    <label for="kvinne">Kvinne</label>
                    <input type="radio" id="kvinne" name="kjonn" value="kvinne">
                </div>
                <button id="button" type="submit">Meld meg på</button>

            </form>
        </fieldset>
    </div>

</body>
</html>
