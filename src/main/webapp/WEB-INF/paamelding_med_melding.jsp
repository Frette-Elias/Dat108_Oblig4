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
	<p style="color:red;">${feilmelding}</p>

    <div id="root">
        <fieldset id="paamelding">
            <legend>Påmelding</legend>
            <form id="paamelding-skjema" action="paamelding_med_melding" method="post">
                <div class="inputfelt">
                    <label for="fornavn">Fornavn</label>
                    <input type="text" id="fornavn" name="fornavn" value="${deltager.fornavn}" placeholder="Fornavn på deltager" autocomplete="off" size="40"
                           pattern="^(?=.{2,20}$)[A-Za-zÆØÅæøå]+(?:-[A-Za-zÆØÅæøå]+)*$" required
                           title="Kun bokstaver og bindestrek (ikke først/sist)">
                </div>
                <div class="inputfelt">
                    <label for="etternavn">Etternavn</label>
                    <input type="text" id="etternavn" name="etternavn" value="${deltager.etternavn}" placeholder="Etternavn på deltager" autocomplete="off" size="40"
                           pattern="^(?=.{2,20}$)[A-Za-zÆØÅæøå]+(?:-[A-Za-zÆØÅæøå]+)*$" required
                           title="Kun bokstaver og bindestrek (ikke først/sist)">
                </div>
                <div class="inputfelt">
                    <label for="mobil">Mobil (8 siffer)</label>
                    <input type="tel" id="mobil" name="mobil" value="${deltager.mobil}" placeholder="12345678" pattern="^[0-9]{8}$" inputmode="numeric" required
                           title="Mobilnummer må bestå av 8 siffer">
                </div>
                <div class="inputfelt">
                    <label for="passord">Passord</label>
                    <input type="password" id="passord" name="passord" value="${deltager.passord}" placeholder="Passord" autocomplete="off" size="20"
                           pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required
                           title="Passord må inneholde minst 8 tegn, en stor bokstav, en liten bokstav og et tall">
                </div>
                <div class="inputfelt">
                    <label for="bekreftPassord">Bekreft Passord</label>
                    <input type="password" id="bekreftPassord" name="bekreftPassord" value="${deltager.bekreftPassord}" placeholder="Bekreft Passord" autocomplete="off" size="20" required>
                </div>

                <div class="inputfelt">
                    <span>Kjønn</span>
                    <div class="kjonn">
                        <label>
                            <input type="radio" id="mann" name="kjonn" value="Mann" required> Mann
                        </label>
                        <label>
                            <input type="radio" id="kvinne" name="kjonn" value="Kvinne"> Kvinne
                        </label>
                    </div>
                </div>
                <button id="button" type="submit">Meld meg på</button>
            </form>
        </fieldset>
    </div>

</body>
</html>
