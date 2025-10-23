const fornavn = document.getElementById('fornavn');
const etternavn = document.getElementById("etternavn");
const mobil = document.getElementById("mobil");
const passord = document.getElementById("passord");
const bekreftPassord = document.getElementById("bekreftPassord");
const hidden = document.querySelector('.hidden');
const button = document.getElementById("button");

button.addEventListener('click', (e) => {

    e.preventDefault();
    if(!fornavn.checkValidity() || fornavn.value.trim() === '') {
        fornavn.setCustomValidity('Fornavn må inneholde mellom 2-20 tegn');
        fornavn.reportValidity();

    }

    else {
        fornavn.setCustomValidity('');
        fornavn.reportValidity();
        fornavn.style.borderColor = "lime";
    }


})
